
package it.unitn.disi.jadidi.delivery2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class changePass extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        UserDb user = new UserDb();
        HttpSession session= request.getSession(false);
        String password = request.getParameter("password");
        User username = (User)session.getAttribute("userRes");
        String usr = username.USERNAME;
        
        try (PrintWriter out = response.getWriter()) {
            boolean result = false;
            if(password!= null && password != ""){
            result = user.DOChange(username.USERNAME, password);}
            if (result != false && usr != null && password!= null && password != ""){
                out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet changePass</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Succesfully changed pass</h1>");
            out.println("<a href='login.jsp'>Login Again</a>");
            out.println("</body>");
            out.println("</html>");
            }else{
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet changePass</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Something went wrong please login again</h1>");
                out.println("<a href='login.jsp'>Login Again</a>");
                out.println("</body>");
                out.println("</html>");
                
            }
            
        }catch (SQLException | ClassNotFoundException ex) {
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
