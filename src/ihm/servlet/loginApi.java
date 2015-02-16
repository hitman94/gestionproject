/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.servlet;

import ihm.SessionUser;

import java.io.IOException;
import java.util.List;

import javax.persistence.Query;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utilisateur.User;

/**
 *
 * @author doquanghuy
 */
//Login Api
public class loginApi extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @Inject
    SessionUser sessionUser;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String username = request.getParameter("name_user");
        String pass = request.getParameter("pass_user"); 
        HttpSession Httpsession =request.getSession();

        
        //Create persitence to Name DB
        EntityManagerFactory entityManagerFactory =  Persistence.createEntityManagerFactory("Name DB");
        EntityManager em = entityManagerFactory.createEntityManager();
        User user = null;
        
        //Make query
        Query query = em.createQuery("Select u from USER u where u.userName = '"+username+"'");        
        List<User> list = query.getResultList();
        
        //If query size list = 1 continues, if size list = 0 or >1 fails
        // Make sure userName is unique
        if(list.size()==1)
        {
        	if(user.getPassWord().equals(pass))
            {
            	sessionUser.setIsConnected(true);
            	
            	//Set instance user
            	sessionUser.setUser(user);
            	sessionUser.getMessage().setTypeMsg(0);
            	sessionUser.getMessage().setMessage("Login successful");
            }else
            {
            	sessionUser.setIsConnected(false);
            	sessionUser.getMessage().setTypeMsg(1);
            	sessionUser.getMessage().setMessage("Login fail");
            }
        }else
        {
        	sessionUser.setIsConnected(false);
        	sessionUser.getMessage().setTypeMsg(1);
        	sessionUser.getMessage().setMessage("Login fail");
        	
        }
                
        em.close();
        entityManagerFactory.close();
        
        Httpsession.setAttribute("sessionUser", sessionUser);
        // after finish check login, pass to homepage
        response.sendRedirect("/URL homepage/");
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
