<%-- 
    Document   : carportSpidsTag
    Created on : 13-11-2018, 10:55:35
    Author     : Jesper
--%>

<%@page import="functionLayer.LogicFacade"%>
<%@page import="java.util.List"%>
<%@page import="functionLayer.Produkt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./CSS/headerCSS.css">
        <title>JSP Page</title>
    </head>
    <body>
        <% List<Produkt> productList = LogicFacade.getAllProduktFromDatabase();%>
        <header>
            <img id="fog" src="./IMAGES/FogLogo.png" alt="logo">
            <a href="#Admin">Sign up</a>
            <a href="#Profile">Login</a> 
            <a class="active" href="/index.jsp">Home</a>
        </header>

    <center><h1>Carport med fladt tag</h1></center>

    <br>

    <form name="FlatCarport" action="FrontController" method="POST">
        <input type="hidden" name="command" value="FlatCarport">

        <h4>Carport bredde:</h4>
        <select name="bredde">
            <% for (Produkt listOfRem : productList) {%>
            <% System.out.println(listOfRem);%>
            <%if (listOfRem.getCategory().equals("rem")) {%>
            out.print(<option value="<%=listOfRem.getLength()%>"><%=listOfRem.getLength()%> mm</option>);
            <%}
                }%>
        </select>
        <!-- <option value="1">Vælg bredde</option>
        <option value="2">240cm</option>
        <option value="3">270cm</option>
        <option value="4">300cm</option>
        <option value="5">330cm</option>
        <option value="6">360cm</option>
        <option value="7">390cm</option>
        <option value="8">420cm</option>
        <option value="9">450cm</option>
        <option value="10">480cm</option>
        <option value="11">510cm</option>
        <option value="12">540cm</option>
        <option value="13">570cm</option>
        <option value="14">600cm</option>
        <option value="15">630cm</option>
        <option value="16">660cm</option>
        <option value="17">690cm</option>
        <option value="18">720cm</option>
        <option value="19">750cm</option>  -->   

        <br>

        <h4>Carport længde:</h4>
        <select name="Længde">
            <% for (Produkt listOfRem : productList) {%>
            <%if (listOfRem.getCategory().equals("rem")) {%>
            out.print(<option value="<%=listOfRem.getLength()%>"><%=listOfRem.getLength()%> mm</option>);
            <%}
                }%>
        </select>
           <!-- <option value="1">Vælg længde</option>
            <option value="2">240cm</option>
            <option value="3">270cm</option>
            <option value="4">300cm</option>
            <option value="5">330cm</option>
            <option value="6">360cm</option>
            <option value="7">390cm</option>
            <option value="8">420cm</option>
            <option value="9">450cm</option>
            <option value="10">480cm</option>
            <option value="11">510cm</option>
            <option value="12">540cm</option>
            <option value="13">570cm</option>
            <option value="14">600cm</option>
            <option value="15">630cm</option>
            <option value="16">660cm</option>
            <option value="17">690cm</option>
            <option value="18">720cm</option>
            <option value="19">750cm</option>
            <option value="20">780cm</option>-->

        <br>

        <h4>Tag</h4>
        <select name="Tag">
            <option value="1">Vælg tag</option>
            <option value="2">Plasttrapezplader</option>

        </select>

        <br>

        <h4>Redskabsrum bredde</h4>
        <select name="Redskabsrum bredde">
            <option>Jeg ønsker ikke redskabsskur</option>
        </select>

        <br>

        <h4>Redskabsrum længde</h4>
        <select name="Redskabsrum længde">
            <option>Jeg ønsker ikke redskabsskur</option>
        </select>

        <br>
        <h4>Vis Carport</h4>
        <input type="submit" value="Vis Carport">

        <br>


        <h4>Navn</h4>
        <input type="text" name="navn">
        <h4>Addresse</h4>
        <input type="text" name="addresse">
        <h4>Postnummer</h4>
        <input type="text" name="postnummer">
        <h4>By</h4>
        <input type="text" name="by">
        <h4>Telefon</h4>
        <input type="text" name="telefon">
        <h4>Email-addresse</h4>
        <input type="email" name="email">
        <h4>Evt. bemærkninger</h4>
        <input type="text" name="bemærkninger">
    </form>

</body>
</html>
