/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import DAO.DaoSlot;
import Model.Reservation;
import Model.Slot;
import Model.Vehicul;
import java.util.ArrayList;
import util.SlotWithReservation;

/**
 *
 * @author Cedric
 */
public class ServiceSlot {
    public boolean ajoutValues(Slot slot){
        boolean reponse = false;
            if(
                slot.getNameslot() != null &&
                slot.getLongslot() != null &&
                slot.getLargslot() != null &&
                slot.getHautslot() != null &&
                slot.getPoidslot() != null
            ){
                reponse = true;
            }
        return reponse;
    }

    public boolean ajout(Slot slot){
        boolean reponse = false;

        DaoSlot DS = new DaoSlot();

        boolean valideValues = ajoutValues(slot);
        boolean valideSlot = DS.isValide(slot);

        if(valideValues && valideSlot){
            DS.newSlot(slot);
            reponse = true;
        }
        return reponse;
    }
    
    public boolean modif(Slot slot,Slot s){
        boolean reponse = false;

        DaoSlot DS = new DaoSlot();

        boolean valideValues = ajoutValues(slot);
        boolean valideSlot = DS.isValide(slot);
        
        if(slot.getNameslot().equals(s.getNameslot())){
            valideSlot = true;
        }

        if(valideValues && valideSlot){
            ServiceReservation SR = new ServiceReservation();
            SR.annule(slot);
            DS.modifSlot(slot);
            reponse = true;
        }
        
        return reponse;
    }
    
    public boolean delete(Slot slot){
        boolean reponse = false;

        DaoSlot DS = new DaoSlot();

            ServiceReservation SR = new ServiceReservation();
            boolean reservationDelete;
            reservationDelete = SR.delete(slot);
            if(reservationDelete){
                reponse = DS.delete(slot);   
                reponse = true;
            }
        
        return reponse;
    }

    public ArrayList<Slot> getSlotFor(Vehicul v){
        DaoSlot DS = new DaoSlot();
        ArrayList<Slot> list = new ArrayList();
        list = DS.getSlotFor(v);
        return list;
    }
    
    public ArrayList<Slot> getSlot (boolean value){
        DaoSlot DS = new DaoSlot();
        ArrayList<Slot> list = new ArrayList();
        list = DS.getSlot(value);
        return list;
    }
    
    public Slot getSlot (String id){
        DaoSlot DS = new DaoSlot();
        Slot s = new Slot();
        s = DS.getSlot(id);
        return s;
    }
    
    public ArrayList<SlotWithReservation> getSlotWithReservation (boolean value){
        ArrayList<SlotWithReservation> SWR = new ArrayList();
        ArrayList<Slot> listSlot = getSlot(value);
        ServiceReservation SR = new ServiceReservation();
        
        for(int i=0;i<listSlot.size();i++){
            Slot s = listSlot.get(i);
            ArrayList<Reservation> reservation = SR.GetReservation(s,value);
            SlotWithReservation swr = new SlotWithReservation(s,reservation);
            SWR.add(swr);
        }
        return SWR;
    }
    
    public ArrayList<SlotWithReservation> getParameterList(String a,String b, String c, String d, ArrayList<SlotWithReservation> list){
        ArrayList<SlotWithReservation> nouv = new ArrayList();
        for(int i=0;i<list.size();i++){
            int siz = list.get(i).getReservation().size();
            String poid = list.get(i).getSlot().getPoidslot();
            int poidint = Integer.parseInt(poid);
            boolean verifreserv = false;
            boolean verifpoid = false;
            
            int ia = Integer.parseInt(a);
            int ib = Integer.parseInt(b);
            int ic = Integer.parseInt(c);
            int id = Integer.parseInt(d);
        }
        return nouv;
    }
}
