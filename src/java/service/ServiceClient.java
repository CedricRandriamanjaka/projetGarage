/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import DAO.DaoClient;
import Model.Client;
import java.util.ArrayList;

/**
 *
 * @author Cedric
 */
public class ServiceClient {
    public boolean inscriptionValues(String name, String password, String passwordValid){
        boolean reponse = false;
            if(name != null && password != null && password.equals(passwordValid)){
                reponse = true;
            }
        return reponse;
    }

    public boolean loginValues(String name,String password){
        boolean reponse = false;
        if(name != null && password != null){
            reponse = true;
        }
        return reponse;
    }
    
    public boolean valideUserName(String name){
        boolean reponse = false;
        DaoClient DC = new DaoClient();
        return reponse;
    }
    
    public boolean inscription(String name, String password, String passwordValid){
        boolean reponse = false;
        
        DaoClient DC = new DaoClient();
        
        boolean valideValues = inscriptionValues(name,password,passwordValid);
        boolean valideUserName = DC.isValide(name);
        
        if(valideValues && valideUserName){
            Client client = new Client("0",name,password);
            DC.newClient(client);
            reponse = true;
        }
        return reponse;
    }

    public int login(String name, String password){
        int reponse = -1;
        
        DaoClient DC = new DaoClient();
        
        boolean valideValues = loginValues(name,password);
        
        if(valideValues){
            Client client = new Client("0",name,password);
            reponse = DC.findClient(client);
        }
        return reponse;
    }

    public ArrayList<Client> AllClient(){
        ArrayList<Client> donne = new ArrayList();
        DaoClient DC = new DaoClient();
        donne = DC.AllClient();
        return donne;
    }

    public Client getClient(String id){
        Client c = new Client();
        DaoClient DC = new DaoClient();
        c = DC.getClient(id);
        return c;
    }
}
