/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import Model.Client;
import Model.Reservation;
import Model.Slot;
import Model.Vehicul;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.ServiceClient;
import service.ServiceReservation;
import service.ServiceSlot;
import service.ServiceVehicul;
import util.CSV;
import util.SlotWithReservation;

/**
 *
 * @author Cedric
 */
public class IAMListSlot extends HttpServlet {

    protected void doGet (HttpServletRequest rq , HttpServletResponse rp)throws ServletException{
        try{
            ArrayList<Slot> donne = new ArrayList();
            ServiceSlot SS = new ServiceSlot();
            
            ArrayList<SlotWithReservation> donne2 = new ArrayList();
            donne2 = SS.getSlotWithReservation(true);
            
            rq.getSession().setAttribute("listSlotWithReservationTrue",donne2);
            rp.sendRedirect("listSlot.jsp?page=1");
        }
        catch(Exception e){
            
        }
    }
    
    protected void doPost (HttpServletRequest rq , HttpServletResponse rp)throws ServletException{
        try{
            String reservationmin = rq.getParameter("reservationmin");
            String reservationmax = rq.getParameter("reservationmax");
            String poidmin = rq.getParameter("poidmin");  
            String poidmax = rq.getParameter("poidmax"); 
            
            ArrayList<Slot> donne = new ArrayList();
            ServiceSlot SS = new ServiceSlot();
            
            ArrayList<SlotWithReservation> donne2 = new ArrayList();
            ArrayList<SlotWithReservation> donne3 = new ArrayList();
            donne2 = SS.getSlotWithReservation(true);
            
            donne3 = SS.getParameterList(reservationmin,reservationmax,poidmin,poidmax,donne2);
            
            rq.getSession().setAttribute("listSlotWithReservationTrue",donne3);
            rp.sendRedirect("listSlot.jsp?page=1");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
