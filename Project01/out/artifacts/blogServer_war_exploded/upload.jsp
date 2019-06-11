<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/2
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
      <form action="upload.s" method="post" enctype="multipart/form-data">
          选择文件 <input type="file" name="filename">
          <input type="submit" name="上传">

      </form>
</body>
</html>
