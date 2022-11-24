<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-18
  Time: 오후 3:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.rtl.min.css">
</head>
<body>
<div class="container">
    <form action="/member/login" name="loginParam" method="post" >
        ID: <input type="text" name="userId" class="form-control">
        PW: <input type="text" name="memberPassword" class="form-control">
    </form>
    <input type="button" onclick="loginFn()" value="로그인" class="btn btn-primary">
</div>
</body>
<script>
    const loginFn = () => {
        document.loginParam.submit();
    }
</script>
</html>
