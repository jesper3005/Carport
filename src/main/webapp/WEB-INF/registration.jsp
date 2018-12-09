<%-- 
    Document   : registration
    Created on : 03-12-2018, 23:38:59
    Author     : Jesper
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./CSS/headerCSS.css">
        <link rel="stylesheet" href="./CSS/selectBoxes.css">
        <title>Registration</title>
    </head>
    <body>
        <!-- -------HEADER------- -->
        <header>
            <img id="fog" src="./IMAGES/FogLogo.png" alt="logo">
            <a class="active" href="/FrontController?command=toRegi">Sign up</a>
            <a class="active" href="/FrontController?command=toLogin">Login</a>
            <a class="active" href="/index.jsp">Home</a>
            <a class="active" href="/FrontController?command=Admin">Admin</a>
        </header>

        <!-- -------INFO OF SITE------- -->
        <div class="container">
            <div class="control-groupText">
                <h1 class="title">Registre dig som bruger i vores system !</h1>
                At registrere sig bruger giver dig flere goder
                <br>
                Du vil have mulighed for altid at kunne se dine odre
                <br>
                annulere dem, samt se status på ordren.
                <br>
                <br>
                Udfyld de nødvendige felter og tryk lav bruger.     
            </div>
        </div>

        <!-- -------CREATE USER------- -->

        <form name="sendOrder" action="FrontController" method="POST">
            <div class="container">
                <div class="control-groupForm">
                    <div class="selectForm">
                        <h1 class="title">Udfyld formen og opret dig som bruger</h1>
                        <h4>Email</h4>
                        <input type="text" name="email" placeholder="Email.." required="" >
                        <h4>Password</h4>
                        <input type="password" name="password1" placeholder="Password.." required="">
                        <h4>Confirm password</h4>
                        <input type="password" name="password2" placeholder="Confirm password.." required="">
                        <h4>Fornavn</h4>
                        <input type="text" name="firstName" placeholder="Fornavn.." required="">
                        <h4>Efternavn</h4>
                        <input type="text" name="lastName" placeholder="Efternavn.." required="">
                        <h4>Addresse</h4>
                        <input type="text" name="address" placeholder="Din fulde addresse..">
                        <h4>By</h4>
                        <input type="text" name="town" placeholder="By..">
                        <h4>Post nummer</h4>
                        <input type="text" name="zipCode" placeholder="Postnummer..">
                        <h4>Telefon nummer</h4>
                        <input type="text" name="phone" placeholder="Telefon nummer..">           
                        <input type="hidden" name="command" value="registrate">
                        <button type="submit" name="createUser">Opret bruger</button>
                    </div>
                </div>
            </div>
        </form>
    </body>
</html>
