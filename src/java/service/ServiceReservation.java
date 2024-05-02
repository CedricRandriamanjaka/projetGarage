/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import DAO.DaoReservation;
import Model.Client;
import Model.Reservation;
import Model.Slot;
import Model.Vehicul;
import java.util.ArrayList;

/**
 *
 * @author Cedric
 */
public class ServiceReservation {
    public boolean ajoutValues(Reservation reservation){
        boolean reponse = true;
            if(
                reservation.getId().equals("") ||
                reservation.getIdclient().equals("") ||
                reservation.getIdvehicul().equals("")||
                reservation.getIdslot().equals("")||
                reservation.getDatereservation().equals("") ||
                reservation.getHeure().equals("") ||
                reservation.getDuree().equals("")||
                reservation.getValider().equals("")
            ){
                reponse = false;
            }
        return reponse;
    }
    
    private ArrayList<Slot> getValidSlot(ArrayList<Slot> list,Reservation res){
        String dateR = res.getDatereservation();
        String heure = res.getHeure();
        String durre = res.getDuree();

        DaoReservation DR = new DaoReservation();

        ArrayList<Slot> vrai = new ArrayList();
        // TETEZINA daoly le parking
        for (int i = 0; i < list.size(); i++) {
            Slot s = list.get(i);
            System.out.println(s.getNameslot());
            // ra mifanaraka le heure zy date de atsofoka izy
            if(DR.estDisponible(s,dateR,heure,durre)){
                vrai.add(s);
                System.out.println(s.getNameslot()+"if valide");
            }
        }
        return vrai;
    }

    // masterfind mretourn parking mety am tomobil am oura anaovana azy
    private Slot masterFind(Reservation reservation){
        ServiceSlot SS = new ServiceSlot();
        ServiceVehicul SV = new ServiceVehicul();

        // tadiavina aloha oe iza le tomobil am le reservation
        Vehicul vehicul = SV.getVehicul(reservation.getIdvehicul());

        // tadiavina ze parking rehetra mety am tomobil
        ArrayList<Slot> slot = SS.getSlotFor(vehicul);
        
        // tadiavina ze parking malalaka selon reservation efa misy
        ArrayList<Slot> slot2 = getValidSlot(slot,reservation);

        // alaina ze paking hita voaloha ra misy
        Slot retour = new Slot();

        if(slot2.size()!=0){
            retour = slot2.get(0);
        }
        return retour;
    }

    public Slot ajout(Reservation reservation){
        boolean reponse = false;
        Slot s = masterFind(reservation);  
        DaoReservation DR = new DaoReservation();

        if(s.getId()!=null){
            reservation.setIdslot(s.getId());

            boolean valideValues = ajoutValues(reservation);
            if(valideValues){
                boolean valideReservation = DR.isValide(reservation);
                if(valideReservation){
                    reponse = DR.newReservation(reservation);
                }
            }
        }
        return s;
    }
    
    public boolean delete(Slot slot){
        boolean reponse = true;
        DaoReservation DR = new DaoReservation();
        
        ArrayList<Reservation> listTrue = GetReservation(slot,true);       
        ArrayList<Reservation> listFalse = GetReservation(slot,false);
        
        for(int i=0;i<listTrue.size();i++){
            boolean cache;
            cache = DR.delete(listTrue.get(i));
            if(!cache){
                reponse = false;
            }
        }
        
        for(int i=0;i<listFalse.size();i++){
            boolean cache;
            cache = DR.delete(listFalse.get(i));
            if(!cache){
                reponse = false;
            }
        }
        
        return reponse;
    }
    
    public ArrayList<Reservation> GetReservation(boolean value){
        ArrayList<Reservation> donne = new ArrayList();
        DaoReservation DR = new DaoReservation();
        if(value){
            donne = DR.GetReservation("true");
        }
        if(!value){
            donne = DR.GetReservation("false");
        }
        return donne;
    }
    
    public ArrayList<Reservation> GetReservation(Client c,boolean value){
        ArrayList<Reservation> donne = new ArrayList();
        DaoReservation DR = new DaoReservation();
        if(value){
            donne = DR.GetReservation(c,"true");
        }
        if(!value){
            donne = DR.GetReservation(c,"false");
        }
        return donne;
    }
    
    public ArrayList<Reservation> GetReservation(Slot s,boolean value){
        ArrayList<Reservation> donne = new ArrayList();
        DaoReservation DR = new DaoReservation();
        if(value){
            donne = DR.GetReservation(s,"true");
        }
        if(!value){
            donne = DR.GetReservation(s,"false");
        }
        return donne;
    }

    public void annule(String id){
        DaoReservation DR = new DaoReservation();
        DR.annule(id);
    }
    
    public void annule(Slot s){
        ArrayList<Reservation> list = GetReservation(s,true);
        DaoReservation DR = new DaoReservation();
        for(int i=0;i<list.size();i++){
            String id = list.get(i).getId();
            DR.annule(id);
        }
    }
}
