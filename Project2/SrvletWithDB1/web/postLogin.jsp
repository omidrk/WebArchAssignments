<%-- 
    Document   : postLogin
    Created on : Oct 9, 2020, 12:33:10 AM
    Author     : Dimo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@page import="it.unitn.disi.jadidi.delivery2.User"%>
<%@page language="java" session="true" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Post Login</title>
    </head>
    <body>
        Session is new? <% out.println(session.isNew()); %>
        <ul>
            <li>Your userName is: " ${userRes.USERNAME}</li>
        <li>Your session ID is " <%= session.getId() %></li>
        <li>Session creation time is
        <%= new Date(session.getCreationTime()) %> </li>
        <li>Session last access time is <%=
        new Date(session.getLastAccessedTime()) %> </li>
        <li>Session max inactive interval is <%=
        session.getMaxInactiveInterval() %> seconds</li>
        </ul>
        <p><a href='<%= request.getRequestURI() %>'>Refresh</a>
        <p><a href='changePass.jsp'>
        Change Password</a>
        <form method="GET" action="endSession">
        <input type="submit" value="End Session">
        </form>
    </body>
</html>
