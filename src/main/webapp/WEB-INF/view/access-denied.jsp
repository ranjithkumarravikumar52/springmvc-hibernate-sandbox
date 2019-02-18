<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Ranjith
  Date: 2/18/2019
  Time: 2:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Access Denied</title>
    </head>
    <body>
        <p>Hello <security:authentication property="principal.username"/>, you don't have access to the page you
            requested. Contact system admin please.</p>
        <br>
        <a href="${pageContext.request.contextPath}/">Home</a>
    </body>
</html>
