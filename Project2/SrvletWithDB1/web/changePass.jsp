<%-- 
    Document   : changePass
    Created on : Oct 9, 2020, 6:22:02 PM
    Author     : Dimo
--%>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Pass</title>
    </head>
    <body>
        <div >
            <h1>CHange here</h1>
            <form action="changePass" method="POST">  
                <label for="password">New Password:</label>
                <input type="password" name="password"/><br/><br/>  
                <input type="submit" value="Change"/> 
                <a href="postLogin"><br>Go Back</a>
                <h1 style="color: red;">${message}</h1>
                
                   
            </form>
            
        </div>
    </body>
</html>
