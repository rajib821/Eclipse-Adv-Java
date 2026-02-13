<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile Created</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f2f5;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .container {
        background-color: #ffffff;
        padding: 40px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0,0,0,0.2);
        text-align: center;
    }

    h3 {
        color: #28a745;
        margin-bottom: 30px;
    }

    a {
        display: inline-block;
        text-decoration: none;
        background-color: #0073e6;
        color: white;
        padding: 12px 25px;
        border-radius: 6px;
        font-weight: bold;
        transition: background-color 0.3s ease;
    }

    a:hover {
        background-color: #005bb5;
    }
</style>
</head>
<body>
    <div class="container">
        <h3>Successfully created profile.</h3>
        <a href="viewAllUsers">View All Users</a>
    </div>
</body>
</html>
