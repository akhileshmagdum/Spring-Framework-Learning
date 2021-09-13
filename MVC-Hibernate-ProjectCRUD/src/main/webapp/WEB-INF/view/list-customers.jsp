<%--
  Created by IntelliJ IDEA.
  User: Captain
  Date: 12-09-2021
  Time: 02:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Customers List</title>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>CRM - Customers List</h2>
    </div>
</div>
<div id="container">
    <div id="content">

        <!--Add Customer Button-->
        <input type="button" value="Add Customer"
        onclick="window.location.href='showFormForAdd'; return false;"/>

        <!--  add a search box -->
        <form:form action="search" method="GET">
            Search customer: <input type="text" name="searchName" />
            <input type="submit" value="Search" class="add-button" />
        </form:form>

        <!--Adding HTML Table-->
        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>email</th>
                <th>actions</th>
            </tr>
            <!--Looping over customers-->
            <c:forEach var ="tempCustomer" items="${customers}">

                <!--Update link for customers-->
                <c:url var="updatelink" value="/customer/showFormForUpdate">
                    <c:param name="customerId" value="${tempCustomer.id}"/>
                </c:url>

                <!--Delete link for customers-->
                <c:url var="deletelink" value="/customer/delete">
                    <c:param name="customerId" value="${tempCustomer.id}"/>
                </c:url>
                <tr>
                    <td>${tempCustomer.firstName}</td>
                    <td>${tempCustomer.lastName}</td>
                    <td>${tempCustomer.email}</td>

                    <td>
                        <a href="${updatelink}">Update</a>
                        | <a href="${deletelink}"
                    onclick="if (!(confirm('Do you want to delete?'))) return false">Delete</a>
                        <!--Javascript code for deletion prompt//copied-->
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
