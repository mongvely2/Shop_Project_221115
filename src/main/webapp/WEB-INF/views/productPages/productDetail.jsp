<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-25
  Time: 오전 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>productDetail</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.rtl.min.css">
    <script src="/resources/js/jquery.js"></script>
</head>
<body>
<div class="container">
    <table class="table table-hover">
        <tr>
            <th>번호</th>
            <td>${product.id}</td>
        </tr>
        <tr>
            <th>썸네일(미리보기)</th>
            <td>
                <img src="${pageContext.request.contextPath}/uploadProfile/${productProfile.storedFileName}"
                     alt="" width="200" height="200">
            </td>
        </tr>
        <tr>
            <th>조회수</th>
            <td>${product.productHits}</td>
        </tr>
        <tr>
            <th>작성자</th>
            <td>${product.member.userId}</td>
        </tr>
        <tr>
            <th>카테고리</th>
            <td>${product.category.categoryName}</td>
        </tr>
        <tr>
            <th>상품명</th>
            <td>${product.productName}</td>
        </tr>
        <tr>
            <th>가격</th>
            <td>${product.productPrice}</td>
        </tr>
        <tr>
            <th>재고</th>
            <td>${product.productStock}</td>
        </tr>
        <tr>
            <th>판매여부</th>
            <td>${product.productSale}</td>
        </tr>
        <tr>
            <th>작성일</th>
            <td>${product.productCreate}</td>
        </tr>
        <tr>
            <th>상세페이지</th>
            <td>
                <img src="${pageContext.request.contextPath}/uploadFile/${productFile.storedFileName}"
                     alt="" width="200" height="200">

            </td>
        </tr>
        <tr>
            <th>상세설명</th>
            <td>${product.productContents}</td>
        </tr>
    </table>
</div>
</body>
</html>
