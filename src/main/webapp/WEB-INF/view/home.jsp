<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>$Title$</title>
    </head>
    <body>
        <a href="/TestJDBCServlet">Test DB Connection</a><br>
        <a href="/customer/list"> list customers</a><br>
        <a href="/resources/css/add-customer-style.css">add-customer-style.css</a><br>
        <a href="/resources/css/style.css">style.css</a><br>
        <a href="/showMyLoginPage">Custom Login Page Sign-in</a><br>
        <p>Last updated: ${currentTime}</p><br>
        <%--        adding a logout button --%>
        <form:form action = "${pageContext.request.contextPath}/logout" method = "POST">
            <input type="submit" value="Logout"/>
        </form:form>
    </body>
</html>
