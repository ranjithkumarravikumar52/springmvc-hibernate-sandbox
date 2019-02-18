<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>Leaders' Home Page</title>
    </head>
    <body>
        <h2>Hello <security:authentication property="principal.username"/>, hope you're managing well</h2><br>
        <p>See you in brazil, <security:authentication property="principal.username"/></p><br>
        <hr>
        <a href="${pageContext.request.contextPath}/">Back Home page</a>
    </body>
</html>
