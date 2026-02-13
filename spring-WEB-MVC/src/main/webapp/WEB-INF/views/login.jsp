<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Zepto | Sign Up</title>

<style>
    body {
        margin: 0;
        padding: 0;
        font-family: Arial, sans-serif;
        background: #ffffff;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .signup-container {
        width: 350px;
        padding: 30px;
        box-shadow: 0 0 15px rgba(0,0,0,0.1);
        border-radius: 10px;
    }

    .logo {
        text-align: center;
        font-size: 28px;
        font-weight: bold;
        color: #6b2cff;
        margin-bottom: 20px;
    }

    h2 {
        text-align: center;
        margin-bottom: 20px;
    }

    input {
        width: 100%;
        padding: 12px;
        margin: 10px 0;
        border: 1px solid #ccc;
        border-radius: 6px;
        font-size: 14px;
    }

    button {
        width: 100%;
        padding: 12px;
        background: #6b2cff;
        color: white;
        border: none;
        border-radius: 6px;
        font-size: 16px;
        cursor: pointer;
    }

    button:hover {
        background: #5822cc;
    }

    .login-link {
        text-align: center;
        margin-top: 15px;
        font-size: 14px;
    }

    .login-link a {
        color: #6b2cff;
        text-decoration: none;
        font-weight: bold;
    }
</style>
</head>

<body>

<div class="signup-container">
    <div class="logo">zepto</div>

    <h2>Create Account</h2>

    <form action="signup" method="post">
        <input type="text" name="name" placeholder="Full Name" required />
        <input type="email" name="email" placeholder="Email Address" required />
        <input type="text" name="mobile" placeholder="Mobile Number" required />
        <input type="password" name="password" placeholder="Password" required />

        <button type="submit">Sign Up</button>
    </form>

    <div class="login-link">
        Already have an account?
        <a href="login">Login</a>
    </div>
</div>

</body>
</html>
