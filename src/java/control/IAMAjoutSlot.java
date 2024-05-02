/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import Model.Slot;
import model.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.ServiceSlot;
import util.CSV;

/**
 *
 * @author Cedric
 */
public class IAMAjoutSlot extends HttpServlet {
    protected void doPost (HttpServletRequest rq , HttpServletResponse rp)throws ServletException{

        try{

            String nameslot = rq.getParameter("nameslot");
            String longueur = rq.getParameter("longueur");
            String largueur = rq.getParameter("largueur");
            String hauteur = rq.getParameter("hauteur");
            String poid = rq.getParameter("poid");

            Slot slot = new Slot("-1",nameslot,longueur,largueur,hauteur,poid);

            ServiceSlot SS = new ServiceSlot();
            boolean valider = SS.ajout(slot);
            if (valider){
                rp.sendRedirect("acceuil.jsp");
            }
            else{
                rp.sendRedirect("ajoutSlot.jsp");
            }
        }
        catch(Exception e){}
    }
    
    protected void doGet (HttpServletRequest rq , HttpServletResponse rp)throws ServletException{

        try{

            String namefile = rq.getParameter("namefile");
            CSV csv = new CSV();
            if(namefile.equals("base.csv")){
                csv.test(namefile);
            }
            rp.sendRedirect("IAMListSlot");
        }
        catch(Exception e){}
    }
}
