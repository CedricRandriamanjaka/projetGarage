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
public class Slot extends BaseModel{
    private String nameslot;
    private String longslot;
    private String largslot;
    private String hautslot;
    private String poidslot;

    public Slot() {
    }

    public Slot(String id, String nameslot, String longslot, String largslot, String hautslot, String poidslot) {
        super();
        this.setId(id);
        this.nameslot = nameslot;
        this.longslot = longslot;
        this.largslot = largslot;
        this.hautslot = hautslot;
        this.poidslot = poidslot;
    }

    public String getNameslot() {
        return nameslot;
    }

    public void setNameslot(String nameslot) {
        this.nameslot = nameslot;
    }

    public String getLongslot() {
        return longslot;
    }

    public void setLongslot(String longslot) {
        this.longslot = longslot;
    }

    public String getLargslot() {
        return largslot;
    }

    public void setLargslot(String largslot) {
        this.largslot = largslot;
    }

    public String getHautslot() {
        return hautslot;
    }

    public void setHautslot(String hautslot) {
        this.hautslot = hautslot;
    }

    public String getPoidslot() {
        return poidslot;
    }

    public void setPoidslot(String poidslot) {
        this.poidslot = poidslot;
    }
    
}


