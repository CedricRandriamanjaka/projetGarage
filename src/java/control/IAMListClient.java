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
public class IAMListClient extends HttpServlet {

    protected void doGet (HttpServletRequest rq , HttpServletResponse rp)throws ServletException{
        try{
            ArrayList<Client> donne = new ArrayList();
            ServiceClient SC = new ServiceClient();
            donne = SC.AllClient();
            rq.getSession().setAttribute("listClient",donne);
            
            ArrayList<Vehicul> donne2 = new ArrayList();
            ServiceVehicul SV = new ServiceVehicul();
            donne2 = SV.AllVehicul();
            rq.getSession().setAttribute("listVehicul",donne2);

            ArrayList<Client> donne3 = new ArrayList();
            for(int i=0;i<donne2.size();i++){
                String idClient = donne2.get(i).getIdclient();
                donne3.add(SC.getClient(idClient));
            }
            rq.getSession().setAttribute("listClientNom",donne3);

            rp.sendRedirect("listClient.jsp");
        }
        catch(Exception e){}
    }
}
