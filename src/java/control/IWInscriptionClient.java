/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

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
public class IWInscriptionClient extends HttpServlet {
    protected void doPost (HttpServletRequest rq , HttpServletResponse rp)throws ServletException{
        try{
            String nom = rq.getParameter("nameclient");            
            String mdp = rq.getParameter("passwordclient");            
            String mdpValider = rq.getParameter("passwordclientValider");

            ServiceClient SC = new ServiceClient();
            
            boolean valider = SC.inscription(nom,mdp,mdpValider);
            if (valider){
                rp.sendRedirect("index.jsp?CHECK=votre inscription a ete valider");
            }
            else{
                rp.sendRedirect("inscription.jsp?ERROR=mot de passe invalide ou utilisateur deja present");
            }
        }
        catch(Exception e){}
    }
}
