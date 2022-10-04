<%@ page contentType="text/html; charset=UTF-8" language="java"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="layoutTag" tagdir="/WEB-INF/tags"%>

<layoutTag:layout>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <html lang="ko" xmlns:th="http://www.thymeleaf.org"></html>
    <title>BoardPage</title>
</head>
<style>
    body{
        text-align: center;
    }
</style>
<body>
<div class="container">
    <h2>게시판</h2>
    <h3>!! 로그인 성공 !!</h3>
    <div th:text="${info}"></div>
</div>
</body>
</html>

</layoutTag:layout>