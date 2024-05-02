/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Admin;
import java.sql.*;
import java.*;

/**
 *
 * @author Cedric
 */
public class DaoAdmin {
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
            ERROR("Admin.open",e);
	    }
    }

    public int findAdmin(Admin admin){
        int id = -1;

        String name = admin.getNameadmin();        
        String password = admin.getPasswordadmin();
        
        String requet = "select * from admin where nameadmin = '"+name+"' and passwordadmin='"+password+"'";
        try{
            open();
            stmt = conn.prepareStatement(requet);			
            ResultSet ret = stmt.executeQuery();
            while(ret.next()){
                id = ret.getInt(1);
            }
            close();
        }
        catch(SQLException e){
            ERROR("Admin.findAdmin",e);
        }
        return id;
    }
    
    private void close(){
        try{
            this.conn.close();
        }
        catch(SQLException e){
            ERROR("admin.close",e);
        }
    }
}

/* PreparedStatement stmt = baj

String requet = "insert bablabl value (?,?,?)"
stmt = conn.preparedStatement(request)
stmt.setInt(int position , valeur)
stmt.setString(int position , valeur)
int ret = stmt.executeUpdate()

int ret = stmt.executeQuery() */



