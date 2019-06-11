<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/13
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <script type="text/javascript" src="js/jquery-1.7.2.js"></script>

    <script type="text/javascript">

        $(function(){

            $(":text:eq(0)").blur(function(){

                if($(this).val()==""){

                    $(this).next().css("color","red").html("×");
                }else{

                    $(this).next().css("color","green").html("√");
                }
            });
        });
    </script>
</head>
<body>


<form action="reg" method="post" enctype="multipart/form-data">

    账号:<input type="text" name="username"/><span></span><br/>

    密码:<input type="password" name="password"/><span></span><br/>

    头像:<input type="file" name="fileName">

    <input type="submit" value="提交"/>

</form>

</body>
</html>
