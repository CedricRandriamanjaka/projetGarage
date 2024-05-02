/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import Model.Client;
import Model.Vehicul;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.ServiceClient;
import service.ServiceVehicul;

/**
 *
 * @author Cedric
 */
public class IWAcceuil extends HttpServlet {
    protected void doGet (HttpServletRequest rq , HttpServletResponse rp)throws ServletException{

        try{
            Client c = (Client)rq.getSession().getAttribute("user");
            ArrayList<Vehicul> vehicul = new ArrayList();
            ServiceVehicul SV = new ServiceVehicul();

            vehicul = SV.VehiculOf(c.getId());                    
            rq.getSession().setAttribute("listVehiculClient",vehicul);
            rp.sendRedirect("acceuil.jsp");
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
