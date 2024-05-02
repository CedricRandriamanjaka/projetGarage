/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.*;
import Model.Client;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Cedric
 */
public class DaoClient {
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
            ERROR("Client.open",e);
	}
    }
    
    private void close(){
        try{
            this.conn.close();
        }
        catch(SQLException e){
            ERROR("Client.close",e);
        }
    }
    
    public void newClient(Client client){
        String name = client.getNameclient();        
        String password = client.getPasswordclient();
        
        String requet = "insert into client values (default,'"+name+"','"+password+"')";
        try{
            open();
            stmt = conn.prepareStatement(requet);			
            int ret = stmt.executeUpdate();
            close();
        }
        catch(SQLException e){
            ERROR("Client.newClient",e);
        }
    }

    public int findClient(Client client){
        int id = -1;

        String name = client.getNameclient();        
        String password = client.getPasswordclient();
        
        String requet = "select * from client where nameclient = '"+name+"' and passwordclient='"+password+"'";
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
            ERROR("Client.findClient",e);
        }
        return id;
    }
    
    public boolean isValide(String name){
        boolean reponse = true;
        String requet = "select * from client where nameclient = '" + name + "'";
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
            ERROR("Client.isValide",e);
        }
        return reponse;
    }

    public ArrayList<Client> AllClient(){
        ArrayList<Client> donne = new ArrayList();
        String requet = "select * from client";
        try{
            open();
            stmt = conn.prepareStatement(requet);			
            ResultSet ret = stmt.executeQuery();
            while(ret.next()){
                String id = ret.getString(1);
                String name = ret.getString(2);
                String mdp = ret.getString(3);
                Client cache = new Client(id,name,mdp);
                donne.add(cache);
            }
            close();
        }
        catch(SQLException e){
            ERROR("Client.AllClient",e);
        }
        return donne;
    }

    public Client getClient(String idC){
        Client c = new Client();
        String requet = "select * from client where idClient = "+idC;
        try{
            open();
            stmt = conn.prepareStatement(requet);			
            ResultSet ret = stmt.executeQuery();
            while(ret.next()){
                String id = ret.getString(1);
                String name = ret.getString(2);
                String mdp = ret.getString(3);
                c = new Client(id,name,mdp);
            }
            close();
        }
        catch(SQLException e){
            ERROR("Client.getClient",e);
        }
        return c;
    }
}

/* PreparedStatement stmt = baj

String requet = "insert bablabl value (?,?,?)"
stmt = conn.preparedStatement(request)
stmt.setInt(int position , valeur)
stmt.setString(int position , valeur)
int ret = stmt.executeUpdate()

int ret = stmt.executeQuery() */
