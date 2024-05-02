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
public class IAMListVehiculClient extends HttpServlet {

    protected void doGet (HttpServletRequest rq , HttpServletResponse rp)throws ServletException{
        try{
            String idClient = rq.getParameter("id");
            ArrayList<Vehicul> donne = new ArrayList();
            ServiceVehicul SV = new ServiceVehicul();
            ServiceClient SC = new ServiceClient();

            donne = SV.VehiculOf(idClient);
            
            Client client = SC.getClient(idClient);
            
            rq.getSession().setAttribute("listVehiculClient",donne);            
            rq.getSession().setAttribute("client",client);

            rp.sendRedirect("listVehiculClient.jsp");
        }
        catch(Exception e){}
    }
}
