<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/17
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>showPage</title>
</head>
<body>
<table >

    <tr>
        <th>id</th>
        <th>name</th>
        <th>account</th>
    </tr>
    <c:forEach items="${pageInfo.pageList}" var="pageinfo">
        <th>${pageinfo.id}</th>
        <th>${pageinfo.name}</th>
        <th>${pageinfo.account}</th>
    </c:forEach>
    <%--onclick="javascript:return false;"   js的行类样式     onclick  return false 就不执行--%>
    <a href="page?pageNumber=1" onclick="javascript:return false;">上一页</a><a href="page?pageNumber=1">下一页</a>
</table>

</body>
</html>
