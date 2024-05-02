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
public class Url {
    public static String getBdaUrl(){
        return "jdbc:postgresql://localhost:5432/projetparking";
    }
    
    public static String getBdaUser(){
        return "postgres";
    }
    
    public static String getBdaMdp(){
        return "753";
    }
}
