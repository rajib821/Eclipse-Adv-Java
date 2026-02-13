<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup Successful</title>

<style>
    body {
        margin: 0;
        height: 100vh;
        background: linear-gradient(135deg, #43cea2, #185a9d);
        display: flex;
        justify-content: center;
        align-items: center;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }

    .success-card {
        background: white;
        padding: 35px 40px;
        border-radius: 16px;
        text-align: center;
        width: 380px;
        box-shadow: 0 15px 30px rgba(0,0,0,0.25);
        animation: popIn 0.8s ease;
    }

    @keyframes popIn {
        from { transform: scale(0.8); opacity: 0; }
        to { transform: scale(1); opacity: 1; }
    }

    .check {
        font-size: 60px;
        color: #2ecc71;
        margin-bottom: 15px;
    }

    h2 {
        color: #185a9d;
        margin-bottom: 10px;
    }

    p {
        color: #555;
        font-size: 15px;
        margin-bottom: 25px;
    }

    .btn {
        display: inline-block;
        padding: 10px 25px;
        background: linear-gradient(135deg, #185a9d, #43cea2);
        color: white;
        text-decoration: none;
        border-radius: 25px;
        font-weight: bold;
        transition: transform 0.3s, box-shadow 0.3s;
    }

    .btn:hover {
        transform: translateY(-2px);
        box-shadow: 0 8px 15px rgba(0,0,0,0.3);
    }
</style>

</head>
<body>

<div class="success-card">
    <div class="check">✔</div>
    <h2>Signup Successful!</h2>
    <p>You have successfully registered with Rapido.</p>

    <a href="login" class="btn">Go to Login</a>
</div>

</body>
</html>
