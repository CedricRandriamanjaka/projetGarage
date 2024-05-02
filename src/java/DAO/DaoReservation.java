/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Client;
import Model.Reservation;
import Model.Slot;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import util.Interval;

/**
 *
 * @author Cedric
 */
public class DaoReservation {
    private Connection conn;
    private PreparedStatement stmt;
    
    private void ERROR(String errorLocation,Exception e){
		System.out.println("");
		System.out.println("//debut");
		System.out.println("//	"+"DAO.Dao."+errorLocation);
		System.out.println("//	"+e.getMessage());
		System.out.println("//fin");
		System.out.println("");
	}
    
    private void open(){
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(util.Url.getBdaUrl(),util.Url.getBdaUser(),util.Url.getBdaMdp());
//            stmt = conn.prepareStatement(a);			
        }
	catch(ClassNotFoundException | SQLException e){
            ERROR("Reservation.open",e);
	    }
    }

    public boolean isValide(Reservation reservation){
        boolean reponse = true;
        String idclient = reservation.getIdclient();
        String idvehicul = reservation.getIdvehicul();
        String datereservation = reservation.getDatereservation();
        String heure = reservation.getHeure();
        String duree = reservation.getDuree();
        String valider = reservation.getValider();

        String requet = "select * from reservation where idclient = "+idclient+" and idvehicul = "+idvehicul+" and datereservation = '"+datereservation+"' and heure = "+heure+" and duree = "+duree+" and valide = "+valider+" ";
        try{
            open();
            stmt = conn.prepareStatement(requet);			
            ResultSet ret = stmt.executeQuery();
            while(ret.next()){
                reponse = false;
            }
            close();
        }
        catch(SQLException e){
            ERROR("Reservation.isValide",e);
            reponse = false;
        }
        return reponse;
    }

    private boolean estvalideJour(Slot s,String date){
        boolean v = true;
        String requet = "select * from reservation where datereservation = '"+date+"' and idslot = '"+s.getId()+"' and valide=true";
        try{
            LocalDate localDate = LocalDate.now();
            LocalDate date1 = LocalDate.parse(date);
            if(date1.isBefore(localDate) || date1.isEqual(localDate)){
                v = false;
            }
            else{
                open();
                stmt = conn.prepareStatement(requet);			
                ResultSet ret = stmt.executeQuery();
                while(ret.next()){
                    v = false;
                }    
                close();
            }
            
        }
        catch(SQLException e){
            ERROR("Reservation.estvalideJour",e);
        }
        return v;
    }

    public ArrayList getIntervalOf(Slot s,String date){
        ArrayList<Interval> interval = new ArrayList();
        String requet = "select heure,duree from reservation where datereservation = '"+date+"' and idslot = '"+s.getId()+"' and valide=true";
        try{
            open();
            stmt = conn.prepareStatement(requet);			
            ResultSet ret = stmt.executeQuery();
            while(ret.next()){
                Interval cache = new Interval(ret.getInt(1),ret.getInt(2));
                interval.add(cache);
            }
            close();
        }
        catch(SQLException e){
            ERROR("Reservation.getIntervalOf",e);
        }
        return interval;
    }

    public boolean estvalideheure(Slot s,String date,String heure,String duree){
        // avadika interval le heuraure
        int a = Integer.parseInt(heure);
        int b = Integer.parseInt(duree);
        Interval propose = new Interval(a,b);

        boolean v = true;
        try{
            // alaina aloha le liste na aheure
            ArrayList<Interval> interval = getIntervalOf(s,date);

            // tetezina oe tafiditra anatn reo interval reo ve le hauraire ty
            for (int i = 0; i < interval.size(); i++) {
                Interval cache = interval.get(i);
                if(propose.estDans(cache)){
                    v = false;
                    break;
                }                
            }
        }
        catch(Exception e){
            ERROR("Reservation.estvalideheure",e);
        }
        return v;
    }

    public boolean estDisponible(Slot s,String date,String heure,String duree){
        boolean valider = false;
        // verifiena aloha le date reservation io ve mfanindry am date reservation ray
        if(estvalideJour(s,date)){
            // ra mifanindry le date de atsofoka anaty tableau list ana hauraure 
            if(estvalideheure(s,date,heure,duree)){
                valider = true;
            }
        }

        return valider;
    }
    
    private void close(){
        try{
            this.conn.close();
        }
        catch(SQLException e){
            ERROR("Reservation.estDisponible",e);
        }
    }

    public boolean newReservation(Reservation r){
        boolean val = false;
        String requet1 = "insert into reservation values (default,"+r.getIdclient()+","+r.getIdvehicul()+","+r.getIdslot()+",'"+r.getDatereservation()+"',"+r.getHeure()+","+r.getDuree()+","+r.getValider()+")";
        try{
            open();
            stmt = conn.prepareStatement(requet1);			
            int ret = stmt.executeUpdate();
            close();
            val = true;

        }
        catch(SQLException e){
            ERROR("Reservation.newReservation",e);
        }
        return val;
    }
    
    public ArrayList<Reservation> GetReservation(String value){
        ArrayList<Reservation> donne = new ArrayList();
        String requet = "select * from reservation where valide = "+value+" order by datereservation";
        try{
            open();
            stmt = conn.prepareStatement(requet);			
            ResultSet ret = stmt.executeQuery();
            while(ret.next()){
                String id = ret.getString(1);
                String idclient = ret.getString(2);
                String idvehicul = ret.getString(3);
                String idslot = ret.getString(4);
                String datereservation = ret.getString(5);
                String heure = ret.getString(6);
                String duree = ret.getString(7);
                String valider = ret.getString(8);
                Reservation cache = new Reservation(id,idclient,idvehicul,idslot,datereservation,heure,duree,valider);
                donne.add(cache);
            }
            close();
        }
        catch(SQLException e){
            ERROR("Reservation.GetReservation",e);
        }
        return donne;
    }
    
    public ArrayList<Reservation> GetReservation(Client c,String value){
        ArrayList<Reservation> donne = new ArrayList();
        String requet = "select * from reservation where idclient = "+c.getId()+" and valide = "+value+" order by datereservation";
        try{
            open();
            stmt = conn.prepareStatement(requet);			
            ResultSet ret = stmt.executeQuery();
            while(ret.next()){
                String id = ret.getString(1);
                String idclient = ret.getString(2);
                String idvehicul = ret.getString(3);
                String idslot = ret.getString(4);
                String datereservation = ret.getString(5);
                String heure = ret.getString(6);
                String duree = ret.getString(7);
                String valider = ret.getString(8);
                Reservation cache = new Reservation(id,idclient,idvehicul,idslot,datereservation,heure,duree,valider);
                donne.add(cache);
            }
            close();
        }
        catch(SQLException e){
            ERROR("Reservation.GetReservation2",e);
        }
        return donne;
    }
    
    public ArrayList<Reservation> GetReservation(Slot s,String value){
        ArrayList<Reservation> donne = new ArrayList();
        String requet = "select * from reservation where idslot = "+s.getId()+" and valide = "+value+" order by datereservation";
        try{
            open();
            stmt = conn.prepareStatement(requet);			
            ResultSet ret = stmt.executeQuery();
            while(ret.next()){
                String id = ret.getString(1);
                String idclient = ret.getString(2);
                String idvehicul = ret.getString(3);
                String idslot = ret.getString(4);
                String datereservation = ret.getString(5);
                String heure = ret.getString(6);
                String duree = ret.getString(7);
                String valider = ret.getString(8);
                Reservation cache = new Reservation(id,idclient,idvehicul,idslot,datereservation,heure,duree,valider);
                donne.add(cache);
            }
            close();
        }
        catch(SQLException e){
            ERROR("Reservation.GetReservation3",e);
        }
        return donne;
    }

    public void annule(String id){
        ArrayList<Reservation> donne = new ArrayList();
        String requet = "update reservation set valide = false where idreservation = "+id;
        try{
            open();
            stmt = conn.prepareStatement(requet);			
            stmt.executeQuery();
            close();
        }
        catch(SQLException e){
            ERROR("Reservation.annule",e);
        }
    }
    
    public boolean delete(Reservation s){
        boolean reponse = true;
        String requete = "delete from reservation where idreservation="+s.getId();
        try{
            open();
            stmt = conn.prepareStatement(requete);			
            stmt.executeUpdate();
            reponse = true;
            close();
        }
        catch(SQLException e){
            ERROR("Reservation.delete",e);
            reponse = false;
        }
        return reponse;
    }
}
