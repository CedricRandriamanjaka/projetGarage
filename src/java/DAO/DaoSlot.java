/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Reservation;
import Model.Slot;
import Model.Vehicul;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Cedric
 */
public class DaoSlot {
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
            ERROR("Slot.open",e);
	}
    }
    
    private void close(){
        try{
            this.conn.close();
        }
        catch(SQLException e){
            ERROR("Slot.close",e);
        }
    }

    public boolean isValide(Slot slot){
        boolean reponse = true;
        String requet = "select * from slotparking where nameslot = '" + slot.getNameslot() + "'";
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
            ERROR("Slot.isValide",e);
        }
        return reponse;
    }
    
    

    public void newSlot(Slot v){
        String requet1 = "insert into slotparking values (default,'"+v.getNameslot()+"',";
        requet1 = requet1 + " '"+v.getLongslot()+"','"+v.getLargslot()+"','"+v.getHautslot()+"',";
        requet1 = requet1 + " '"+v.getPoidslot()+"')";
        try{
            open();
            stmt = conn.prepareStatement(requet1);			
            int ret = stmt.executeUpdate();
            close();
        }
        catch(SQLException e){
            ERROR("Slot.newSlot",e);
        }
    }
    
    public void modifSlot(Slot v){
        String requet1 = " update slotparking set nameslot='"+v.getNameslot()+"' , longslot="+v.getLongslot()+" , largslot="+v.getLargslot()+" , hautslot="+v.getHautslot()+" , poidslot="+v.getPoidslot()+" where idslot="+v.getId();
        try{
            open();
            stmt = conn.prepareStatement(requet1);			
            int ret = stmt.executeUpdate();
            close();
        }
        catch(SQLException e){
            ERROR("Slot.modifSlot",e);
        }
    }

    public ArrayList<Slot> getSlotFor(Vehicul v){
        ArrayList<Slot> list = new ArrayList();
        String longe = v.getLongvehicul();
        String larg = v.getLargvehicul();
        String haut = v.getHautvehicul();
        String poid = v.getHautvehicul();

        String request = "select * from slotparking where longslot >= "+longe+" and largslot >= "+larg+" and hautslot >= "+haut+" and poidslot >= "+poid;
        try{
            open();
            stmt = conn.prepareStatement(request);			
            ResultSet ret = stmt.executeQuery();
            while(ret.next()){
                String id = ret.getString(1);
                String name = ret.getString(2);
                longe = ret.getString(3);
                larg = ret.getString(4);
                haut = ret.getString(5);
                poid = ret.getString(6);
                Slot cache = new Slot(id,name,longe,larg,haut,poid);
                list.add(cache);
            }
            close();
        }
        catch(SQLException e){
            ERROR("Slor.getSlotFor",e);
        }
        return list;
    }
    
    public ArrayList<Slot> getSlot(boolean value){
        ArrayList<Slot> list = new ArrayList();
        String longe = new String();
        String larg = new String();
        String haut = new String();
        String poid = new String();

        String request = "select * from slotparking";
        try{
            open();
            stmt = conn.prepareStatement(request);			
            ResultSet ret = stmt.executeQuery();
            while(ret.next()){
                String id = ret.getString(1);
                String name = ret.getString(2);
                longe = ret.getString(3);
                larg = ret.getString(4);
                haut = ret.getString(5);
                poid = ret.getString(6);
                Slot cache = new Slot(id,name,longe,larg,haut,poid);
                list.add(cache);
            }
            close();
        }
        catch(SQLException e){
            ERROR("Slor.getSlot",e);
        }
        return list;
    }
    
    public Slot getSlot(String id){
        Slot s = new Slot();
        String longe = new String();
        String larg = new String();
        String haut = new String();
        String poid = new String();

        String request = "select * from slotparking where idslot= "+id;
        try{
            open();
            stmt = conn.prepareStatement(request);			
            ResultSet ret = stmt.executeQuery();
            while(ret.next()){
                String name = ret.getString(2);
                longe = ret.getString(3);
                larg = ret.getString(4);
                haut = ret.getString(5);
                poid = ret.getString(6);
                s = new Slot(id,name,longe,larg,haut,poid);
            }
            close();
        }
        catch(SQLException e){
            ERROR("Slor.getSlot2",e);
        }
        return s;
    }
    
    public boolean delete(Slot s){
        boolean reponse = true;
        String requete = "delete from slotparking where idslot="+s.getId();
        try{
            
            open();
            stmt = conn.prepareStatement(requete);			
            stmt.executeUpdate();
            reponse = true;
            close();
        }
        catch(SQLException e){
            ERROR("Slot.delete id="+s.getId(),e);
            reponse = false;
        }
        return reponse;
    }
    
}

/* PreparedStatement stmt = baj

String requet = "insert bablabl value (?,?,?)"
stmt = conn.preparedStatement(request)
stmt.setInt(int position , valeur)
stmt.setString(int position , valeur)
int ret = stmt.executeUpdate()

int ret = stmt.executeQuery() */

