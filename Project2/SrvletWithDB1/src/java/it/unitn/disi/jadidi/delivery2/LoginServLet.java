
package it.unitn.disi.jadidi.delivery2;

import java.io.IOException;
import java.sql.SQLException;
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

public class LoginServLet extends HttpServlet {
    
        
    
        @Override
        public void init() throws ServletException {
            log("init started");
            
            }
    
        @Override
        public void destroy() {
            
        }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        //preparing the database in this class and exec the query for checking the 
        //user
        UserDb user = new UserDb();
        log("in to post req");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        try {
            User userRes = user.DOLogin(username, password);
            log("db connected");
            String destPage = "login.jsp";
             
            if (userRes != null) {
                HttpSession session = request.getSession();
                session.setAttribute("userRes", userRes);
                destPage = "postLogin";
                
            } else {
                log("in else");
                String message = "Invalid email/password";
                request.setAttribute("message", message);
            }
             
            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
            dispatcher.forward(request, response);
             
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
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
    }

}
