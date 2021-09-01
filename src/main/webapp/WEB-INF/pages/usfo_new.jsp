
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
      <td>Select roles: </td>
      <td>

        <th:block th:each="role: ${listRoles}">
          <input type="checkbox" th:field="*{roles}" name="Role:" th:value="${role.id}" class="m-2"/>
          <label th:text="${role.role}" ></label>
        </th:block>
      </td>
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