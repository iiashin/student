<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/5/18
  Time: 0:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>show books</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
结果为:${results}
<hr/>
<table class="table table-striped table-hovered">
    <tr>
        <th>学生id</th>
        <th>学生姓名</th>
        <th>资金</th>
        <th>性别</th>
        <th>年龄</th>
    </tr>
    <c:forEach items="${students}" var="student">
        <tr>
            <td>${student.id}</td>
            <td>${student.t_name}</td>
            <td>${student.balance}</td>
            <td>${student.gender}</td>
            <td>${student.age}</td>
        </tr>
    </c:forEach>


</table>
</body>
</html>