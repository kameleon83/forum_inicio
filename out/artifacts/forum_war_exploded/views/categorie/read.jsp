<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lecture catégories</title>
</head>
<body>
<h1>Liste des Catégories</h1>
<ul>
    <c:forEach items="${requestScope.categories}" var="p">
        <li><c:out value="${p.nom}"/></li>
    </c:forEach>
</ul>

</body>
</html>
