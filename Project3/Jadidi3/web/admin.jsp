<%-- 
    Document   : admin
    Created on : Nov 1, 2020, 12:25:17 PM
    Author     : Dimo
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="it.unitn.disi.jadidi.delivery3.data"%>
<%! %>

<!DOCTYPE html>
<html>
<head>

    <link rel="stylesheet" href="lib/style/styles.css?version=2">
    <script src="lib/script/scripts.js?version=8" type="text/javascript"></script>
</head>
<body>
    <ul>
            <li><a href="index.jsp">Home</a></li>
            <li><a href="admin.jsp">Admin</a></li>
            
            <!--<li style="float:right"><a class="active" href="login.jsp">Login</a></li>-->
    </ul>

    <table id="Table" class="MyTable">
  <tr>
    <th>News</th>
    <th>Id</th>
    <th>
        <button type="button" class="btnn" onclick="addNews()" >ADD NEWS</button>
    </th>
  <script>
      initDataAdmin();
  </script>
  </tr>
  
  
</table>
    <div id="error">
        
    </div>

    <ul>
            
            <li style="float:right;margin: 5px"><a class="active" href="end">Logout</a></li>
    </ul>
</body>

</html>
