<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-21
  Time: 오후 4:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>productList</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.rtl.min.css">
</head>
<body>
<div class="container">
    <table class="table table-striped table-hover text-center">
        <tr>
            <th>번호</th>
            <th>작성자</th>
            <th>카테고리</th>
            <th>상품명</th>
            <th>가격</th>
            <th>재고</th>
            <th>판매여부</th>
            <th>작성일</th>
        </tr>

        <c:forEach items="${productList}" var="product">
            <tr>
                <td>${product.id}</td>
                <td>${product.member.userId}</td>
                <td>${product.category.categoryName}</td>
                <td>
                    <a href="/product/findById?id=${product.id}">${product.productName}</a>
                </td>
                <td>${product.productPrice}</td>
                <td>${product.productStock}</td>
                <td>${product.productSale}</td>
                <td>
                    <fmt:formatDate value="${product.productCreate}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="/product/productSaveForm" class="btn btn-primary">상품등록</a>

</div>
</body>
</html>
