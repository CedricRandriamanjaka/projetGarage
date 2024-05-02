/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import DAO.DaoVehicul;
import Model.Vehicul;
import java.util.ArrayList;

/**
 *
 * @author Cedric
 */
public class ServiceVehicul {
    public boolean ajoutValues(Vehicul vehicul){
        boolean reponse = true;
            if(
                vehicul.getId().equals("") ||
                vehicul.getIdclient().equals("") ||
                vehicul.getTypevehicul().equals("") ||
                vehicul.getMarquevehicul().equals("") ||
                vehicul.getModelvehicul().equals("") ||
                vehicul.getColorvehicul().equals("") ||
                vehicul.getMatriculationvahicul().equals("") ||
                vehicul.getLongvehicul().equals("") ||
                vehicul.getLargvehicul().equals("") ||
                vehicul.getHautvehicul().equals("") ||
                vehicul.getPoidvehicul().equals("")
            ){
                reponse = false;
            }
        return reponse;
    }

    public boolean ajout(Vehicul vehicul){
        boolean reponse = false;

        DaoVehicul DV = new DaoVehicul();

        boolean valideValues = ajoutValues(vehicul);
        boolean valideVahicul = DV.isValide(vehicul);

        if(valideValues && valideVahicul){
            DV.newVehicul(vehicul);
            reponse = true;
        }
        return reponse;
    }

    public Vehicul getVehicul(String id){
        DaoVehicul DV = new DaoVehicul();
        return DV.getVehicul(id);
    }

    public ArrayList<Vehicul> VehiculOf(String id){
        ArrayList<Vehicul> donne = new ArrayList();
        DaoVehicul DV = new DaoVehicul();
        donne = DV.VehiculOf(id);
        return donne;
    }

    public ArrayList<Vehicul> AllVehicul(){
        ArrayList<Vehicul> donne = new ArrayList();
        DaoVehicul DV = new DaoVehicul();
        donne = DV.AllVehicul();
        return donne;
    }
}
