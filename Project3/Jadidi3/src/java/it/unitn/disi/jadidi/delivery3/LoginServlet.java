/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.jadidi.delivery3;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dimo
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

   
         @Override
        public void init() throws ServletException {
            log("init started");
            
            }
    
        @Override
        public void destroy() {
            
        }
        
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        
        if(username != null && password != null){
            if(validateMe(username,password)){
                HttpSession session = request.getSession();
                session.setAttribute("userRes", "admin");
                
                RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
                dispatcher.forward(request, response);
            }else{
                log(password);
                String message = "Invalid email/password";
                request.setAttribute("message", message);
                
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response);
            }
            
        }

    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    // to check if user and pass is admin,admin
    protected Boolean validateMe(String un,String pass){
        log(un+pass);
        if(un.equals("admin") && pass.equals("admin")){
            return true;
        }else{
            
            return false;
        }
    }

}
