<%@ page contentType="text/html; charset=UTF-8" language="java"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="layoutTag" tagdir="/WEB-INF/tags"%>

<layoutTag:layout>
    <!DOCTYPE html PUBLIC"-//W3C//DTDHTML4.01Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html lang="ko">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <html lang="ko" xmlns:th="http://www.thymeleaf.org"></html>
        <title>Register</title>
    </head>
    <style>
        table{
            margin-left: auto;
            margin-right: auto;
        }
        body{
            text-align: center;
        }
    </style>
    <body>
    <div class="container">
        <h2>회원가입</h2>
        <form method="post" action="/register_action">
            <table class="login_table">
                <tr>
                    <td>아이디</td>
                    <td><input type="text"name="userId" placeholder="아이디"></td>
                </tr>
                <tr>
                    <td>이름</td>
                    <td><input type="text"name="userName" placeholder="이름"></td></td>
                </tr>
                <tr>
                    <td>비밀번호</td>
                    <td><input type="password"name="userPassword" placeholder="비밀번호"></td>
                </tr>
            </table>
            <button type="submit">가입</button>
        </form>
    </div>
    </body>
    </html>

</layoutTag:layout>