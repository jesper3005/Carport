<%-- 
    Document   : login
    Created on : 03-12-2018, 11:37:56
    Author     : Jesper
--%>

<%@page import="functionLayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="./IMAGES/FogLogo.png"/>
        <link rel="stylesheet" href="./CSS/selectBoxes.css">
        <link rel="stylesheet" href="./CSS/headerCSS.css">
        <title>Login</title>
    </head>
    <body>
        <% User user = (User) session.getAttribute("user"); %>
        
        <% String error = (String) request.getAttribute("error"); %>
        <% if(error != null) { %>
        <script>alert("<%=error%>")</script>
        <% } %>
        
        
       <%if(user == null) { %>
        <header>
            <img id="fog" src="./IMAGES/FogLogo.png" alt="logo">
            <a class="active" href="/FrontController?command=toNavigator&site=registration">Sign up</a>
            <a class="active" href="/FrontController?command=toNavigator&site=login">Login</a>
            <a class="active" href="/FrontController?command=toNavigator&site=home">Home</a>
        </header>
        
        <%} else if(user.getRole().equals("admin")) {%> 
            <header>
                <img id="fog" src="./IMAGES/FogLogo.png" alt="logo">
                <a class="active" href="/FrontController?command=toNavigator&site=logout">Sign out</a>
                <a class="active" href="/FrontController?command=Admin">Admin</a>
                <a class="active" href="/FrontController?command=manageOrders">Se Ordre</a>
                <a class="active" href="/FrontController?command=toNavigator&site=home">Home</a>
            </header>
        <%} else if(user.getRole().equals("customer")) { %>
            <header>
                <img id="fog" src="./IMAGES/FogLogo.png" alt="logo">
                <a class="active" href="/FrontController?command=toNavigator&site=logout">Sign out</a>
                <a class="active" href="">Profile</a>
                <a class="active" href="/FrontController?command=toNavigator&site=home">Home</a>
            </header>
        <%}%>
        
            
        <div class="container">
            <div class="control-group">
                <h1>Login</h1>
                <form name="login" action="FrontController" method="POST"/>
                    <input type="text" name="email" placeholder="Email.." required="">
                    <input type="password" name="password" placeholder="Password.." required="">
                    <input type="hidden" name="command" value="login">
                    <button type="submit" name="Login">Login</button>
                </form>
            </div>
        </div>
        
        
    </body>
</html>
