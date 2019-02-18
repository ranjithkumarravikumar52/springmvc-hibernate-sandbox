<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Home Page</title>
    </head>
    <body>
        <a href="/TestJDBCServlet">Test DB Connection</a><br>
        <a href="/customer/list"> list customers</a><br>
        <a href="/showMyLoginPage">Custom Login Page Sign-in</a><br>
        <p>Last updated: ${currentTime}</p><br>

        <%--displaying user id and their roles--%>
        <p>
            User: <security:authentication property="principal.username"/>
            Role(s): <security:authentication property="principal.authorities"/>
        </p>
        <%--restricting content based on role--%>
        <security:authorize access="hasRole('MANAGER')">
            <br>
            <%--add a link to point to /leaders...this is for the managers--%>
            <p>
                <a href="${pageContext.request.contextPath}/leaders">Leadership meeting</a>(Only for managers folks)
            </p>
            <br>
        </security:authorize>
        <security:authorize access="hasRole('ADMIN')">
            <%--add a link to point to /systems...this is for the managers--%>
            <p>
                <a href="${pageContext.request.contextPath}/systems">Admins meeting</a>(About Mongo-DB design)
            </p>
            <br>
        </security:authorize>
        <%-- adding a logout button --%>
        <form:form action="${pageContext.request.contextPath}/logout" method="POST">
            <input type="submit" value="Logout"/>
        </form:form>
    </body>
</html>
