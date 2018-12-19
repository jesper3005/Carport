<%-- 
    Document   : seeOrderProductList
    Created on : 11-12-2018, 15:00:04
    Author     : Jesper
--%>

<%@page import="functionLayer.User"%>
<%@page import="functionLayer.Product"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="./IMAGES/FogLogo.png"/>
        <link rel="stylesheet" href="./CSS/tableDesign.css">
        <link rel="stylesheet" href="./CSS/headerCSS.css">
        <title>JSP Page</title>
    </head>
    <body>
        <%List<Product> stykliste = (List) session.getAttribute("orderProductList");%>
        
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
        
        <table class="table-fill">
            <thead>
                <tr>
                    <th>Produkt id</th>
                    <th>Produkt Navn</th>
                    <th>Kategori</th>
                    <th>StykPris</th>
                    <th>Antal</th>
                    <th>LinjePris</th>
                    <th>Længde</th>
                    <th>Bredde</th>
                    <th>Højde</th>
                </tr>
            </thead>
            <tbody class="table-hover">
                    <% for (Product list : stykliste) {%>
                <tr>
                    <td><%=list.getId() %></td>
                    <td><%=list.getProductName()%></td>
                    <td><%=list.getCategory()%></td>
                    <td><%=list.getPrice() + " DKK"%></td>
                    <td><%=list.getQty()%></td>
                    <td><%=list.getPriceLine() + " DKK"%></td>
                    <td><%=list.getLength()%></td>
                    <td><%=list.getWidth()%></td>
                    <td><%=list.getHeight()%></td>
                </tr>
                    <%}%>
            </tbody>
        </table>
        
    </body>
</html>
