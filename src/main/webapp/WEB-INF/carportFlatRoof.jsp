<%-- 
    Document   : carportSpidsTag
    Created on : 13-11-2018, 10:55:35
    Author     : Jesper
--%>

<%@page import="java.util.List"%>
<%@page import="functionLayer.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Fladt Tag</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./CSS/headerCSS.css">
        <link rel="icon" href=""
    </head>
    <body>
        <% List<Product> productList = (List<Product>) session.getAttribute("productList");%>
        <header>
            <img id="fog" src="./IMAGES/FogLogo.png" alt="logo">
            <a href="#SignUp">Sign up</a>
            <a href="#Login">Login</a> 
            <a class="active" href="/index.jsp">Home</a>
            <a class="active" href=http://localhost:8084//FrontController?command=Admin>Admin</a>
            
        </header>

    <center><h1>Carport med fladt tag</h1></center>

    <br>

    <form name="FlatRoof" action="FrontController" method="POST">
        <input type="hidden" name="command" value="OrderRequest">

        <h4>Carport bredde:</h4>
        <select name="bredde">
            <% for (Product listOfRem : productList) {%>
            <%if (listOfRem.getCategory().equals("rem")) {%>
            out.print(<option value="<%=listOfRem.getLength()%>"><%=listOfRem.getLength()%> cm</option>);
            <%}
                }%>
        </select>

        <br>

        <h4>Carport længde:</h4>
        <select name="laengde">
            <% for (Product listOfRem : productList) {%>
            <%if (listOfRem.getCategory().equals("rem")) {%>
            out.print(<option value="<%=listOfRem.getLength()%>"><%=listOfRem.getLength()%> cm</option>);
            <%}
                }%>
        </select>

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
        <div id="requestForm">
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
            <input type="text" name="email">
            <h4>Evt. bemærkninger</h4>
            <input type="text" name="bemærkninger">
            <br> 
            <br>
            <input type="hidden" name="command" value="OrderRequest">
            <button type="submit">Send forspørgelse</button>
        </div>
    </form>    

</body>
</html>
