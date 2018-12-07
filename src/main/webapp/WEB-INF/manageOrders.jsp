<%-- 
    Document   : manageOrders
    Created on : 07-12-2018, 00:02:50
    Author     : Jesper
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./CSS/headerCSS.css">
        <link rel="stylesheet" href="./CSS/selectBoxes.css">
        
        <title>JSP Page</title>
    </head>
    <body>
        
    <!-- -----------------HEADER---------------------------------- -->
        <header>
            <img id="fog" src="./IMAGES/FogLogo.png" alt="logo">
            <a class="active" href="/FrontController?command=toNavigator&site=registration">Sign up</a>
            <a class="active" href="/FrontController?command=toNavigator&site=login">Login</a>
            <a class="active" href="/index.jsp">Home</a>
            <a class="active" href="/FrontController?command=Admin">Admin</a>
            <a class="active" href="/FrontController?command=manageOrders"></a>
            <!-- <input type='submit' value="Log Out">-->
        </header>
    
    <!-- -----------------Display orders------------------------------------>
    
    <div class="container">
        <div class="control-group">
            <select>
                <option value="1">Alle odre</option>
                <option value="2">Pending odre</option>
                <option value="3">Godkente odre</option>
                <option value="4">Betalte odre</option>
                <option value="5">Sendte odre</option>
                <option value="6">Anulleret odre</option>
            </select>
            <input type="text" name="findOrder" placeholder="Skriv emailen på kunden">
        </div>
    </div>
    
    <div class="container">
        <div class="control-group">
            
        </div>
    </div>
    
    
        
    </body>
</html>
