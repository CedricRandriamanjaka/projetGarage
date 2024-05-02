/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

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
public class DaoVehicul {
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
            ERROR("Vahicul.open",e);
	}
    }
    
    private void close(){
        try{
            this.conn.close();
        }
        catch(SQLException e){
            ERROR("Vahicul.close",e);
        }
    }

    public boolean isValide(Vehicul vehicul){
        boolean reponse = true;
        String requet = "select * from vehicul where matriculationvahicul = '" + vehicul.getMatriculationvahicul() + "'";
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
            ERROR("Vehicul.isValide",e);
        }
        return reponse;
    }

    public void newVehicul(Vehicul v){
        String requet1 = "insert into vehicul values (default,'"+v.getIdclient()+"',";
        requet1 = requet1 + " '"+v.getTypevehicul()+"','"+v.getMarquevehicul()+"','"+v.getModelvehicul()+"',";
        requet1 = requet1 + " '"+v.getColorvehicul()+"','"+v.getMatriculationvahicul()+"','"+v.getLongvehicul()+"',";
        requet1 = requet1 + " '"+v.getLargvehicul()+"','"+v.getHautvehicul()+"','"+v.getPoidvehicul()+"')";
        try{
            open();
            stmt = conn.prepareStatement(requet1);			
            int ret = stmt.executeUpdate();
            close();
        }
        catch(SQLException e){
            ERROR("Vehicul.newVehicul",e);
        }
    }

    public Vehicul getVehicul(String id){
        Vehicul v = new Vehicul();
        String requet = "select * from vehicul where idvehicul = '"+id+"'";
        try{
            open();
            stmt = conn.prepareStatement(requet);			
            ResultSet ret = stmt.executeQuery();
            while(ret.next()){
                String idV = ret.getString(1);
                String idC = ret.getString(2);
                String typevehicul = ret.getString(3);
                String marquevehicul = ret.getString(4);
                String modelvehicul = ret.getString(5);
                String colorvehicul = ret.getString(6);
                String matriculationvahicul = ret.getString(7);
                String longvehicul = ret.getString(8);
                String largvehicul = ret.getString(9);
                String hautvehicul = ret.getString(10);
                String poidvehicul = ret.getString(11);
                v = new Vehicul(idV,idC,typevehicul,marquevehicul,modelvehicul,colorvehicul,matriculationvahicul,longvehicul,largvehicul,hautvehicul,poidvehicul);
            }
            close();
        }
        catch(SQLException e){
            ERROR("Vehicul.getVehicul",e);
        }
        return v;
    }

    public ArrayList<Vehicul> VehiculOf(String id){
        ArrayList<Vehicul> donne = new ArrayList();
        String requet = "select * from vehicul where idclient = '"+id+"'";
        try{
            open();
            stmt = conn.prepareStatement(requet);			
            ResultSet ret = stmt.executeQuery();
            while(ret.next()){
                String idV = ret.getString(1);
                String idC = ret.getString(2);
                String typevehicul = ret.getString(3);
                String marquevehicul = ret.getString(4);
                String modelvehicul = ret.getString(5);
                String colorvehicul = ret.getString(6);
                String matriculationvahicul = ret.getString(7);
                String longvehicul = ret.getString(8);
                String largvehicul = ret.getString(9);
                String hautvehicul = ret.getString(10);
                String poidvehicul = ret.getString(11);
                Vehicul cache = new Vehicul(idV,idC,typevehicul,marquevehicul,modelvehicul,colorvehicul,matriculationvahicul,longvehicul,largvehicul,hautvehicul,poidvehicul);
                donne.add(cache);
            }
            close();
        }
        catch(SQLException e){
            ERROR("Vehicul.VehiculOf",e);
        }
        return donne;
    }

    public ArrayList<Vehicul> AllVehicul(){
        ArrayList<Vehicul> donne = new ArrayList();
        String requet = "select * from vehicul order by idclient";
        try{
            open();
            stmt = conn.prepareStatement(requet);			
            ResultSet ret = stmt.executeQuery();
            while(ret.next()){
                String idvahicul = ret.getString(1);
                String idclient = ret.getString(2);
                String typevehicul = ret.getString(3);
                String marquevehicul = ret.getString(4);
                String modelvehicul = ret.getString(5);
                String colorvehicul = ret.getString(6);
                String matriculationvahicul = ret.getString(7);
                String longvehicul = ret.getString(8);
                String largvehicul = ret.getString(9);
                String hautvehicul = ret.getString(10);
                String poidvehicul = ret.getString(11);
                Vehicul cache = new Vehicul(idvahicul,idclient,typevehicul,marquevehicul,modelvehicul,colorvehicul,matriculationvahicul,longvehicul,largvehicul,hautvehicul,poidvehicul);
                donne.add(cache);
            }
            close();
        }
        catch(SQLException e){
            ERROR("Vehicul.AllVehicul",e);
        }
        return donne;
    }
}

/* PreparedStatement stmt = baj

String requet = "insert bablabl value (?,?,?)"
stmt = conn.preparedStatement(request)
stmt.setInt(int position , valeur)
stmt.setString(int position , valeur)
int ret = stmt.executeUpdate()

int ret = stmt.executeQuery() */

