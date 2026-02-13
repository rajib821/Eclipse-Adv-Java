<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Your Profile</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f2f5;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .form-container {
        background-color: #ffffff;
        padding: 40px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0,0,0,0.2);
        text-align: left;
        width: 300px;
    }

    h2 {
        text-align: center;
        color: #0073e6;
        margin-bottom: 30px;
    }

    label {
        display: block;
        margin-bottom: 5px;
        font-weight: bold;
    }

    input[type="text"] {
        width: 100%;
        padding: 8px;
        margin-bottom: 20px;
        border-radius: 5px;
        border: 1px solid #ccc;
        box-sizing: border-box;
    }

    input[type="submit"] {
        width: 100%;
        padding: 10px;
        background-color: #0073e6;
        color: white;
        border: none;
        border-radius: 5px;
        font-size: 16px;
        cursor: pointer;
    }

    input[type="submit"]:hover {
        background-color: #005bb5;
    }
</style>
</head>
<body>
    <div class="form-container">
        <h2>Create Your Profile</h2>
        <form action="profileCreation" method="post">
            <label for="email">Email:</label>
            <input type="text" name="email" id="email" required>

            <label for="mobile">Mobile:</label>
            <input type="text" name="mobile" id="mobile" required>

            <input type="submit" value="Create Profile">
        </form>
    </div>
</body>
</html>
