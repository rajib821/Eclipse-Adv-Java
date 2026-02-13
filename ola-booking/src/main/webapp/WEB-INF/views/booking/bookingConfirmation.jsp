<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Booking Confirmation</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background: linear-gradient(135deg, #e0f7fa, #f1f8e9);
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }

    .card {
        background: #ffffff;
        padding: 35px 45px;
        border-radius: 12px;
        box-shadow: 0 10px 25px rgba(0, 0, 0, 0.15);
        text-align: center;
        width: 400px;
    }

    h2 {
        color: #2e7d32;
        margin-bottom: 20px;
    }

    .code {
        font-size: 22px;
        font-weight: bold;
        color: #1565c0;
        letter-spacing: 2px;
        margin: 15px 0 25px;
    }

    a {
        text-decoration: none;
        background: #00b386;
        color: white;
        padding: 12px 26px;
        border-radius: 8px;
        font-size: 16px;
        transition: background 0.3s ease;
    }

    a:hover {
        background: #009970;
    }
</style>

</head>
<body>

<div class="card">
    <h2>🚕 Ride Booked Successfully</h2>

    <p>Booking Confirmation Code</p>
    <div class="code">${bookingConfirmationCode}</div>

    <a href="viewBooking">Book Another Ride</a>
</div>

</body>
</html>
