<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../CSS/login.css">
    <title>Document</title>
</head>
<body>
    <div class="login-box">
        <h2>Login</h2>
        <form action="/JSPSHOP/users/signin" method="post">
          <div class="user-box">
            <input type="text" name="username" required autocomplete="off">
            <label>Username</label>
          </div>
          <div class="user-box">
            <input type="password" name="password" required>
            <label>Password</label>
          </div>
          <button type="submit">
            <span></span>
            <span></span>
            <span></span>
            <span></span>
            Submit
          </button>
        </form>
      </div>
</body>
</html>