package it.unitn.disi.jadidi.delivery2;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//this filter will check the if session is working and also user is athenticated

@WebFilter(
        servletNames = {"mainServlet","changePass"}
        ,urlPatterns = {"/postLogin","/postLogin.jsp","/changePass","/changePass.jsp"})
public class auth implements Filter {
 
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
 
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest hreq = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        
        HttpSession session = hreq.getSession(false);
        boolean isLoggedIn = (session != null && session.getAttribute("userRes") != null);
        String loginURI = hreq.getContextPath() + "/login.jsp";
        
        if (isLoggedIn) {
            // the user is already logged in 
            // then forwards to the user's main page
            chain.doFilter(request, response);
            
        } else {
            // forwards to the Login page
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
 
        }}
    
     
    @Override
    public void destroy() {
         
    }   
}