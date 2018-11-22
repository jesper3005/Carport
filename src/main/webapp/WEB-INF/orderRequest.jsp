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
        <title>Order Request</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./CSS/headerCSS.css">
        <link rel="stylesheet" href="./CSS/orderRequest.css">
        <link rel="icon" href=""
    </head>
    <body>
        <%List<Product> stykliste = (List) session.getAttribute("stykliste");%>
        <% double totalPriceOfCarport = (Double) session.getAttribute("totalPriceOfCarport");%>

        <header>
            <img id="fog" src="./IMAGES/FogLogo.png" alt="logo">
            <a href="#SignUp">Sign up</a>
            <a href="#Login">Login</a> 
            <a class="active" href="/index.jsp">Home</a>
            <a class="active" href=http://localhost:8084//FrontController?command=Admin>Admin</a>
        </header>
        </br>
        </br>
        </br>

        <table class="blueTable">
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
            <tbody>
                <tr>
                    <%for (Product list : stykliste) {%>
                    <td><%=list.getId()%></td><td><%=list.getProduktName()%></td><td><%=list.getCategory()%></td><td><%=list.getPrice() + " DKK"%></td><td><%=list.getQty()%></td><td><%=list.getPriceLine() + " DKK"%></td><td><%=list.getLength()%></td><td><%=list.getWidth()%></td><td><%=list.getHeight()%></td></tr>
                    <%}%>

            </tbody>
        </tr>
    </table>
    </br>
    </br>
    <%="Total Pris: " + totalPriceOfCarport + " DKK"%>
    
                <form action="FrontController" method="post"> 
                <input type="hidden" name="command" value="drawing">
                <input type="submit" value="se tegning">
            </form>

</body>
</html>
