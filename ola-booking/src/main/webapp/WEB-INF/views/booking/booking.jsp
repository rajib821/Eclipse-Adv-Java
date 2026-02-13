<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Start Ola Ride</title>

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
        width: 420px;
    }

    h2 {
        text-align: center;
        color: #2e7d32;
        margin-bottom: 25px;
    }

    label {
        font-weight: bold;
        display: block;
        margin-top: 15px;
        color: #333;
    }

    input[type="text"] {
        width: 100%;
        padding: 10px;
        margin-top: 6px;
        border-radius: 6px;
        border: 1px solid #ccc;
        font-size: 14px;
    }

    .ride-options {
        margin-top: 15px;
    }

    .ride-options label {
        font-weight: normal;
        margin-right: 15px;
        cursor: pointer;
    }

    .submit-btn {
        width: 100%;
        margin-top: 25px;
        padding: 12px;
        background: #00b386;
        color: white;
        font-size: 16px;
        border: none;
        border-radius: 8px;
        cursor: pointer;
        transition: background 0.3s ease;
    }

    .submit-btn:hover {
        background: #009970;
    }
</style>

</head>
<body>

<div class="card">
    <h2>🚕 Start Your Ride</h2>

    <form action="bookMyRide">

        <label>Source</label>
        <input type="text" name="source" placeholder="Enter pickup location" required>

        <label>Destination</label>
        <input type="text" name="destination" placeholder="Enter drop location" required>

        <label>Choose Ride Type</label>
        <div class="ride-options">
            <label>
                <input type="radio" name="rideType" value="car" required> Car 🚗
            </label>
            <label>
                <input type="radio" name="rideType" value="bike"> Bike 🏍️
            </label>
            <label>
                <input type="radio" name="rideType" value="auto"> Auto 🛺
            </label>
        </div>

        <button type="submit" class="submit-btn">Book Ride</button>

    </form>
</div>

</body>
</html>
