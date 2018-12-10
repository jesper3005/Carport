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
        <title>Order Request Flad Tag</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./CSS/headerCSS.css">
        <link rel="stylesheet" href="./CSS/orderRequest.css">
        <link rel="stylesheet" href="./CSS/selectBoxes.css">
        <link rel="icon" href=""
    </head>
    <body>
        <% double totalPriceOfCarport = (Double) session.getAttribute("totalPrice");%>


        <header>
            <img id="fog" src="./IMAGES/FogLogo.png" alt="logo">
            <a class="active" href="/FrontController?command=toRegi">Sign up</a>
            <a class="active" href="/FrontController?command=toLogin">Login</a>
            <a class="active" href="/index.jsp">Home</a>
            <a class="active" href="/FrontController?command=Admin">Admin</a>
        </header>
        <div class="container">
            <div class="control-groupText">
                <h1 class="title">Her er en skitse af din carport !</h1>
                Der er en skitse fra oven og en fra siden.
                <br>
                <br>
                Du kan altid gå tilbage hvis du har brug for at lave en ændring
                <br>
                Nedenunder billederne kan du indtaste dine oplysninger og indsende en forespørgelse.
                <br>
                <br>    
                Vi har eksperter på plads til at håndtere din forespørgelse og sikre 
                <br>
                at du får lige den carport du ønsker dig.
                <br>
                <br>
                Ved bestilling medfølger standardbyggevejledning,
                <br>
                samt en stykliste af produkter som der skal bruges.
                <br>
                <br>
                <%="Prisforslag: "+totalPriceOfCarport+" DKK" %>
            </div>
        </div>
        <div class="drawings">
            <center><select name="test" id="mySelect" onchange="myFunction()">
                    <option>Vælg en skitse du vil se</option>
                    <option value="top">Top</option>
                    <option value="side">Side</option>

                </select>
                <p id="demo"></p>
        </div></center>
    <script>
        function myFunction() {
            var top = '${drawingTop}';
            var side = '${drawingSide}';
            var x = document.getElementById("mySelect").value;
            if (x == "top") {
                document.getElementById("demo").innerHTML = top;
            } else {
                document.getElementById("demo").innerHTML = side;
            }
        }
    </script>
    <form name="sendOrder" action="FrontController" method="POST">
        <input type="hidden" name="command" value="sendOrderFlat">
        <div class="container">
            <div class="control-groupForm">
                <div class="selectForm">
                    <h1 class="title">Udfyld formularen og send en forspørgelse</h1>
                    <h4>Fornavn</h4>
                    <input type="text" name="fornavn" placeholder="fornavn" required="" >
                    <h4>Efternavn</h4>
                    <input type="text" name="efternavn" placeholder="efternavn" required="">
                    <h4>Addresse</h4>
                    <input type="text" name="addresse" placeholder="din fulde addresse" required="">
                    <h4>Postnummer</h4>
                    <input type="text" name="postnummer" placeholder="2300" required="">
                    <h4>By</h4>
                    <input type="text" name="by" required="">
                    <h4>Telefon</h4>
                    <input type="text" name="telefon" required="">
                    <h4>Email-addresse</h4>
                    <input type="text" name="email" required="">
                    <h4>Evt. bemærkninger</h4>            
                    <textarea name="comment" form="usrform"></textarea>
                    <button type="submit" name="request">Send forspørgelse</button>
                </div>
            </div>
        </div>
    </form>
</body>
</html>
