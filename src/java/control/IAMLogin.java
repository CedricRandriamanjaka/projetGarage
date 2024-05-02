/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import Model.Admin;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.ServiceAdmin;

/**
 *
 * @author Cedric
 */
public class IAMLogin extends HttpServlet {
    protected void doPost (HttpServletRequest rq , HttpServletResponse rp)throws ServletException{
        try{
            String nom = rq.getParameter("nameadmin");            
            String mdp = rq.getParameter("passwordadmin");            

            ServiceAdmin SA = new ServiceAdmin();
            
            int valider = SA.login(nom,mdp);
            if (valider != -1){
                rp.sendRedirect("IAMListSlot");
                Admin admin = new Admin(String.valueOf(valider),nom,mdp);
                rq.getSession().setAttribute("userAdmin",admin.getId());
            }
            else{
                rp.sendRedirect("index.jsp");
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
