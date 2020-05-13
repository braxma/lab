<%@ page import="java.util.List" %>
<%@ page import="xyz.Employee" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Add Employee</h3>
<form action="${pageContext.request.contextPath}/add" method="post">
    <input placeholder="First Name" type="text" name="firstName">
    <input placeholder="Last Name" type="text" name="lastName">
    <input placeholder="Sure Name" type="text" name="sureName">
    <input placeholder="Occupation" type="text" name="occupation">
    <input placeholder="Department" type="text" name="department">
    <input placeholder="Salary" type="text" name="salary">
    <input type="submit" value="Add" />
</form>
<h3>Employee list</h3>
<table border="1">
    <tr>
        <th>Id</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Sure Name</th>
        <th>Occupation Name</th>
        <th>Department</th>
        <th>Salary</th>
    </tr>
    <c:catch var="exception">
    <c:forEach var='employee' items="${ requestScope.get('employeeList') }">
    <tr>
        <td><c:out value="${employee.id}"/></td>
        <td><c:out value="${employee.firsName}"/></td>
        <td><c:out value="${employee.lastName}"/></td>
        <td><c:out value="${employee.sureName}"/></td>
        <td><c:out value="${employee.occupation}"/></td>
        <td><c:out value="${employee.department}"/></td>
        <td><c:out value="${employee.salary}"/></td>
    </tr>
    </c:forEach>
    </c:catch>
</table>
<br/>
<div>Session id: ${sessionScope.get("session")}</div>
<c:if test = "${exception ne null}">
    <p>Exception is : ${exception} <br>
        Exception Message: ${exception.message}</p>
</c:if>
</body>
</html>
