<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Время и температура в Москве</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<form method="post" class="form">
<div>
    <div class="control">
        <h1>Время и температура в Москве</h1>
    </div>
    <div class="control block-cube">
        <div class='bg-top'>
            <div class='bg-inner'></div>
        </div>
        <div class='bg-right'>
            <div class='bg-inner'></div>
        </div>
        <div class='bg'>
            <div class='bg-inner'></div>
        </div>
        <div class='text'>
            Время:<%= request.getAttribute("time") %>
        </div>
    </div>
    <div class="control block-cube">
        <div class='bg-top'>
            <div class='bg-inner'></div>
        </div>
        <div class='bg-right'>
            <div class='bg-inner'></div>
        </div>
        <div class='bg'>
            <div class='bg-inner'></div>
        </div>
        <div class='text'>
            Дата:<%= request.getAttribute("date") %>
        </div>
    </div>
    <div class="control block-cube">
        <div class='bg-top'>
            <div class='bg-inner'></div>
        </div>
        <div class='bg-right'>
            <div class='bg-inner'></div>
        </div>
        <div class='bg'>
            <div class='bg-inner'></div>
        </div>
        <div class='text'>
            Температура:<%= request.getAttribute("temperature") %> °C
        </div>
    </div>
</div>
</form>
</html>
