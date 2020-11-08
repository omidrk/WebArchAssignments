<%-- 
    Document   : index
    Created on : Nov 1, 2020, 11:56:19 AM
    Author     : Dimo
--%>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="lib/style/styles.css">
        <script src="lib/script/scripts.js?version=5" type="text/javascript"></script>
        <title>News feed</title>
        <script>
                initData2();
                StartInterval(this);
        </script> 

             
    </head>
    <body>
        
          <ul>
            <li><a href="index.jsp">Home</a></li>
            <li><a href="admin.jsp">Admin</a></li>
            <li style="float:right"><a class="active" href="login.jsp">Login</a></li>
          </ul>
        
        <div class="w3-container" id="cards">
            <h2>Latest news.</h2>
                        
<!--            <div class="w3-panel w3-card-4">
                <p>w3-card-4</p>
                
            </div>-->
        </div>
        
    </body>
</html>
