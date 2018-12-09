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
        
        <% for (Carport list : allOrders) {%>
        <div class="container">
            <div class="control-group">
                <% if(list.getRoof().equals("FLAT")) { %>
                <h4>CARPORT MED FLADT TAG | Odre ID: <%=list.getId()%> | Oprettet: <%=list.getDate()%></h4>
                <% } else { %>
                <h4>Carport med spidst tag | Odre ID: <%=list.getId()%> | Oprettet: <%=list.getDate()%></h4>
                <%}%>
                <h4>Carport beskrivelse:</h4>
                <text>Længde: <%=list.getCarport_length()%>cm</text>
                <br>
                <br>
                <text>Bredde: <%=list.getCarport_width()%>cm</text>
                <br>
                <br>
                <text>Bredde: <%=list.getDegrees() %></text>
                <br>
                <br>
                <text>Tag materiale: <%=list.getRoofMaterial()%></text>
                <br>
                <br>
                <text>Total pris ex moms: <%=list.getTotal_price()%></text>
                <br>
                <br>
                <text>Status på odre: <%=list.getStatus_of_order()%></text>
                <br>
                <br>
                <text>Skurs længde: <%=list.getShed().getShed_length()%></text>
                <br>
                <br>
                <text>Skurs bredde: <%=list.getShed().getShed_width()%></text>
                <br>
                <br>
                <text>Kunde id: <%=list.getCustomer_id()%></text>
                <br>
                <br>
                
                
                <button class="collapsible" type="submit">Se styklisten</button>
                <div class="content">
                    <table class="">
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
                            
                        </tbody>
                    </table>
                </div>
                
                
                
                
                
                <div class="control-groupManageOrders">
                    <h4>Ændre status på odren</h4>
                    <br>
                    <input type="checkbox" name="approved" value="approved"> Godkendt
                    <br>
                    <br>
                    <input type="checkbox" name="approved" value="approved"> Betalt
                    <br>
                    <br>
                    <input type="checkbox" name="approved" value="approved"> Annuler
                    <br>
                    <br>
                    <button type="submit" name="updateStatus">Opdater order status</button>
                </div>
            </div>
                
        </div>
        <%}%>
        
   
            
    <script>
        var coll = document.getElementsByClassName("collapsible");
        var i;

        for (i = 0; i < coll.length; i++) {
          coll[i].addEventListener("click", function() {
            this.classList.toggle("active");
            var content = this.nextElementSibling;
            if (content.style.display === "block") {
              content.style.display = "none";
            } else {
              content.style.display = "block";
            }
          });
        }
    </script>           

</body>
</html>