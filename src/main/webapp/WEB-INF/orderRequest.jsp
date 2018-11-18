<%-- 
    Document   : orderRequest
    Created on : 18-Nov-2018, 20:36:00
    Author     : oerte
--%>

<%@page import="java.util.List"%>
<%@page import="functionLayer.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Order Request</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./CSS/headerCSS.css">
        <link rel="icon" href=""
    </head>
    <body>
        <%List<Product> stykliste = (List) session.getAttribute("stykliste");%>
        <% double totalPriceOfCarport = (Double) session.getAttribute("totalPriceOfCarport");%>

        <header>
            <img id="fog" src="./IMAGES/FogLogo.png" alt="logo">
            <a href="#Admin">Sign up</a>
            <a href="#Profile">Login</a> 
            <a class="active" href="/index.jsp">Home</a>
        </header>

        <%for (Product list : stykliste) {
        out.print(list+"</br>");
        }%>
        <%="Total Price: " +totalPriceOfCarport+ " DKK"%>
        
    </body>
</html>
