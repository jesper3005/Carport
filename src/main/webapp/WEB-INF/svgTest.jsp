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
        
        
        <%= request.getAttribute("drawingTop") %>
        <%= request.getAttribute("drawingSide") %>
 
        <svg width="600" height="600">
            <!--Taget-->
            <rect x="30" y="60" height="10" width="420" style="stroke: #292929; fill:none; stroke-width: 2;"/>
            <!--Stolper-->
            <rect x="40" y="60" height="250" width="10" style="stroke: #292929; fill:none;"/>
            <rect x="430" y="60" height="250" width="10" style="stroke: #292929; fill:none;"/>
        </svg>
    </body>
</html>
