<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-22
  Time: 오전 9:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>productSave</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.rtl.min.css">
</head>
<body>
<div class="container">
    <form action="/product/productSave" name="saveForm" enctype="multipart/form-data" method="post">
        <input type="hidden" name="saveMemberId" value="${sessionScope.loginDate.id}">
        상품명: <input type="text" name="productName" class="form-control">
        분류: <select name="saveCategoryId" class="form-select">
                <option>선택</option>
                <c:forEach items="${categoryList}" var="category">
                    <option value="${category.id}">${category.categoryName}</option>
                </c:forEach>
            </select>

        가격: <input type="text" name="productPrice" class="form-control">
        재고: <input type="text" name="productStock" class="form-control">
        판매여부: <select name="productSale" class="form-select">
                    <option value="Y">판매중</option>
                    <option value="N">판매중지</option>
                </select>
        내용: <input type="text" name="productContents" class="form-control">
        미리보기(썸네일): <input type="file" name="profile" class="form-control">
        상세이미지: <input type="file" name="file" class="form-control">
        <input type="button" value="상품등록" onclick="productSave()" class="btn btn-primary">
    </form>

</div>
</body>
<script>

    const productSave = () => {
        document.saveForm.submit();
    }
</script>
</html>
