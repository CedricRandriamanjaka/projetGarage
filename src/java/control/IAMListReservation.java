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

/**
 *
 * @author Cedric
 */
public class IAMListReservation extends HttpServlet {

    protected void doGet (HttpServletRequest rq , HttpServletResponse rp)throws ServletException{
        try{
            if(rq.getParameter("idSlot") != null){
                ServiceSlot SS = new ServiceSlot();
                String idSlot = rq.getParameter("idSlot");
                Slot s = SS.getSlot(idSlot);
                
                ArrayList<Reservation> donne = new ArrayList();
                ServiceReservation SR = new ServiceReservation();
                donne = SR.GetReservation(s,true);
                rq.getSession().setAttribute("listReservationTrue",donne);

                ArrayList<Reservation> donne2 = new ArrayList();
                donne2 = SR.GetReservation(s,false);
                rq.getSession().setAttribute("listReservationFalse",donne2);

                rp.sendRedirect("listReservation.jsp");
            }
            else{
                ArrayList<Reservation> donne = new ArrayList();
                ServiceReservation SR = new ServiceReservation();
                donne = SR.GetReservation(true);
                rq.getSession().setAttribute("listReservationTrue",donne);

                ArrayList<Reservation> donne2 = new ArrayList();
                donne2 = SR.GetReservation(false);
                rq.getSession().setAttribute("listReservationFalse",donne2);

                rp.sendRedirect("listReservation.jsp");
            }
        }
        catch(Exception e){}
    }

    protected void doPost (HttpServletRequest rq , HttpServletResponse rp)throws ServletException{
        try{
            String idReservetion = rq.getParameter("id");
            ServiceReservation SR = new ServiceReservation();
            if(!idReservetion.equals("")){
                SR.annule(idReservetion);
            }
            
            ArrayList<Reservation> donne = new ArrayList();
            donne = SR.GetReservation(true);
            rq.getSession().setAttribute("listReservationTrue",donne);
            
            ArrayList<Reservation> donne2 = new ArrayList();
            donne2 = SR.GetReservation(false);
            rq.getSession().setAttribute("listReservationFalse",donne2);

            rp.sendRedirect("listReservation.jsp");
        }
        catch(Exception e){}
    }
}
