/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import Model.Client;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.ServiceClient;

/**
 *
 * @author Cedric
 */
public class IWLoginClient extends HttpServlet {
    protected void doPost (HttpServletRequest rq , HttpServletResponse rp)throws ServletException{
        try{
            String nom = rq.getParameter("nameclient");            
            String mdp = rq.getParameter("passwordclient");            

            ServiceClient SC = new ServiceClient();
            
            int valider = SC.login(nom,mdp);
            if (valider != -1){
                Client client = new Client(String.valueOf(valider),nom,mdp);
                rq.getSession().setAttribute("user",client);                
                rp.sendRedirect("IWAcceuil");
            }
            else{
                rp.sendRedirect("index.jsp?ERROR=nom d'utilisateur ou mot de passe incorrect");
            }
        }
        catch(Exception e){}
    }
}
