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
    </br>
    </br>
    <body>
        <%List<Product> allProduct = (List) session.getAttribute("allProduct");%>
    <td>
        <form action="FrontController" method="POST" />
        <input type="hidden" name="command" value="UpdateProduct"/>

    </td>
    <div id="table">
        <table class="blueTable">
            <thead>
                <tr>
                    <th>Select</th>
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
                    <% for (Product list : allProduct) {%>
                    <td><input type="checkbox" name="Select" value="<%=list.getId()%>"></td><td><%=list.getProduktName()%></td><td><%=list.getCategory()%></td><td><%=list.getPrice() + " DKK"%></td><td><%=list.getLength()%></td>
                    <td><%=list.getWidth()%></td><td><%=list.getHeight()%></td>
                    <td><%out.println("<a href=\"http://localhost:8084//FrontController?command=UpdateProduct&product_id=" + list.getId() + "\")>");%>Slet</td>
                </tr>
                <%}%>

            </tbody>
            </tr>
        </table>
    </div>
    <div>
        <input type="text" name="search" placeholder="Search.."> 
    </div>     
    <input type = "submit" name="action" value = "Slet" >
    <input type = "submit" name="action" value = "Update" >
    <input type = "submit" name="action" value = "Search" >
</form>

</br>
</br>
<form name="AddProduct" action="FrontController" method="POST">
    <input type="hidden" name="command" value="AddProduct">
    <h1>Tilføj en nye produkt til produktlinjen:</h1>
    <h4>Produkt Navn</h4>
    <input type="text" name="produkt_name">
    <h4>Produkt Kategori</h4>
    <input type="text" name="category">
    <h4>Stykpris</h4>
    <input id="number" type="number" name="price">
    <h4>Længde</h4>
    <input id="number" type="number" name="length">
    <h4>Bredde</h4>
    <input id="number" type="number" name="width">
    <h4>Højde</h4>
    <input id="number" type="number" name="height">
    </br>
    </br>
    <input type="submit" value="AddProduct">
</form>
</body>
</html>
