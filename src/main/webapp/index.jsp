<%-- 
    Document   : index
    Created on : 13-11-2018, 10:25:42
    Author     : Jesper
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Home</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./CSS/headerCSS.css">
        <link rel="icon" href=""
    </head>
    <body>
        <header>
            <img id="fog" src="./IMAGES/FogLogo.png" alt="logo">
            <a href="#Admin">Sign up</a>
            <a href="#Profile">Login</a> 
            <a class="active" href="/index.jsp">Home</a>
        </header>

    <center>
        <form action="FrontController" method="post">

            <h2>Vælg hvilken tag type du ønsker</h2>


            <div class="container">
                <img src="./IMAGES/spidsTag.jpg" class="image">
                <div class="overlay overlayFade">
                    <div class="text">
                        <h1>Spidst tag</h1>
                        Quick-byg carport med spidst tag
                    </div>
                </div>
                <input type="hidden" name="command" value="PointedRoof">
                <input type="submit" value="Spidst Tag">
            </div>
        </form>

        <form action="FrontController" method="post">
            <div class="container">
                <img src="./IMAGES/fladtTag.png" class="image">
                <div class="overlay overlayFade">
                    <div class="text">
                        <h1>Fladt tag</h1>
                        Quick-byg carport med fladt tag
                    </div>
                </div>
                <input type="hidden" name="command" value="FlatRoof">
                <input type="submit" value="Fladt tag">
            </div>
        </form>
    </center>



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
