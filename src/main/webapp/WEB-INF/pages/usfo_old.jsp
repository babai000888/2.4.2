<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">

<html>
<head>
  <title>Spring MVC - Employee</title>
</head>
<body>


<h1>Fill in user data</h1>
<form action="#" th:action="@{${action}}" th:object="${newUser}" method="post" >
  <table>
    <tbody>
    <tr>
      <td>ID:</td>
      <td>
        <input type="hidden" placeholder="*{id}" th:field="*{id}" />
      </td>
    </tr>
    <tr>
      <td>NAME(login):</td>
      <td>
        <input type="text" th:field="*{name}" />
      </td>
    </tr>
    <tr>
      <td>password:</td>
      <td>
        <input type="text" th:field="*{password}" />
      </td>
    </tr>
    <tr>
      <td>LAST NAME</td>
      <td>
        <input type="text" th:field="*{lastName}" />
      </td>
    </tr>
    <tr>
      <td>AGE</td>
      <td>
        <input type="text" th:field="*{age}" />
      </td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="Submit" /> <input type="reset" value="Reset" />
      </td>
    </tr>

    <tr>
      <th:block th:each="role: ${listRoles}">
        <input type="checkbox" th:field="*{roles}" th:text="${role.role}" th:value="${id}"/>
      </th:block>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="Submit" /> <input type="reset" value="Reset" />
      </td>
    </tr>

    </tbody>
  </table>


</form>





</body>
</html>