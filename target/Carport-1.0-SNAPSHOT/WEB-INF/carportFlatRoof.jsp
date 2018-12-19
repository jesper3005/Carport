<%-- 
    Document   : carportSpidsTag
    Created on : 13-11-2018, 10:55:35
    Author     : Jesper
--%>

<%@page import="functionLayer.User"%>
<%@page import="java.util.List"%>
<%@page import="functionLayer.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Fladt Tag</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="./IMAGES/FogLogo.png"/>
        <link rel="stylesheet" href="./CSS/headerCSS.css">
        <link rel="stylesheet" href="./CSS/selectBoxes.css">
        <link rel="icon" href=""
    </head>

    <body>

        <% List<Product> orderByLengthRemList = (List<Product>) session.getAttribute("orderByLengthRemList");%>
        <% User user = (User) session.getAttribute("user"); %>

        <!-- ------------------SECTION 1.0 HEADER---------------------------------->

        <%if (user == null) { %>
        <header>
            <img id="fog" src="./IMAGES/FogLogo.png" alt="logo">
            <a class="active" href="/FrontController?command=toNavigator&site=registration">Sign up</a>
            <a class="active" href="/FrontController?command=toNavigator&site=login">Login</a>
            <a class="active" href="/FrontController?command=toNavigator&site=home">Home</a>
        </header>

        <%} else if (user.getRole().equals("admin")) {%> 
        <header>
            <img id="fog" src="./IMAGES/FogLogo.png" alt="logo">
            <a class="active" href="/FrontController?command=toNavigator&site=logout">Sign out</a>
            <a class="active" href="/FrontController?command=Admin">Admin</a>
            <a class="active" href="/FrontController?command=manageOrders">Se Ordre</a>
            <a class="active" href="/FrontController?command=toNavigator&site=home">Home</a>
        </header>
        <%} else if (user.getRole().equals("customer")) { %>
        <header>
            <img id="fog" src="./IMAGES/FogLogo.png" alt="logo">
            <a class="active" href="/FrontController?command=toNavigator&site=logout">Sign out</a>
            <a class="active" href="">Profile</a>
            <a class="active" href="/FrontController?command=toNavigator&site=home">Home</a>
        </header>
        <%}%>

        <!-- ------------------SECTION 2.0 WELCOME/INFO TEXT---------------------------------->

        <% String error = (String) request.getAttribute("error");%>
        <% if (error != null) {%>
        <script>alert("<%=error%>")</script>
        <%} else {%>
        <div class="container">
            <div class="control-groupText">
                <h1 class="title">Velkommen til Quick-byg carport med fladt tag !</h1>
                <text>Med et specialudviklet computerprogram kan vi lynhurtigt beregne prisen og udskrive en skitsetegning på en carport  </text>
                <br>
                <text>indenfor vores standardprogram, der tilpasses dine specifikke ønsker.</text>
                <br>
                <br>
                Tilbud og skitsetegning kan ses på næste side når målene er udfyldt
                <br>
                <br>
                Ved bestilling medfølger standardbyggevejledning.
            </div>
        </div>
        <%}%>
        <form name="FlatRoof" action="FrontController" method="POST">
            <input type="hidden" name="command" value="orderRequestFlat">
            <div class="container">
                <div class="control-group">
                    <h1>Vælg dine mål</h1>
                    <div class="select">
                        <h4>Carport bredde:</h4>
                        <select name="bredde">
                            <% for (Product listOfRem : orderByLengthRemList) {%>
                            <%if (listOfRem.getCategory().equals("rem")) {%>
                            out.print(<option value="<%=listOfRem.getLength()%>"><%=listOfRem.getLength()%> cm</option>);
                            <%}
                                }%>
                        </select>
                        <div class="select__arrow"></div>
                    </div>
                    <br>
                    <div class="select">
                        <h4>Carport længde:</h4>
                        <select name="laengde">
                            <% for (Product listOfRem : orderByLengthRemList) {%>
                            <%if (listOfRem.getCategory().equals("rem")) {%>
                            out.print(<option value="<%=listOfRem.getLength()%>"><%=listOfRem.getLength()%> cm</option>);
                            <%}
                                }%>
                        </select>
                        <div class="select__arrow"></div>
                    </div>
                </div>
                <br>
                <div class="control-group">
                    <h1>Vælg tag type</h1>
                    <h4>Tag type</h4>
                    <div class="select">
                        <select name="Tag">
                            <option value="Tagpap">Tagpap</option>
                            <option value="Trapeztag PVC Glasklar">Trapeztag PVC Glasklar</option>
                            <option value="Trapeztag Boelgeplade">Trapeztag Boelgeplade</option>
                        </select>
                        <div class="select__arrowTag"></div>
                    </div>
                    <h4>Tag hældning</h4>
                    <div class="select">
                        <select name="Hældning" disabled="disabled">
                            <option>Vælg hældning</option>
                        </select>
                        <div class="select__arrowTag"></div>
                    </div>
                </div>
                <br>
                <div class="control-group">
                    <h1>Vælg mål på skur</h1>
                    <input type = "checkbox" name ="redskabsskur"  /> Jeg ønsker redskabskur
                    <h4>Redskabsrum bredde</h4>
                    <div class="select">
                        <select name="skurbredde">
                            <% for (Product listOfRem : orderByLengthRemList) {%>
                            <%if (listOfRem.getCategory().equals("beklædning")) {%>
                            out.print(<option  value="<%=listOfRem.getLength()%>" ><%=listOfRem.getLength()%> cm</option>);
                            <%}
                                }%>
                        </select>
                        <div class="select__arrowSkur"></div>
                        <br>
                        </select>
                        <div class="select__arrowSkur"></div>
                        <br>
                        <h4>Redskabsrum længde</h4>
                        <select name="skurlaengde">
                            <% for (Product listOfRem : orderByLengthRemList) {%>
                            <%if (listOfRem.getCategory().equals("beklædning")) {%>
                            out.print(<option value="<%=listOfRem.getLength()%>"><%=listOfRem.getLength()%> cm</option>);
                            <%}
                                }%>
                        </select>
                        <div class="select__arrowSkur"></div>
                    </div>
                </div>
                <br>
                <br>
                <div class="control-group">
                    <input type="hidden" name="currentSite" value="carportFlatRoof">
                    <button type="submit" name="request">Byg din carport!</button>
                </div>
        </form>    
    </div>
</div>
</body>
</html>