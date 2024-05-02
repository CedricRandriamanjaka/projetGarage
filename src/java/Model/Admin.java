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
public class Admin extends BaseModel{
    private String nameadmin;
    private String passwordadmin;

    public Admin(String id,String nameadmin, String passwordadmin) {
        super();
        this.setId(id);
        this.nameadmin = nameadmin;
        this.passwordadmin = passwordadmin;
    }

    public Admin() {}

    public String getNameadmin() {
        return nameadmin;
    }

    public void setNameadmin(String nameadmin) {
        this.nameadmin = nameadmin;
    }

    public String getPasswordadmin() {
        return passwordadmin;
    }

    public void setPasswordadmin(String passwordadmin) {
        this.passwordadmin = passwordadmin;
    }
    
}
