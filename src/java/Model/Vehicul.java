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
public class Vehicul extends BaseModel{
    private String idclient;
    private String typevehicul;
    private String marquevehicul;
    private String modelvehicul;
    private String colorvehicul;
    private String matriculationvahicul;
    private String longvehicul;
    private String largvehicul;
    private String hautvehicul;
    private String poidvehicul;

    public Vehicul() {
    }

    public Vehicul(String id,String idclient, String typevehicul, String marquevehicul, String modelvehicul, String colorvehicul, String matriculationvahicul, String longvehicul, String largvehicul, String hautvehicul, String poidvehicul) {
        super();
        this.setId(id);
        this.idclient = idclient;
        this.typevehicul = typevehicul;
        this.marquevehicul = marquevehicul;
        this.modelvehicul = modelvehicul;
        this.colorvehicul = colorvehicul;
        this.matriculationvahicul = matriculationvahicul;
        this.longvehicul = longvehicul;
        this.largvehicul = largvehicul;
        this.hautvehicul = hautvehicul;
        this.poidvehicul = poidvehicul;
    }

    public String getIdclient() {
        return idclient;
    }

    public void setIdclient(String idclient) {
        this.idclient = idclient;
    }

    public String getTypevehicul() {
        return typevehicul;
    }

    public void setTypevehicul(String typevehicul) {
        this.typevehicul = typevehicul;
    }

    public String getMarquevehicul() {
        return marquevehicul;
    }

    public void setMarquevehicul(String marquevehicul) {
        this.marquevehicul = marquevehicul;
    }

    public String getModelvehicul() {
        return modelvehicul;
    }

    public void setModelvehicul(String modelvehicul) {
        this.modelvehicul = modelvehicul;
    }

    public String getColorvehicul() {
        return colorvehicul;
    }

    public void setColorvehicul(String colorvehicul) {
        this.colorvehicul = colorvehicul;
    }

    public String getMatriculationvahicul() {
        return matriculationvahicul;
    }

    public void setMatriculationvahicul(String matriculationvahicul) {
        this.matriculationvahicul = matriculationvahicul;
    }

    public String getLongvehicul() {
        return longvehicul;
    }

    public void setLongvehicul(String longvehicul) {
        this.longvehicul = longvehicul;
    }

    public String getLargvehicul() {
        return largvehicul;
    }

    public void setLargvehicul(String largvehicul) {
        this.largvehicul = largvehicul;
    }

    public String getHautvehicul() {
        return hautvehicul;
    }

    public void setHautvehicul(String hautvehicul) {
        this.hautvehicul = hautvehicul;
    }

    public String getPoidvehicul() {
        return poidvehicul;
    }

    public void setPoidvehicul(String poidvehicul) {
        this.poidvehicul = poidvehicul;
    }
        
}
