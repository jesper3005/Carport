<%-- 
    Document   : stykliste
    Created on : 29-11-2018, 18:14:38
    Author     : Jesper
--%>

<%@page import="java.util.List"%>
<%@page import="functionLayer.Product"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <%List<Product> stykliste = (List) session.getAttribute("stykliste");%>
        <% double totalPriceOfCarport = (Double) session.getAttribute("totalPriceOfCarport");%>
        
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
            <tbody>
                <tr>
                    <%for (Product list : stykliste) {%>
                    <td><%=list.getId()%></td><td><%=list.getProductName()%></td><td><%=list.getCategory()%></td><td><%=list.getPrice() + " DKK"%></td><td><%=list.getQty()%></td><td><%=list.getPriceLine() + " DKK"%></td><td><%=list.getLength()%></td><td><%=list.getWidth()%></td><td><%=list.getHeight()%></td></tr>
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
