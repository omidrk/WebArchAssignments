
package it.unitn.disi.jadidi.delivery3;

import argo.format.JsonFormatter;
import argo.format.PrettyJsonFormatter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import it.unitn.disi.jadidi.delivery3.data;
import argo.jdom.JdomParser;
import argo.jdom.JsonNode;
import static argo.jdom.JsonNodeFactories.*;
import static argo.jdom.JsonNodeBuilders.*;
import argo.jdom.JsonObjectNodeBuilder;
import java.util.Map;
import javax.servlet.ServletContext;

import java.util.HashMap;




/**
 *
 * @author Dimo
 */
@WebServlet("/index")
public class mainServ extends HttpServlet {
    data newsData;
    data memData;
    ServletContext app;
    private static final JsonFormatter JSON_FORMATTER
        = new PrettyJsonFormatter();



      @Override
      public void init() throws ServletException{
      log("init executed");
      this.newsData =new data();
      this.app = getServletContext();
      newsData.news.put(newsData.news.size(), "news 1");
      newsData.news.put(newsData.news.size(), "news 2");
      newsData.news.put(newsData.news.size(), "news 3");
      app.setAttribute("news", newsData);
      this.getServletConfig().getServletContext().setAttribute("news", newsData);
       

      }

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String idd = request.getParameter("id");
        if(idd == null){idd = "0";}
        Integer id = Integer.parseInt(idd);
        app = getServletContext();
        JsonObjectNodeBuilder builder = anObjectBuilder();
        memData =(data) app.getAttribute("news");

        
        memData.news.entrySet().stream().filter(item -> item.getKey()>id)
                .forEach(item -> {
                    builder.withField(item.getKey().toString(), aStringBuilder(item.getValue()));
        });
        
        JsonNode json = builder.build();
        String jsonText = JSON_FORMATTER.format(json);
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println(jsonText);
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

}
