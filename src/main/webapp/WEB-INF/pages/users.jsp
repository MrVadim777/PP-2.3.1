<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Список пользователей</title>
</head>
<body>
<h2>Пользователи:</h2>

<h3>Добавить нового пользователя</h3>
<form action="save" method="post">
    <table>
        <tr>
            <td>Email:</td>
            <td>
                <input type="text" name="email" value="${user.email}" />
                <c:if test="${not empty errors and errors.hasFieldErrors('email')}">
                    <div style="color:red">${errors.getFieldError('email').defaultMessage}</div>
                </c:if>
            </td>
        </tr>
        <tr>
            <td>Имя:</td>
            <td>
                <input type="text" name="name" value="${user.name}" />
                <c:if test="${not empty errors and errors.hasFieldErrors('name')}">
                    <div style="color:red">${errors.getFieldError('name').defaultMessage}</div>
                </c:if>
            </td>
        </tr>
        <tr>
            <td>Фамилия:</td>
            <td>
                <input type="text" name="lastName" value="${user.lastName}" />
                <c:if test="${not empty errors and errors.hasFieldErrors('lastName')}">
                    <div style="color:red">${errors.getFieldError('lastName').defaultMessage}</div>
                </c:if>
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Добавить"/></td>
        </tr>
    </table>
</form>
<hr/>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Email</th>
        <th>Имя</th>
        <th>Фамилия</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.email}</td>
            <td>${user.name}</td>
            <td>${user.lastName}</td>

            <td>
                <form action="edit" method="get" style="display:inline;">
                    <input type="hidden" name="id" value="${user.id}" />
                    <button type="submit">Изменить</button>
                </form>
                <form action="delete" method="post" style="display:inline;">
                    <input type="hidden" name="id" value="${user.id}" />
                    <button type="submit">Удалить</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
