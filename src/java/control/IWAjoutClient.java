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
public class IWAjoutClient extends HttpServlet {
    protected void doPost (HttpServletRequest rq , HttpServletResponse rp)throws ServletException{

        try{
            Client c = (Client)rq.getSession().getAttribute("user");
            String idclient = c.getId();
            String typevehicul = rq.getParameter("typevehicul");
            String marquevehicul = rq.getParameter("marquevehicul");
            String modelvehicul = rq.getParameter("modelvehicul");
            String colorvehicul = rq.getParameter("colorvehicul");
            String matriculationvehicul = rq.getParameter("matriculationvehicul");
            String longvehicul = rq.getParameter("longvehicul");
            String largvehicul = rq.getParameter("largvehicul");
            String hautvehicul = rq.getParameter("hautvehicul");
            String poidvehicul = rq.getParameter("poidvehicul");

            Vehicul vehicul = new Vehicul("-1",idclient,typevehicul,marquevehicul,modelvehicul,colorvehicul,matriculationvehicul,longvehicul,largvehicul,hautvehicul,poidvehicul);

            ServiceVehicul SV = new ServiceVehicul();
            boolean valider = SV.ajout(vehicul);
            if (valider){
                rp.sendRedirect("IWAcceuil");
            }
            else{
                rp.sendRedirect("ajout.jsp?ERROR=champ incomplet ou voiture deja enregistre");
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
