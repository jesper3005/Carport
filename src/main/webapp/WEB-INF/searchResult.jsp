<%@page import="functionLayer.User"%>
<%@page import="java.util.List"%>
<%@page import="functionLayer.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="./IMAGES/FogLogo.png"/>
        <link rel="stylesheet" href="./CSS/headerCSS.css">
        <link rel="stylesheet" href="./CSS/orderRequest.css">
        <link rel="stylesheet" href="./CSS/selectBoxes.css">
        <link rel="stylesheet" href="./CSS/tableDesign.css">
        <link rel="icon" href=""
        <title>Admin</title>
    </head>

    <body>
        
        
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
            </header>
        <%} else if(user.getRole().equals("customer")) { %>
            <header>
                <img id="fog" src="./IMAGES/FogLogo.png" alt="logo">
                <a class="active" href="/FrontController?command=toNavigator&site=logout">Sign out</a>
                <a class="active" href="">Profile</a>
                <a class="active" href="/FrontController?command=toNavigator&site=home">Home</a>
            </header>
        <%}%>
        
        
        <%List<Product> allProduct = (List) session.getAttribute("searchList");%>
        <div class="containerTable">
            <div class="control-groupTable">
                <div class="search">
                    <div>
                        <input type="text" id="result" name="search" placeholder="Search.." required="" > 
                        <input type = "submit" name="action" value = "Search" onclick='javascript:window.open("http:/FrontController?command=SearchResult&result=" + document.getElementById("result").value, "_blank", "scrollbars=1,resizable=1,height=600,width=1600");'>
                    </div>     
                </div>
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