<%-- 
    Document   : index
    Created on : 13-11-2018, 10:25:42
    Author     : Jesper
--%>

<%@page import="functionLayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Fog</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./CSS/headerCSS.css">
        <link rel="stylesheet" href="./CSS/selectBoxes.css">
        <link rel="icon" href=""
    </head>
    <body>
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
                <a class="active" href="/FrontController?command=toLogin">Profile</a>
                <a class="active" href="/FrontController?command=toNavigator&site=home">Home</a>
                <a class="active" href="/FrontController?command=Admin">Admin</a>
                <a class="active" href="/FrontController?command=manageOrders">Se Ordre</a>
                <a class="active" href="/FrontController?command=toNavigator&site=logout">Sign out</a>
                <!-- <input type='submit' value="Log Out">-->
            </header>
        <%} else if(user.getRole().equals("customer")) { %>
            <header>
                <img id="fog" src="./IMAGES/FogLogo.png" alt="logo">
                <a class="active" href="/FrontController?command=toLogin">Profile</a>
                <a class="active" href="/FrontController?command=toNavigator&site=home">Home</a>
                <a class="active" href="">Profile</a>
                <a class="active" href="/FrontController?command=toNavigator&site=logout">Sign out</a>
                <!-- <input type='submit' value="Log Out">-->
            </header>
        <%}%>
        
        
        
        <div class="containerTextIndex">
            <div class="control-groupTextIndex">
                <h1 class="title">Velkommen til Fog Quick-byg carport !</h1>
                <text>Med et specialudviklet computerprogram kan vi lynhurtigt beregne prisen og udskrive en skitsetegning på en carport  </text>
                <br>
                <text>indenfor vores standardprogram, der tilpasses dine specifikke ønsker.</text>
                <br>
                <br>
                Vælg for neden hvilken type carport du ønsker
                <br>
                <br>
                Spidst tag eller fladt tag.
        </div>

    <center>
        <form action="FrontController" method="post">
            <div class="containerPic">                
                <div class="overlay overlayFade">
                    <div class="text">
                        <h1>Spidst tag</h1>
                        Quick-byg carport med spidst tag
                    </div>
                </div>
                <input type="hidden" name="command" value="pointedRoof">
                <input type="image" src="./IMAGES/spidsTag.jpg" class="image" value="Spidst Tag">
            </div>
        </form></center>
    <center>
        <form name="Flat Tag" action="FrontController" method="post">
            <div class="containerPic">
                <div class="overlay overlayFade">
                    <div class="text">
                        <h1>Fladt tag</h1>
                        Quick-byg carport med fladt tag
                    </div>
                </div>
                <input type="hidden" name="command" value="flatRoof">
                <input type="image" src="./IMAGES/fladtTag.png" class="image" value="FladtTag">
            </div>
        </form>
    </center>
        </div>
        
        


</body>
</html>
