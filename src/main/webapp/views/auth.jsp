<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Авторизация</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<form autocomplete='off' class='form' method='post'>
    <div class='control'>
        <h1>
            Sign In
        </h1>
    </div>
    <div class='control block-cube block-input'>
        <input name='username' placeholder='Username' type='text'>
        <div class='bg-top'>x
            <div class='bg-inner'></div>
        </div>
        <div class='bg-right'>
            <div class='bg-inner'></div>
        </div>
        <div class='bg'>
            <div class='bg-inner'></div>
        </div>
    </div>
    <div class='control block-cube block-input'>
        <input name="password" placeholder='Password' type='password'>
        <div class='bg-top'>
            <div class='bg-inner'></div>
        </div>
        <div class='bg-right'>
            <div class='bg-inner'></div>
        </div>
        <div class='bg'>
            <div class='bg-inner'></div>
        </div>
    </div>
    <button class='btn block-cube block-cube-hover' type='submit'>
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
            Log In
        </div>
    </button>
    <% if (request.getAttribute("isLogPassValid") != null && !(Boolean) request.getAttribute("isLogPassValid")) { %>
    <p>Login error</p>
    <% } %>

    <div class='credits'>
        <a href='https://codepen.io/marko-zub/' target='_blank'>
            Author style
        </a>
    </div>
</form>
</html>