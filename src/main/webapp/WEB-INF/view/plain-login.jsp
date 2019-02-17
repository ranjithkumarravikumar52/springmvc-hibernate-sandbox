<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ranjith
  Date: 2/16/2019
  Time: 11:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Custom Login Page</title>
    </head>
    <body>
        <h3>Custom login form, login with your username and password</h3>
        <%-- we send it authenticateTheUser which spring gives us for performing authenitcation logic--%>
        <%-- use spring MVC form tag to provide some embedded security--%>
        <%--request type should be POST --%>
        <form:form action="${pageContext.request.contextPath}/authenticateTheUser" method = "POST">
            <c:if test="${param.error != null}">
                <i>Sorry! You entered invalid credentials</i>
            </c:if><br>
            User <input type="text" name = "username"><br>
            Password <input type="password" name = "password"><br>
            <input type="submit" value = "Login" /><br>
        </form:form>
    </body>
</html>
