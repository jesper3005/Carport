<%-- 
    Document   : createOrder
    Created on : 29-11-2018, 21:41:03
    Author     : Jesper
--%>

<%@page import="functionLayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="./IMAGES/FogLogo.png"/>
        <link rel="stylesheet" href="./CSS/headerCSS.css">
        <link rel="stylesheet" href="./CSS/orderCreated.css">
        <title>Tak for dit køb</title>
    </head>
    <body>
        
        <% User user = (User) session.getAttribute("user"); %>
        
       <%if(user == null) { %>
        <header>
            <img id="fog" src="./IMAGES/FogLogo.png" alt="logo">
            <a class="active" href="/Carport/FrontController?command=toNavigator&site=registration">Sign up</a>
            <a class="active" href="/Carport/FrontController?command=toNavigator&site=login">Login</a>
            <a class="active" href="/Carport/FrontController?command=toNavigator&site=home">Home</a>
        </header>

        <%} else if (user.getRole().equals("admin")) {%> 
        <header>
            <img id="fog" src="./IMAGES/FogLogo.png" alt="logo">
            <a class="active" href="/Carport/FrontController?command=toNavigator&site=logout">Sign out</a>
            <a class="active" href="/Carport/FrontController?command=Admin">Admin</a>
            <a class="active" href="/Carport/FrontController?command=manageOrders">Se Ordre</a>
            <a class="active" href="/Carport/FrontController?command=toNavigator&site=home">Home</a>
        </header>
        <%} else if (user.getRole().equals("customer")) { %>
        <header>
            <img id="fog" src="./IMAGES/FogLogo.png" alt="logo">
            <a class="active" href="/Carport/FrontController?command=toNavigator&site=logout">Sign out</a>
            <a class="active" href="">Profile</a>
            <a class="active" href="/Carport/FrontController?command=toNavigator&site=home">Home</a>
        </header>
        <%}%>
        
        <div class="containerOrderCreated">
            <div class="control-groupOrderCreated">
                Tak for din ordre!
                <br>
                <br>
                <img src="./IMAGES/confirmed.svg" height="100px" width="100px">
                <br>
                <br>
                Din ordre bliver behandlet af vores medarbejder snarest muligt.
                <br>
                
            </div>
        </div>
        
        
    </body>
</html>
