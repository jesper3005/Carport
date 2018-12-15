<%-- 
    Document   : customerOrderInfo
    Created on : 13-12-2018, 19:47:19
    Author     : Jesper
--%>

<%@page import="functionLayer.User"%>
<%@page import="functionLayer.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="./IMAGES/FogLogo.png"/>
        <link rel="stylesheet" href="./CSS/selectBoxes.css">
        <link rel="stylesheet" href="./CSS/headerCSS.css">
        <title>Kunde oplysninger</title>
    </head>
    
    <% User user = (User) session.getAttribute("user"); %>
    
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
        
    <body>
        <% Customer customer = (Customer) session.getAttribute("customerInfo"); %>
        
        <div class="container">
            <div class="control-group">    
                <h1>Kunde oplysninger</h1>
                <br>
                <br>
                <%="Fornavn: " + customer.getFirstName() %>
                <br>
                <br>
                <%="Efternavn: " + customer.getLastName() %>
                <br>
                <br>
                <%="Telefon nummer: " + customer.getPhone() %>
                <br>
                <br>
                <%="Postnummer: " + customer.getZipCode() %>
                <br>
                <br>
                <%="By: " + customer.getTown() %>
                <br>
                <br>
                <%="Adresse: " + customer.getAddress() %>
                <br>
                <br>
                <%="Kommentar: " + customer.getComments() %>
        
            </div>
        </div>
    </body>
</html>
