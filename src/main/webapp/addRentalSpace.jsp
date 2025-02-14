<%--
  Created by IntelliJ IDEA.
  User: dungn
  Date: 2/14/2025
  Time: 9:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Thêm mặt bằng cho thuê</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
        }
        form {
            width: 50%;
            margin: auto;
            border: 1px solid #ddd;
            padding: 20px;
            border-radius: 10px;
            background-color: #f9f9f9;
        }
        label {
            font-weight: bold;
            display: block;
            margin: 10px 0 5px;
        }
        input, select {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
        }
        button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            border: none;
            cursor: pointer;
            font-size: 16px;
        }
        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

<h2>Thêm mặt bằng cho thuê</h2>

<form action="/rental_space?action=create" method="post">
    <input type="hidden" name="action" value="create">

    <label for="spaceID">Mã mặt bằng:</label>
    <input type="text" id="spaceID" name="spaceID" required>

    <label for="status">Trạng thái:</label>
    <select id="status" name="status" required>
        <option value="AVAILABLE">AVAILABLE</option>
        <option value="FULLYFURNISHED">FULLYFURNISHED</option>
        <option value="INFRASTRUCTURE">INFRASTRUCTURE</option>
    </select>

    <label for="area">Diện tích (m²):</label>
    <input type="number" id="area" name="area" step="0.1" required>

    <label for="floor">Tầng:</label>
    <select id="floor" name="floor" required>
        <c:forEach var="i" begin="1" end="15">
            <option value="${i}">${i}</option>
        </c:forEach>
    </select>

    <label for="spaceType">Loại mặt bằng:</label>
    <select id="spaceType" name="spaceType" required>
        <option value="SHARED">SHARED</option>
        <option value="PRIVATE">PRIVATE</option>
    </select>

    <label for="price">Giá thuê (VND):</label>
    <input type="number" id="price" name="price" required>

    <label for="startDate">Ngày bắt đầu:</label>
    <input type="date" id="startDate" name="startDate" required>

    <label for="endDate">Ngày kết thúc:</label>
    <input type="date" id="endDate" name="endDate" required>

    <button type="submit">Thêm mới</button>
</form>

<br>
<a href="/rental_space"><button style="background-color: #ccc;">Quay lại</button></a>

</body>
</html>
