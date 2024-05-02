/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import Model.Admin;
import Model.Slot;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.ServiceAdmin;
import service.ServiceSlot;

/**
 *
 * @author Cedric
 */
public class IAMModif extends HttpServlet {
    protected void doGet (HttpServletRequest rq , HttpServletResponse rp)throws ServletException{
        try{
            String idSlot = rq.getParameter("idSlot");            
            String etat = rq.getParameter("etat"); 
            ServiceSlot SS = new ServiceSlot();
            
            Slot s = SS.getSlot(idSlot);
            
            if(etat.equals("suppimer")){
                
            }
            if(etat.equals("modifier")){
                rq.getSession().setAttribute("modifSlot",s);
                rp.sendRedirect("modifSlot.jsp");
            }
            else{
                rp.sendRedirect("IAMListSlot");
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    protected void doPost (HttpServletRequest rq , HttpServletResponse rp)throws ServletException{

        try{
            String etat = rq.getParameter("etat"); 
            ServiceSlot SS = new ServiceSlot();
            
            Slot s =(Slot) rq.getSession().getAttribute("modifSlot");
            
            if(etat.equals("suppimer")){
                
                boolean valider = SS.delete(s);
                if (valider){
                    rp.sendRedirect("IAMListSlot");
                }
                else{
                    rp.sendRedirect("modifSlot.jsp");
                }   
            }
            if(etat.equals("modifier")){
                String nameslot = rq.getParameter("nameslot");
                String longueur = rq.getParameter("longueur");
                String largueur = rq.getParameter("largueur");
                String hauteur = rq.getParameter("hauteur");
                String poid = rq.getParameter("poid");

                String id = s.getId();
                Slot slot = new Slot(id,nameslot,longueur,largueur,hauteur,poid);

                boolean valider = SS.modif(slot,s);
                if (valider){
                    rp.sendRedirect("IAMListSlot");
                }
                else{
                    rp.sendRedirect("modifSlot.jsp");
                }    
            }
            else{
                rp.sendRedirect("IAMListSlot");
            }
        }
        catch(Exception e){}
    }
}
