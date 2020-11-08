/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.jadidi.delivery3;

import argo.format.JsonFormatter;
import argo.format.PrettyJsonFormatter;
import argo.jdom.JdomParser;
import argo.jdom.JsonNode;
import static argo.jdom.JsonNodeBuilders.aStringBuilder;
import static argo.jdom.JsonNodeBuilders.anObjectBuilder;
import argo.jdom.JsonObjectNodeBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toSet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 *
 * @author Dimo
 */

@WebServlet("/admin")

public class adminServlet extends HttpServlet {
    data memData;
    ServletContext app;
    private static final JsonFormatter JSON_FORMATTER
        = new PrettyJsonFormatter();
    

 //getRequest will get the id and send the result of id greater than req.
    protected void getRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String idd = request.getParameter("id");
        if(idd == null){idd = "0";};
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
            out.println(jsonText);
        }
        
    }
    
    
    //post request is for adding the new news by admin only.
    protected void PostRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String news = request.getParameter("news");
//        System.out.println(news.length());
        if(news == null && news != "" && news.length()>=3){
            try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("API error: news cant be null.");
            }
        }else{
            
        app = getServletContext();
        JsonObjectNodeBuilder builder = anObjectBuilder();
        memData =(data) app.getAttribute("news");
        Integer size = memData.news.size();
        memData.news.put(size, news);
        this.getServletConfig().getServletContext().setAttribute("news", memData);
        builder.withField(size.toString(), aStringBuilder(news));

        
        JsonNode json = builder.build();
        String jsonText = JSON_FORMATTER.format(json);
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println(jsonText);
        }
        
                

       
        }}

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getRequest(request, response);
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PostRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
