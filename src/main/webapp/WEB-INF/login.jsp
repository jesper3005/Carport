<%-- 
    Document   : login
    Created on : 03-12-2018, 11:37:56
    Author     : Jesper
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
            <% String error = (String) request.getAttribute("error"); %>
            <% if(error != null) { %>
            <h2><%=error %></h2>
            <% } %>
        
        <h1>Login</h1>
        <form name="login" action="FrontController" method="POST"/>
            <input type="text" name="email" placeholder="Email.." required="">
            <input type="password" name="password" placeholder="Password.." required="">
            <input type="hidden" name="command" value="login">
            <button type="submit" name="Login">Login</button>
        </form>
        
        
    </body>
</html>
