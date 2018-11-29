<%-- 
    Document   : searchResult
    Created on : 27-Nov-2018, 21:55:39
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
        <link rel="stylesheet" href="./CSS/selectBoxes.css">
        <link rel="stylesheet" href="./CSS/tableDesign.css">
        <link rel="icon" href=""
    </head>
    <header>
        <img id="fog" src="./IMAGES/FogLogo.png" alt="logo">
        <a href="#SignUp">Sign up</a>
        <a href="#Login">Login</a> 
        <a class="active" href="/index.jsp">Home</a>
        <a class="active" href=http:/FrontController?command=Admin>Admin</a>
    </header>
    <body>
        <% List<Product> searchList = (List) session.getAttribute("searchList"); %>
        <div class="containerTable">
            <div class="control-groupTable">
                <div class="search">
                    <div>
                        <input type="text" id="result" name="search" placeholder="Search.." required="" > 
                        <input type = "submit" name="action" value = "Search" onclick='javascript:window.open("http:/FrontController?command=SearchResult&result=" + document.getElementById("result").value, "_blank", "scrollbars=2,resizable=1,height=600,width=800");'>
                    </div>     
                </div>
                <td>
                </td>
                <table class="table-fill">
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
                    <tbody class="table-hover">
                        <tr>
                            <% for (Product list : searchList) {%>
                    <form action="FrontController" method="POST">
                        <input type="hidden" name="command" value="UpdateProduct"/>
                        <input type='hidden' name='id' value='<%=list.getId()%>'/>
                        <td><%=list.getProductName()%></td>
                        <td><%=list.getCategory()%></td>
                        <td><input id="number" type="number" name="price" placeholder="<%=list.getPrice()%> DKK" step="0.01" required> <input type = "submit" name="action" value = "Update"> </td>
                        <td><%=list.getLength()%></td>
                        <td><%=list.getWidth()%></td>
                        <td><%=list.getHeight()%></td>
                    </form>
                    <td><%out.println("<a href=\"http://localhost:8084//FrontController?command=UpdateProduct&product_id=" + list.getId() + "\")>");%>Slet</td>
                    </tr>
                    <%}%>
                    </tbody>
                    </tr>
                </table>
            </div>
        </div>
    </body>
</html>
