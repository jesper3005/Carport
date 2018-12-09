<%-- 
    Document   : createOrder
    Created on : 29-11-2018, 21:41:03
    Author     : Jesper
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./CSS/headerCSS.css">
        <link rel="stylesheet" href="./CSS/orderCreated.css">
        <title>Tak for dit køb</title>
    </head>
    <body>
        
        <header>
            <img id="fog" src="./IMAGES/FogLogo.png" alt="logo">
            <a href="#SignUp">Sign up</a>
            <a href="#Login">Login</a> 
            <a class="active" href="/index.jsp">Home</a>
            <a class="active" href="/FrontController?command=Admin">Admin</a>
        </header>
        
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
