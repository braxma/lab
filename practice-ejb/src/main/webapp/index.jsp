<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>To Do</h3>
    <form action="${pageContext.request.contextPath}/add" method="post">
        <input type="text" name="text" value="">
        <button>Add</button>
    </form>
    <h3>To Do List</h3>
    <ul>
        <c:forEach var='do' items="${ sessionScope.get('toDo') }">
            <li><c:out value="${do}"/></li>
        </c:forEach>
    </ul>
    <div>Requests count: ${sessionScope.get("counter")}</div>
    <div>Session id: ${sessionScope.get("session")}</div>
</body>
</html>
