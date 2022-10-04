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
        <title>Login fail</title>
    </head>
    <style>
        body{
            text-align: center;
        }
    </style>
    <body>
    <div class="container">
        <h2>!!! 로그인 실패 !!!</h2>
        <button type="button" onclick="location.href='loginPage'">돌아가기</button>
    </div>
    </body>
    </html>

</layoutTag:layout>