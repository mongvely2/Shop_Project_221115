<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-17
  Time: 오후 2:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>save</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.rtl.min.css">
    <script src="/resources/js/jquery.js"></script>
</head>
<body>

<div class="container">
<%--    <form action="/member/save" name="saveForm" method="post" enctype="multipart/form-data">--%>
<%--        id: <input type="text" name="memberId" id="memberId" onblur="duplicateCheck()" placeholder="아이디입력" class="form-control">--%>
<%--        <div><span id="duplicateEmail"></span></div>--%>
<%--        pw: <input type="text" name="memberPassword" id="memberPassword" onblur="passCheck()" placeholder="비밀번호입력" class="form-control">--%>
<%--        <div><span id="expPass"></span></div>--%>
<%--        check pw: <input type="text" id="checkPassword" onblur="doublePassCheck()" placeholder="비밀번호재확인입력" class="form-control">--%>
<%--        <div><span id="doublePass"></span></div>--%>
<%--        name: <input type="text" name="memberName" id="memberName" placeholder="이름입력" class="form-control">--%>
<%--        mobile: <input type="text" name="memberMobile" id="memberMobile" onblur="mobileCheck()" placeholder="연락처입력" class="form-control">--%>
<%--        <div><span id="expMobile"></span></div>--%>
<%--        file: <input type="file" name="memberFile" class="form-control">--%>
<%--        <div>--%>
<%--            <input type="button" onclick="memberSave()" value="가입하기" class="btn btn-primary">--%>
<%--        </div>--%>
<%--    </form>--%>
    <form action="/member/save" name="saveForm" method="post" enctype="multipart/form-data">
        id: <input type="text" name="userId" id="userId" onblur="duplicateCheck()" placeholder="아이디입력" class="form-control">
        <div><span id="duplicateEmail"></span></div>
        pw: <input type="text" name="memberPassword" id="memberPassword" onblur="passCheck()" placeholder="비밀번호입력" class="form-control">
        <div><span id="expPass"></span></div>
        check pw: <input type="text" id="checkPassword" onblur="doublePassCheck()" placeholder="비밀번호재확인입력" class="form-control">
        <div><span id="doublePass"></span></div>
        name: <input type="text" name="memberName" id="memberName" placeholder="이름입력" class="form-control">
        mobile: <input type="text" name="memberMobile" id="memberMobile" onblur="mobileCheck()" placeholder="연락처입력" class="form-control">
        <div><span id="expMobile"></span></div>
        fileAttached: <input type="file" name="memberFile" class="form-control">
        <div>
            <input type="button" value="가입하기" onclick="memberSave()" class="btn btn-primary">
        </div>
    </form>
</div>
</body>
<script>

    const memberPassword = document.getElementById("memberPassword").value;
    const checkPassword = document.getElementById("checkPassword").value;
    // const memberName = document.getElementById("memberName").value;
    // const memberMobile = document.getElementById("memberMobile").value;
    const passResult = memberPassword == checkPassword;
    const passExp = /^(?=.*[a-z])(?=.*[\d])[a-z\d]{5,10}$/;
    const mobileExp = /^\d{3}-\d{4}-\d{4}$/;

    const duplicateCheck = () => {
        const duplicateEmail = document.getElementById("duplicateEmail");
        const inputId = document.getElementById("userId").value;

        $.ajax({
            type: "post",
            url: "/member/duplicateCheck",
            dataTypes: "text",
            data: {
                inputId: inputId
            },
            success: function (result) {
                if (result == "Y") {
                    duplicateEmail.innerHTML = "사용가능한 아이디 입니다!"
                    duplicateEmail.style.color = "green";
                } else {
                    duplicateEmail.innerHTML = "이미 사용중인 아이디 입니다!"
                    duplicateEmail.style.color = "red";
                }
            },
            error: function () {
                console.log("실패")

            }
        });

    }

    const doublePassCheck = () => {
        const doublePass = document.getElementById("doublePass");
        if (!passResult) {
            doublePass.innerHTML = "비밀번호와 재확인비밀번호가 일치하지 않습니다!"
            doublePass.style.color = "red";
        } else {
            doublePass.innerHTML = "비밀번호와 일치합니다!"
            doublePass.style.color = "green";
        }

    }

    const passCheck = () => {
        const memberPassword = document.getElementById("memberPassword").value;
        const expPass = document.getElementById("expPass");
        if (!memberPassword.match(passExp)) {
            expPass.innerHTML = "영문 소문자(필수), 숫자(필수)를 포함하여 5~10 비밀번호를 생성해주세요!"
            expPass.style.color = "red";
        } else {
            expPass.innerHTML = "사용가능합니다!";
            expPass.style.color = "green";
        }
    }

    const mobileCheck = () => {
        const expMobile = document.getElementById("expMobile");
        const memberMobile = document.getElementById("memberMobile").value;
        if (!memberMobile.match(mobileExp)) {
            expMobile.innerHTML = "'-'를 포함한 연락처를 입력하세요!"
            expMobile.style.color = "red";
        } else {
            expMobile.innerHTML = "사용가능합니다!"
            expMobile.style.color = "green";
        }
    }

    const memberSave = () => {
        console.log("함수호출")
        if (document.saveForm.userId.value == "") {
            alert("아이디를 입력하세요")
            return;
        }
        if (document.saveForm.memberPassword.value == "") {
            alert("비밀번호를 입력하세요")
            return;
        }
        if (!passResult && checkPassword == "") {
            alert("재확인 비밀번호를 확인후 입력하세요")
            return;
        }
        if (document.saveForm.memberName.value == "") {
            alert("이름을 입력하세요")
            return;
        }
        if (document.saveForm.memberMobile.value == "") {
            alert("연락처를 입력하세요")
        } else {
            console.log(document.getElementById("userId").value)
            document.saveForm.submit();
        }
        // document.memberSaveForm.submit();
    }
</script>
</html>
