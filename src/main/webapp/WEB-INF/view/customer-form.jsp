<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

    <head>
        <title>Save Customer</title>
        <!-- reference our style sheet -->
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/lib/css/style.css"/>
        <!-- reference our style sheet for save customer form -->
        <link type="text/css" rel="stylesheet"
              href="${pageContext.request.contextPath}/lib/css/add-customer-style.css"/>
    </head>

    <body>

        <div id="wrapper">
            <div id="header">
                <h2>CRM - Customer Relationship Manager</h2>
            </div>
        </div>

        <div id="container">
            <h3>Save customer</h3>
            <form:form action="saveCustomer" modelAttribute="customer" method="POST">
                <%-- need to associate this data with customer id--%>
                <form:hidden path="id"/>
                <table>
                    <tbody>
                            <%-- spring form load: call getters--%>
                            <%-- form submit: call set--%>
                        <tr>
                            <td><label>First Name: </label></td>
                            <td><form:input path="firstName"/></td>
                        </tr>
                        <tr>
                            <td><label>Last Name: </label></td>
                            <td><form:input path="lastName"/></td>
                        </tr>
                        <tr>
                            <td><label>Email: </label></td>
                            <td><form:input path="email"/></td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="Save" class="save"/></td>
                        </tr>
                    </tbody>
                </table>
            </form:form>

            <p>
                <a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
            </p>


        </div>
    </body>

</html>









