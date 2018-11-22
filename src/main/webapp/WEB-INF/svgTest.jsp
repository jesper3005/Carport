<%-- 
    Document   : svgTest
    Created on : 19-11-2018, 08:43:39
    Author     : Jesper
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        
        <%= request.getAttribute("drawing") %>
        
        
        
        <svg width="600" height="600">
        <!--   
        <line x1="40" y1="20" x2="40" y2="500" style="stroke: #292929; stroke-width: 2;"/>
        <line x1="50" y1="20" x2="50" y2="500" style="stroke: #292929; stroke-width: 2;"/>
        -->

        <!--Carportens mål: 420 length, 380 width-->
        <!--2 horizontale remmer -->
        <rect x="40" y="0" height="420" width="5" style="stroke: #292929; fill:none; stroke-width: 1.5;"/>
        <!--Tag x(40) og plus length(380) på x kordinatet-->
        <rect x="420" y="0" height="420" width="5" style="stroke: #292929; fill:none; stroke-width: 1.5;"/>
        
        <!--2 vertikale remmer -->
        <rect x="45" y="0" height="5" width="380" style="stroke: #292929; fill:none; stroke-width: 1.5;"/>
        <!-- Length(420) + 20 = y(20) -->
        <rect x="40" y="420" height="5" width="385" style="stroke: #292929; fill:none; stroke-width: 1.5;"/>
        
        <!--Spær (Træk 20 fra y og du har stedet hvor den første skal ligges-->
        <!--Efter der skal der ligge 60 i mellem -->    
        <rect x="30" y="40" height="5" width="405" style="stroke: #292929; fill:none;"/>
        <rect x="30" y="108" height="5" width="405" style="stroke: #292929; fill:none;"/>
        <rect x="30" y="176" height="5" width="405" style="stroke: #292929; fill:none;"/>
        <rect x="30" y="244" height="5" width="405" style="stroke: #292929; fill:none;"/>
        <rect x="30" y="312" height="5" width="405" style="stroke: #292929; fill:none;"/>
        <rect x="30" y="380" height="5" width="405" style="stroke: #292929; fill:none;"/>
        
        <!-- Stolper -->
        
        <rect x="45" y="410" height="10" width="10" style="stroke: #292929; fill:1;"/>
        <rect x="410" y="410" height="10" width="10" style="stroke: #292929; fill:1;"/>
        
        <rect x="45" y="5" height="10" width="10" style="stroke: #292929; fill:1;"/>
        <rect x="410" y="5" height="10" width="10" style="stroke: #292929; fill:1;"/>
        </svg>
        
        <svg width="600" height="600">
            <!--Taget-->
            <rect x="30" y="60" height="10" width="420" style="stroke: #292929; fill:none; stroke-width: 2;"/>
            <!--Stolper-->
            <rect x="40" y="60" height="250" width="10" style="stroke: #292929; fill:none;"/>
            <rect x="430" y="60" height="250" width="10" style="stroke: #292929; fill:none;"/>
        </svg>
    </body>
</html>
