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
public class Client extends BaseModel{
    private String nameclient;
    private String passwordclient;

    public Client() {
    }

    public Client(String id,String nameclient, String passwordclient) {
        super();
        this.setId(id);
        this.nameclient = nameclient;
        this.passwordclient = passwordclient;
    }

    public String getNameclient() {
        return nameclient;
    }

    public void setNameclient(String nameclient) {
        this.nameclient = nameclient;
    }

    public String getPasswordclient() {
        return passwordclient;
    }

    public void setPasswordclient(String passwordclient) {
        this.passwordclient = passwordclient;
    }
    
}
