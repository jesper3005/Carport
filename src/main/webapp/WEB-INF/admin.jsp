<%-- 
    Document   : admin
    Created on : 21-Nov-2018, 18:17:47
    Author     : oerte
--%>

<%@page import="java.util.List"%>
<%@page import="functionLayer.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Admin</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./CSS/headerCSS.css">
        <link rel="stylesheet" href="./CSS/orderRequest.css">
        <link rel="icon" href=""
    </head>
    <header>
        <img id="fog" src="./IMAGES/FogLogo.png" alt="logo">
        <a href="#SignUp">Sign up</a>
        <a href="#Login">Login</a> 
        <a class="active" href="/index.jsp">Home</a>
        <a class="active" href=http://localhost:8084//FrontController?command=Admin>Admin</a>
    </header>
    <body>
        <%List<Product> allProdukt = (List) session.getAttribute("allProdukt");%>
        
        <div id="table">
            <table class="blueTable">
                <thead>
                    <tr>
                        <th>Produkt Navn</th>
                        <th>Kategori</th>
                        <th>StykPris</th>
                        <th>Længde</th>
                        <th>Bredde</th>
                        <th>Højde</th>
                        <th>Slet Produkt</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <% for (Product list : allProdukt) {%>
                        <td><%=list.getProduktName()%></td><td><%=list.getCategory()%></td><td><%=list.getPrice() + " DKK"%></td><td><%=list.getLength()%></td><td><%=list.getWidth()%></td><td><%=list.getHeight()%></td><td><input type="submit" value="Slet"></td></tr>
                            <%}%>

                </tbody>
                </tr>
            </table>
        </div>
        <form name="Admin" action="FrontController" method="POST">
             <input type="hidden" name="command" value="AddProdukt">
            <h1>Tilføj en nye produkt til produktlinjen:</h1>
            <h4>Produkt Navn</h4>
            <input type="text" name="produkt_name">
            <h4>Produkt Kategori</h4>
            <input type="text" name="category">
            <h4>Stykpris</h4>
            <input type="text" name="price">
            <h4>Længde</h4>
            <input type="text" name="length">
            <h4>Bredde</h4>
            <input type="text" name="width">
            <h4>højde</h4>
            <input type="text" name="height">
            </br>
            </br>
            <input type="submit" value="AddProdukt">
        </form>
        </br>
        </br>
        <form name="Admin" action="FrontController" method="POST">
            <input type="submit" hidden="command" value="Admin">
            <h1>Slet et produkt fra produktlinjen:</h1>
         

        </form>
    </body>
</html>
