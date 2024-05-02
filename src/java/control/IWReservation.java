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
import service.ServiceReservation;
import service.ServiceSlot;
import service.ServiceVehicul;

/**
 *
 * @author Cedric
 */
public class IWReservation extends HttpServlet {
    protected void doPost (HttpServletRequest rq , HttpServletResponse rp)throws ServletException{

        try{
            Client client = (Client)rq.getSession().getAttribute("user");
            String idclient = client.getId();
            String idvehicul = rq.getParameter("idvehicul");
            String idslot = "-1";
            String date = rq.getParameter("date");
            String time = rq.getParameter("time");
            String duree = rq.getParameter("duree");

            Reservation reservation = new Reservation("-1",idclient,idvehicul,idslot,date,time,duree,"true");
            ServiceReservation SR = new ServiceReservation();

            boolean mety = SR.ajoutValues(reservation);
            if(mety){
                Slot valider = SR.ajout(reservation);
                if(valider.getId() != null ){
                    rq.getSession().setAttribute("ReservationValide",reservation);                    
                    rq.getSession().setAttribute("SlotValide",valider);
                    rp.sendRedirect("validation.jsp");
                }   

                else{
                    rp.sendRedirect("reservation.jsp?ERROR="+"Heure deja pris, ou date non valide");
                }
            }
            else{
                rp.sendRedirect("reservation.jsp?ERROR="+"champ incomplet");
            }
        }
        catch(Exception e){
            System.out.println("");
            System.out.println("//debut");
            System.out.println("//	"+"IW.IWReservation."+"doPOSt");
            System.out.println("//	"+e.getMessage());
            System.out.println("//fin");
            System.out.println("");
            System.out.println(e.getMessage());
        }
    }

    protected void doGet (HttpServletRequest rq , HttpServletResponse rp)throws ServletException{

        try{
            Client c = (Client)rq.getSession().getAttribute("user");
            ArrayList<Vehicul> vehicul = new ArrayList();
            ServiceVehicul SV = new ServiceVehicul();

            vehicul = SV.VehiculOf(c.getId());                    
            rq.getSession().setAttribute("listVehiculClient",vehicul);
            rp.sendRedirect("reservation.jsp");
        }
        catch(Exception e){
            System.out.println("");
            System.out.println("//debut");
            System.out.println("//	"+"IW.IWReservation."+"doGet");
            System.out.println("//	"+e.getMessage());
            System.out.println("//fin");
            System.out.println("");
        }
    }
}
