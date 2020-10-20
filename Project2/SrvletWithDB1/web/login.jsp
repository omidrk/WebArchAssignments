<%-- 
    Document   : login
    Created on : Oct 9, 2020, 12:07:06 AM
    Author     : Dimo
--%>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>login page</title>
    </head>
    <body>
        <div >
            <h1>Login here</h1>
            <form action="login" method="POST">  
                <label for="username">User Name:</label>
                <input  name="username"/><br/><br/>  
                <label for="password">Password:</label>
                <input type="password" name="password"/><br/><br/>  
                <input type="submit" value="login"/> 
                <h1 style="color: red;">${message}</h1>
                   
            </form>
            
        </div>
    </body>
</html>
