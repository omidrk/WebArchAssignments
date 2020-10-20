/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.omid.myServlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

/**
 *
 * @author Dimo
 */
@WebServlet(name = "ServMe", urlPatterns = {"/ServMe"})
public class ServMe extends HttpServlet {
    
    // Start logging and init
    @Override
    public void init(){
        log("init started");
    }
    
    @Override
    public void destroy(){
        log("Destroy executed");
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Cookie cName = new Cookie("username",request.getParameter("fname"));
        Cookie cTeam = new Cookie("team",request.getParameter("soccerteam"));
        response.addCookie(cName);
        response.addCookie(cTeam);

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServMe</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>API Ver 0.1 with Servlets</h1>");
            out.println("<h2>User Name is : "+request.getParameter("fname")+"</h2>");
            out.println("<h2>Soccer Team is : "+request.getParameter("soccerteam")+"</h2>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
//    protected void initReq(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
////        request.getRequestDispatcher("/welcome.html").include(request, response);
//       
////        try (PrintWriter out = response.getWriter()) {
////            /* TODO output your page here. You may use following sample code. */
////            out.println("<!DOCTYPE html>");
////            out.println("<html>");
////            out.println("<head>");
////            out.println("<title>Servlet ServMe</title>");            
////            out.println("</head>");
////            out.println("<body>");
////            out.println("<h1>API Ver 0.1 with Servlets</h1>");
////            out.println("<h2>User Name is : "+request.getParameter("fname")+"</h2>");
////            out.println("<h2>Soccer Team is : "+request.getParameter("soccerteam")+"</h2>");
////            out.println("</body>");
////            out.println("</html>");
////        }
//    }

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
        String userName = request.getParameter("fname");
        Cookie cName[] = request.getCookies();
        log("out if");
        if(userName == null && cName == null){
            log("fisrt if");
//            initReq(request, response);
        }
        if(userName != null && cName == null){
            log("in process");
            processRequest(request, response);
        }
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
//        processRequest(request, response);
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
