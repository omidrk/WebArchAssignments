
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/welcome"})
public class welcome extends HttpServlet {

    String msg;
    boolean isInitialIteration ;
    private void dealWithInvalidCookie() {
    msg = "Sorry, we do not know each other...<br>"
    + "Please introduce yourself.<br>";
    isInitialIteration = true;
    }
    
    protected void haveCookie(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie cookies[] = request.getCookies();
        Cookie n_Cookie=null; 
        Cookie c_Cookie=null; 
        if (cookies==null || cookies.length == 0) {
        // no cookies
        dealWithInvalidCookie();
        } else {
        for (Cookie c:cookies) {
        String cookieName = c.getName();
        if (cookieName.equals("username")) {
        n_Cookie=c;
        } else if (cookieName.equals("soccerteam")) {
        c_Cookie=c;
                }
            }
        }
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html><body>");
            out.println("<h1> Welcome : "+n_Cookie.getValue()+"</h1>"+"<h2> Your team is : "+c_Cookie.getValue()+"</h2>");
            request.getRequestDispatcher("forgetCookie.html").include(request, response);
            out.println("</body></html>");
        }
    }
    
    protected void normalReq(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String name = request.getParameter("username");
        String soccerteam = request.getParameter("soccerteam");
        Cookie nC = new Cookie("username",name);
        Cookie sC = new Cookie("soccerteam",soccerteam);
        response.addCookie(nC);
        response.addCookie(sC);

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html><body>");
            out.println("<h1> Welcome : "+name+"</h1>"+"<h2> You are a fan of : "+soccerteam+"</h2>");
            request.getRequestDispatcher("forgetCookie.html").include(request, response);
            out.println("</body></html>");
        }
    }
    
    protected void signUp(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html><body>");
            request.getRequestDispatcher("inputForm.html").include(request, response);
            out.println("</body></html>");
        }
    }
    
    /////////////
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nameInput = request.getParameter("username");
        String soccerteam = request.getParameter("soccerteam");
        if(nameInput != null){
            normalReq(request, response);
        }else{
            Cookie cookies[] = request.getCookies();
            if(cookies==null || cookies.length == 0){
                signUp(request, response);
            }
            else{
                haveCookie(request, response);
            }
            
        }
//        processRequest(request, response);
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
         String nameInput = request.getParameter("username");
        String soccerteam = request.getParameter("soccerteam");
        if(nameInput != null){
            normalReq(request, response);
        }else{
            Cookie cookies[] = request.getCookies();
            if(cookies==null || cookies.length == 0){
                signUp(request, response);
            }
            else{
                haveCookie(request, response);
            }
            
        }
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

