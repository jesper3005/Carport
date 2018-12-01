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
        <link rel="stylesheet" href="./CSS/selectBoxes.css">
        <link rel="stylesheet" href="./CSS/tableDesign.css">
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

        <%List<Product> allProduct = (List) session.getAttribute("allProduct");%>


        <div class="containerAdmin">
            <div class="control-groupAdmin">
                <div class="selectFormAdmin">
                    <form name="AddProduct" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="AddProduct">
                        <h1>Tilføj et nyt produkt</h1>
                        <h4>Produkt Navn</h4>
                        <input type="text" name="produkt_name">
                        <h4>Produkt Kategori</h4>
                        <input type="text" name="category">
                        <h4>Stykpris</h4>
                        <input id="number" type="number" name="price" step="0.01" required="">
                        <h4>Længde</h4>
                        <input id="number" type="number" name="length" step="0.01" required="">
                        <h4>Bredde</h4>
                        <input id="number" type="number" name="width" step="0.01" required="">
                        <h4>Højde</h4>
                        <input id="number" type="number" name="height" step="0.01" required="">
                        </br>
                        </br>
                        <input type="submit" value="AddProduct">
                    </form>
                </div>
            </div>
        </div>
        <div class="containerAdmin">
            <div class="control-groupAdmin">
                <div class="selectFormAdmin">
                    <h4>Hej</h4>
                    <input id="number" type="number" name="hallo">
                </div>
            </div>    
        </div>
        <div class="containerTable">
            <div class="control-groupTable">
                <div class="search">
                    <div>
                        <input type="text" id="result" name="search" placeholder="Search.."  > 
                        <input type = "submit" name="action" value = "Search" onclick='javascript:window.open("http:/FrontController?command=SearchResult&result=" + document.getElementById("result").value, "_blank", "scrollbars=2,resizable=1,height=600,width=800");'>
                    </div>   
                    <br>
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
                                <% for (Product list : allProduct) {%>
                        <form action="FrontController" method="POST">
                            <input type="hidden" name="command" value="UpdateProduct"/>
                            <input type='hidden' name='id' value='<%=list.getId()%>'/>
                            <td><%=list.getProductName()%></td>
                            <td><%=list.getCategory()%></td>
                            <td><input id="number" type="number" name="price" placeholder="<%=list.getPrice()%> DKK" step="0.01" required=""> <input type = "submit" name="action" value = "Update"> </td>
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
        </div>
    </body>
</html>