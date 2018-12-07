<%-- 
    Document   : manageOrders
    Created on : 07-12-2018, 00:02:50
    Author     : Jesper
--%>

<%@page import="functionLayer.Carport"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./CSS/headerCSS.css">
        <link rel="stylesheet" href="./CSS/selectBoxes.css">
        <link rel="stylesheet" href="./CSS/tableDesign.css">

        <title>JSP Page</title>
    </head>
    <body>
        <%List<Carport> allOrders = (List) session.getAttribute("allOrders"); %>
        <!-- -----------------HEADER---------------------------------- -->
        <header>
            <img id="fog" src="./IMAGES/FogLogo.png" alt="logo">
            <a class="active" href="/FrontController?command=toNavigator&site=registration">Sign up</a>
            <a class="active" href="/FrontController?command=toNavigator&site=login">Login</a>
            <a class="active" href="/index.jsp">Home</a>
            <a class="active" href="/FrontController?command=Admin">Admin</a>
            <a class="active" href="/FrontController?command=manageOrders"></a>
            <!-- <input type='submit' value="Log Out">-->
        </header>

        <!-- -----------------Display orders------------------------------------>
        <form action="FrontController" method="POST">
            <input type="hidden" name="command" value="manageOrders">
            <div class="container">
                <div class="control-group">
                    <select name="selectOrder">
                        <option value="allOrdre">Alle Ordre</option>
                        <option value="pending">Pending Odre</option>
                        <option value="approved">Godkente Odre</option>
                        <option value="paid">Betalte Odre</option>
                        <option value="cancelled">Anulleret Ordre</option>
                    </select>
                    <button type="submit" name="seOrdre"> Se Ordre</button>
                </div>
            </div>
        </form>
        <table class="table-fill">
            <thead>
                <tr>
                    <th>Ordre Id</th>
                    <th>Date</th>
                    <th>Længde af Carporten</th>
                    <th>Bredde af Carporten</th>
                    <th>Grader</th>
                    <th>Tag Type</th>
                    <th>Tag Materiale</th>
                    <th>Total Price</th>
                    <th>Staus af Ordre</th>
                    <th>Længden af Skur</th>
                    <th>Bredden af Skur</th>
                    <th>Kunden Id</th>
                </tr>
            </thead>
            <tbody class="table-hover">
                <tr>
                    <% for (Carport list : allOrders) {%>
                    <th><%=list.getId()%></th>
                    <td><%=list.getDate()%></td>
                    <td><%=list.getCarport_length()%></td>
                    <td><%=list.getCarport_width()%></td>
                    <td><%=list.getDegrees()%></td>
                    <td><%=list.getRoof()%></td>
                    <td><%=list.getRoofMaterial()%></td>
                    <td><%=list.getTotal_price()%></td>
                    <td><%=list.getStatus_of_order()%></td>
                    <td><%=list.getShed().getShed_length()%></td>
                    <td><%=list.getShed().getShed_width()%></td>
                    <td><%=list.getCustomer_id()%></td>
                    </form>
                </tr>
                <%}%>
            </tbody>
        </tr>
    </table>


</body>
</html>
