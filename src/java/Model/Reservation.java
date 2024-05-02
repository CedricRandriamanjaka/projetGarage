/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Cedric
 */
public class Reservation extends BaseModel{
    String idclient;
    String idvehicul;
    String idslot;
    String datereservation;
    String heure;
    String duree;
    String valider;

    public Reservation(String id,String idclient, String idvehicul, String idslot, String datereservation, String heure, String duree, String valider) {
        super();
        this.setId(id);
        this.idclient = idclient;
        this.idvehicul = idvehicul;
        this.idslot = idslot;
        this.datereservation = datereservation;
        this.heure = heure;
        this.duree = duree;
        this.valider = valider;
    }

    public Reservation() {
    }

    public String getIdclient() {
        return idclient;
    }

    public void setIdclient(String idclient) {
        this.idclient = idclient;
    }

    public String getIdvehicul() {
        return idvehicul;
    }

    public void setIdvehicul(String idvehicul) {
        this.idvehicul = idvehicul;
    }

    public String getIdslot() {
        return idslot;
    }

    public void setIdslot(String idslot) {
        this.idslot = idslot;
    }

    public String getDatereservation() {
        return datereservation;
    }

    public void setDatereservation(String datereservation) {
        this.datereservation = datereservation;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getValider() {
        return valider;
    }

    public void setValider(String valider) {
        this.valider = valider;
    }
    
    
}
