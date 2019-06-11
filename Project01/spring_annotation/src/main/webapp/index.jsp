<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/index.js"></script>
</head>
<body>

    <a href="tt.jsp">跳转ttt</a>

    <form onsubmit="return false;" >

        <textarea name = "message" style="width: 400px; height: 100px"></textarea>

        <input type="button" value="发送数据" onclick="send(this.form.message.value)">

        <h3>服务端输出</h3>

        <textarea id="responseText" style="width: 400px ;height: 100px;"></textarea>

        <input type="button" onclick="javascript:document.getElementById('responseText').value='' " value="清空内容">
    </form>

</body>
</html>