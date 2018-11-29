<%-- 
    Document   : index
    Created on : 13-11-2018, 10:25:42
    Author     : Jesper
--%>

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
        
        <header>
            <img id="fog" src="./IMAGES/FogLogo.png" alt="logo">
            <a href="#SignUp">Sign up</a>
            <a href="#Login">Login</a> 
            <a class="active" href="/index.jsp">Home</a>
            <a class="active" href=http://localhost:8084//FrontController?command=Admin>Admin</a>
            <!-- <input type='submit' value="Log Out">-->
        </header>

            
        <div class="containerTextIndex">
            <div class="control-groupTextIndex">
                <h1 class="title">Velkommen til Quick-byg carport med fladt tag !</h1>
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
                <input type="hidden" name="command" value="PointedRoof">
                <input type="image" src="./IMAGES/spidsTag.jpg" class="image" value="Spidst Tag">
            </div>
        </form></center>
    <center>
        <form action="FrontController" method="post">
            <div class="containerPic">
                <div class="overlay overlayFade">
                    <div class="text">
                        <h1>Fladt tag</h1>
                        Quick-byg carport med fladt tag
                    </div>
                </div>
                <input type="hidden" name="command" value="FlatRoof">
                <input type="image" src="./IMAGES/fladtTag.png" class="image" value="Fladt tag">
            </div>
        </form>
    </center>
        </div>




    <!--
    <div class="container">
        <a href="/carportSpidsTag.jsp"><img src="./IMAGES/spidsTag.jpg" class="image"></a>
        <div class="overlay overlayFade">
            <div class="text">
                <h1>Spidst tag</h1>
                Quick-byg carport med spidst tag
            </div>
        </div>
    </div>
    
    <div class="container">
        <a href="/carportFlatTag.jsp"><img src="./IMAGES/fladtTag.png" class="image"></a>
        <div class="overlay overlayFade">
            <div class="text">
                <h1>Fladt tag</h1>
                Quick-byg carport med fladt tag
            </div>
        </div>
    </div> -->


</body>
</html>
