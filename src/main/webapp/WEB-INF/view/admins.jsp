<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Ranjith
  Date: 2/18/2019
  Time: 2:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Admin welcome page</title>
    </head>
    <body>
        <p>Hello <security:authentication property="principal.username"/>, today's meeting is about possible design
            flaws in Mongo-DB. Come prepared please, <security:authentication property="principal.username"/></p>
    </body>
</html>
