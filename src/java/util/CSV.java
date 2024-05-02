/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import Model.Slot;
import java.io.*;
import service.ServiceSlot;


/**
 *
 * @author Cedric
 */
public class CSV {
    public static void test(String file){
        
        try{
            String line = "";  
            String splitBy = ",";  
            //parsing a CSV file into BufferedReader class constructor  
            BufferedReader br = new BufferedReader(new FileReader("D:///"+file));  
            while ((line = br.readLine()) != null)   //returns a Boolean value  
            {  
                String[] donne = line.split(splitBy);
                Slot s = new Slot("-1",donne[0],donne[1],donne[2],donne[3],donne[4]);
                System.out.println(donne[0]+donne[1]+donne[2]+donne[3]+donne[4]);
                ServiceSlot SS = new ServiceSlot();
                SS.ajout(s); 
            }  
        }
        catch(Exception e){
        System.out.println(e.getMessage());
        }
        
    }
}
