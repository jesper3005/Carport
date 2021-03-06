<%-- 
    Document   : admin
    Created on : 21-Nov-2018, 18:17:47
    Author     : oerte
--%>

<%@page import="functionLayer.User"%>
<%@page import="java.util.List"%>
<%@page import="functionLayer.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Admin</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="./IMAGES/FogLogo.png"/>
        <link rel="stylesheet" href="./CSS/headerCSS.css">
        <link rel="stylesheet" href="./CSS/orderRequest.css">
        <link rel="stylesheet" href="./CSS/selectBoxes.css">
        <link rel="stylesheet" href="./CSS/tableDesign.css">
        <link rel="icon" href=""
    </head>
    
    <body>
    <!-- ------------------SECTION 1.0 HEADER---------------------------------->
        <% User user = (User) session.getAttribute("user"); %>
        
        <%if(user == null) { %>
        <header>
            <img id="fog" src="./IMAGES/FogLogo.png" alt="logo">
            <a class="active" href="/FrontController?command=toNavigator&site=registration">Sign up</a>
            <a class="active" href="/FrontController?command=toNavigator&site=login">Login</a>
            <a class="active" href="/FrontController?command=toNavigator&site=home">Home</a>
        </header>
        
        <%} else if(user.getRole().equals("admin")) {%> 
            <header>
                <img id="fog" src="./IMAGES/FogLogo.png" alt="logo">
                <a class="active" href="/FrontController?command=toNavigator&site=logout">Sign out</a>
                <a class="active" href="/FrontController?command=Admin">Admin</a>
                <a class="active" href="/FrontController?command=manageOrders">Se Ordre</a>
                <a class="active" href="/FrontController?command=toNavigator&site=home">Home</a>
                <!-- <input type='submit' value="Log Out">-->
            </header>
        <%} else if(user.getRole().equals("customer")) { %>
            <header>
                <img id="fog" src="./IMAGES/FogLogo.png" alt="logo">
                <a class="active" href="/FrontController?command=toNavigator&site=logout">Sign out</a>
                <a class="active" href="">Profile</a>
                <a class="active" href="/FrontController?command=toNavigator&site=home">Home</a>
                <!-- <input type='submit' value="Log Out">-->
            </header>
        <%}%>
    
    <!-- ------------------SECTION 2.0 ADD PRODUCT---------------------------------->

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
    </div>
        
    <div class="containerAdmin">
        <div class="control-groupAdmin">
            <div class="selectFormAdmin">
                <h4>Hej</h4>
                <input id="number" type="number" name="hallo">
            </div>
        </div>    
    </div>
        
    <!-- ------------------SECTION 3.0 SEARCH FOR PRODUCT-------------------------------->
        
    <div class="containerTable">
        <div class="control-groupTable">
            <div class="search">
                <div>
                    <form action="FrontController" method="POST">
                        <input type="hidden" name="command" value="Admin"/>
                        <input type="text" name="search" placeholder="Search.." > 
                        <input type = "submit" name="action" value = "Search" >
                    </form>
                </div>
    
    <!-- ------------------SECTION 3.1 FULL PRODUCT LIST---------------------------------->            
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