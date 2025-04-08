<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Редактировать пользователя</title>
</head>
<body>
<h2>Редактировать пользователя</h2>

<form action="update" method="post">
  <input type="hidden" name="id" value="${user.id}" />
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
      <td><input type="submit" value="Сохранить изменения" /></td>
    </tr>
  </table>
</form>


<a href="/">Назад</a>
</body>
</html>
