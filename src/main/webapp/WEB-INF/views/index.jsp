<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-17
  Time: 오전 9:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.rtl.min.css">
    <script src="/resources/js/jquery.js"></script>
<%--    <style>--%>
<%--        *{--%>
<%--            margin: 0;--%>
<%--            padding:0;--%>
<%--        }--%>
<%--        /* 화면 전체 렙 */--%>
<%--        .wrapper{--%>
<%--            width: 1900px;--%>
<%--        }--%>
<%--        /* content 랩 */--%>
<%--        .wrap{--%>
<%--            width : 1080px;--%>
<%--            margin: auto;--%>
<%--        }--%>
<%--        /* 홈페이지 기능 네비 */--%>
<%--        .top_gnb_area{--%>
<%--            width: 100%;--%>
<%--            height: 50px;--%>
<%--            background-color: #a2a2ea;--%>
<%--        }--%>
<%--        /* 로고, 검색, 로그인 */--%>
<%--        .top_area{--%>
<%--            width: 100%;--%>
<%--            height: 150px;--%>
<%--            /* background-color: #f7f0b9; */--%>
<%--        }--%>
<%--        /* 로고 영역 */--%>
<%--        .logo_area{--%>
<%--            width: 25%;--%>
<%--            height: 100%;--%>
<%--            background-color: red;--%>
<%--            float:left;--%>
<%--        }--%>
<%--        /* 검색 박스 영역 */--%>
<%--        .search_area{--%>
<%--            width: 50%;--%>
<%--            height: 100%;--%>
<%--            background-color: yellow;--%>
<%--            float:left;--%>
<%--        }--%>
<%--        /* 로그인 버튼 영역 */--%>
<%--        .login_area{--%>
<%--            width: 25%;--%>
<%--            height: 100%;--%>
<%--            display: inline-block;--%>
<%--            text-align: center;--%>
<%--        }--%>
<%--        .login_button{--%>
<%--            height: 50%;--%>
<%--            background-color: #D4DFE6;--%>
<%--            margin-top: 30px;--%>
<%--            line-height: 77px;--%>
<%--            font-size: 40px;--%>
<%--            font-weight: 900;--%>
<%--            border-radius: 10px;--%>
<%--            cursor: pointer;--%>
<%--        }--%>
<%--        .login_area>span{--%>
<%--            margin-top: 10px;--%>
<%--            font-weight: 900;--%>
<%--            display: inline-block;--%>
<%--        }--%>
<%--        .login_button{--%>
<%--            height : 50%;--%>
<%--            background-color: #D4DFE6;--%>
<%--            margin-top:30px;--%>
<%--        }--%>

<%--        /* 제품 목록 네비 */--%>
<%--        .navi_bar_area{--%>
<%--            width: 100%;--%>
<%--            height: 70px;--%>
<%--            background-color: #7696fd;--%>
<%--        }--%>

<%--        /* 홈페이지 메인 제품 목록  */--%>
<%--        .content_area{--%>
<%--            width: 100%;--%>
<%--            background-color: #97ef97;--%>
<%--            height: 1000px;--%>
<%--        }--%>

<%--        /* float 속성 해제 */--%>
<%--        .clearfix{--%>
<%--            clear: both;--%>
<%--        }--%>

<%--    </style>--%>
</head>
<body>
<%--<div class="wrapper">--%>
<%--    <div class="wrap">--%>
<%--        <div class="top_gnb_area">--%>
<%--            <h1>gnb area</h1>--%>
<%--        </div>--%>
<%--        <div class="top_area">--%>
<%--            <div class="logo_area">--%>
<%--                <h1>logo area</h1>--%>
<%--            </div>--%>
<%--            <div class="search_area">--%>
<%--                <h1>Search area</h1>--%>
<%--            </div>--%>
<%--            <div class="login_area">--%>
<%--                <div class="login_button"><a href="/member/login">로그인</a></div>--%>
<%--                <span><a href="/member/save">회원가입</a></span>--%>
<%--            </div>--%>
<%--            <div class="clearfix"></div>--%>
<%--        </div>--%>
<%--        <div class="navi_bar_area">--%>
<%--            <h1>navi area</h1>--%>
<%--        </div>--%>
<%--        <div class="content_area">--%>
<%--            <h1>content area</h1>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    --%>
<div class="container">
    <button class="btn btn-primary" onclick="indexSave()">회원가입</button>
    <button class="btn btn-primary" onclick="indexLogin()">로그인</button>
<%--    <button class="btn btn-primary" onclick="indexLogout()">로그아웃</button>--%>
    <button class="btn btn-primary" onclick="indexProductList()">상품목록</button>
</div>
</body>
<script>
    const indexSave = () => {
        location.href ="/member/save"
    }

    const indexLogin = () => {
        location.href ="/member/login"
    }

    const indexProductList = () => {
        location.href ="/product/productList"
    }
</script>
</html>
