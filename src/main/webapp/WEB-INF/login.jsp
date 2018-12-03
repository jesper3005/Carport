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
            <img id="fog" src="./IMAGES/FogLogo.png" alt="logo">
            <a class="active" href="/FrontController?command=toRegi">Sign up</a>
            <a class="active" href="/FrontController?command=toLogin">Login</a>
            <a class="active" href="/index.jsp">Home</a>
            <a class="active" href="/FrontController?command=Admin">Admin</a>
        </form>
        
        
    </body>
</html>
