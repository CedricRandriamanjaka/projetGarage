/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import Model.Reservation;
import Model.Slot;
import java.util.ArrayList;

/**
 *
 * @author Cedric
 */
public class SlotWithReservation {

    private Slot slot;
    private ArrayList<Reservation> reservation;

    public SlotWithReservation() {
    }

    public SlotWithReservation(Slot slot, ArrayList<Reservation> reservation) {
        this.slot = slot;
        this.reservation = reservation;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public ArrayList<Reservation> getReservation() {
        return reservation;
    }

    public void setReservation(ArrayList<Reservation> reservation) {
        this.reservation = reservation;
    }


}
