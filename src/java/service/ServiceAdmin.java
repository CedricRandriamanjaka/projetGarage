/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import DAO.DaoAdmin;
import Model.Admin;

/**
 *
 * @author Cedric
 */
public class ServiceAdmin {
    public boolean loginValues(String name,String password){
        boolean reponse = false;
        if(name != null && password != null){
            reponse = true;
        }
        return reponse;
    }

    public int login(String name, String password){
        int reponse = -1;
        
        DaoAdmin DA = new DaoAdmin();
        
        boolean valideValues = loginValues(name,password);
        
        if(valideValues){
            Admin Admin = new Admin("0",name,password);
            reponse = DA.findAdmin(Admin);
        }
        return reponse;
    }
}
