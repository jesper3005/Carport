<%-- 
    Document   : registration
    Created on : 03-12-2018, 23:38:59
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
        <link rel="stylesheet" href="./CSS/selectBoxes.css">
        <title>Registration</title>
    </head>
    <body>
        <!-- -------HEADER------- -->
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
        
        
        
        <!-- -------INFO OF SITE------- -->
        <% String error = (String) request.getAttribute("error");%>
        <% if (error != null) {%>
        <div class="container">
            <div class="control-groupText">
                <h1 class="title"> Error!! </h1>
                <% out.print(error); %>
            </div>
        </div>
        <%} else {%>
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
                Udfyld de nødvendige felter og tryk opret bruger.     
            </div>
        </div>
        <%}%>

        <!-- -------CREATE USER------- -->
        <form name="sendOrder" action="FrontController" method="POST">
            <div class="container">
                <div class="control-groupForm">
                    <input type="checkbox" onclick="myFunction()">Show Password
                    </br>
                    </br>
                    <div class="selectForm">
                        <h1 class="title">Udfyld formen og opret dig som bruger</h1>
                        <h4>Email</h4>
                        <!-- An <input> element with type="email" that must be in the following order: 
                        characters@characters.domain (characters followed by an @ sign, followed by more characters, and then a "." 
                        After the "." sign, add at least 2 letters from a to z:-->
                        <input type="text" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" placeholder="Email.." required="" >
                        <h4>Password </h4>
                        <input type="password" name="password1" pattern=".{6,}" placeholder="Password skal være minimum 6 lang." id="myInput" required="">
                        <h4>Confirm password</h4>
                        <input type="password" name="password2" pattern=".{6,}" placeholder="Confirm password.." required="">
                        <h4>Fornavn</h4>
                        <input type="text" name="firstName" placeholder="Fornavn.." required="">
                        <h4>Efternavn</h4>
                        <input type="text" name="lastName" placeholder="Efternavn.." required="">
                        <h4>Addresse</h4>
                        <input type="text" name="address" placeholder="Din fulde addresse..">
                        <h4>By</h4>
                        <input type="text" name="town" placeholder="By..">
                        <h4>Post nummer</h4>
                        <input type="text" pattern="\d*" maxlength="4" name="zipCode" placeholder="Postnummer.." >
                        <h4>Telefon nummer</h4>
                        <input type="number" name="phone" placeholder="Telefon nummer.."> 
                        <input type="hidden" name="currentSite" value="registration">
                        <input type="hidden" name="command" value="registrate">
                        </br>
                        </br>
                        <button type="submit" name="createUser">Opret bruger</button>
                    </div>
                </div>
            </div>
        </form>
        <script>
            function myFunction() {
                var x = document.getElementById("myInput");
                if (x.type === "password") {
                    x.type = "text";
                } else {
                    x.type = "password";
                }
            }
        </script>
    </body>
</html>
