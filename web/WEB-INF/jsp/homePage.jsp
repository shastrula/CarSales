<%-- 
    Document   : homePage
    Created on : Mar 7, 2010, 12:01:48 AM
    Author     : shastrula
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../jspf/include.jsp" %>

<html>
    <head>
        <title>Customer Home Page</title>
    </head>
    <body>
        <h1>Welcome to Cars.com Portal</h1>
        <form action="homePage.htm">
        <table align="left" border="1">
            <thead>
                <tr>
                    <td>&nbsp;</td>
                    <td>Make</td>
                    <td>Model</td>
                    <td>Type</td>
                </tr>
            </thead>
            <c:forEach items="${availableCarModels}" var="model" varStatus="row">
            <tr>
                <td><input type="checkbox" name="model${row.count}"></td>
                <td><c:out value="${model.make}"></c:out></td>
                <td><c:out value="${model.model}"></c:out></td>
                <td><c:out value="${model.type}"></c:out></td>
            </tr>
        </c:forEach>
            <tr><td colspan="4"><input type="submit" value="Search"></td></tr>
        </table>
        </form>


    </body>
</html>
