<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Hello World</h2>
<c:forEach items="${users}" var="user">
    <c:out value="${user.name}"/>
</c:forEach>