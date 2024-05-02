/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Cedric
 */
public class Interval {
    int debut;
    int fin;

    public Interval() {
    }

    public Interval(int debut, int fin) {
        this.debut = debut;
        this.fin = fin;
    }

    public int getDebut() {
        return debut;
    }

    public void setDebut(int debut) {
        this.debut = debut;
    }

    public int getFin() {
        return fin;
    }

    public void setFin(int fin) {
        this.fin = fin;
    }
    
    public boolean estDans(Interval interval){
        boolean estdans = false;

        for(int i = this.getDebut();i<=this.getFin()+this.getDebut();i++){                
            if(i>=interval.getDebut() && i<= interval.getFin()+interval.getDebut()){
                estdans = true;
                break;
            }
        }
        return estdans;
    }
}
