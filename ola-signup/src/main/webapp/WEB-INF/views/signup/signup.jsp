<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rapido Signup</title>

<style>
    * {
        box-sizing: border-box;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }

    body {
        margin: 0;
        height: 100vh;
        background: linear-gradient(135deg, #ffd200, #f7971e);
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .glass-card {
        width: 380px;
        padding: 30px;
        border-radius: 16px;
        background: rgba(255, 255, 255, 0.25);
        backdrop-filter: blur(12px);
        box-shadow: 0 15px 30px rgba(0,0,0,0.25);
        animation: fadeIn 1s ease;
    }

    @keyframes fadeIn {
        from { opacity: 0; transform: translateY(20px); }
        to { opacity: 1; transform: translateY(0); }
    }

    .glass-card h2 {
        text-align: center;
        color: #1f1f1f;
        margin-bottom: 25px;
        font-weight: 700;
        letter-spacing: 1px;
    }

    .input-group {
        margin-bottom: 15px;
    }

    label {
        display: block;
        font-size: 14px;
        color: #222;
        margin-bottom: 5px;
        font-weight: 600;
    }

    input {
        width: 100%;
        padding: 10px 12px;
        border-radius: 8px;
        border: none;
        outline: none;
        font-size: 14px;
        background: rgba(255,255,255,0.85);
        transition: all 0.3s ease;
    }

    input:focus {
        box-shadow: 0 0 0 2px #ffae00;
        background: #fff;
    }

    .btn {
        width: 100%;
        padding: 12px;
        border: none;
        border-radius: 10px;
        background: linear-gradient(135deg, #1f1f1f, #3b3b3b);
        color: #ffd200;
        font-size: 16px;
        font-weight: bold;
        cursor: pointer;
        margin-top: 15px;
        transition: transform 0.3s, box-shadow 0.3s;
    }

    .btn:hover {
        transform: translateY(-2px);
        box-shadow: 0 10px 20px rgba(0,0,0,0.3);
    }

    .footer-text {
        text-align: center;
        margin-top: 15px;
        font-size: 13px;
        color: #222;
    }

    .footer-text span {
        color: #1f1f1f;
        font-weight: bold;
        cursor: pointer;
    }
</style>

<script>
    function validateForm() {
        let mobile = document.getElementById("mobile").value;

        if (!/^[0-9]{10}$/.test(mobile)) {
            alert("Enter a valid 10-digit mobile number");
            return false;
        }
        return true;
    }
</script>

</head>

<body>

<div class="glass-card">
    <h2>🚕 Rapido Signup</h2>

    <form action="signup" method="post" onsubmit="return validateForm()">

        <div class="input-group">
            <label>Name</label>
            <input type="text" name="name" placeholder="Your full name" required>
        </div>

        <div class="input-group">
            <label>Mobile Number</label>
            <input type="text" name="mobile" id="mobile" placeholder="10-digit number" required>
        </div>

        <div class="input-group">
            <label>Email</label>
            <input type="email" name="email" placeholder="example@mail.com" required>
        </div>

        <button class="btn">Create Account</button>
    </form>

    <div class="footer-text">
        Already registered? <span>Login</span>
    </div>
</div>

</body>
</html>
