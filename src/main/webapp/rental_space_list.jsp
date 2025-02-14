<%--
  Created by IntelliJ IDEA.
  User: dungn
  Date: 2/14/2025
  Time: 9:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Danh sách mặt bằng cho thuê</title>
  <style>
    table {
      width: 80%;
      margin: auto;
      border-collapse: collapse;
      margin-top: 20px;
    }
    th, td {
      border: 1px solid #ddd;
      padding: 8px;
      text-align: center;
    }
    th {
      background-color: #f2f2f2;
    }
    .container {
      text-align: center;
    }
  </style>
</head>
<body>
<div class="container">
  <!-- Form tìm kiếm -->

  <h2>Danh sách mặt bằng cho thuê</h2>
  <a href="rental_space?action=create">
    <button class="btn btn-add">Thêm Mới</button>
  </a>
  <br>

  <form action="rental_space" method="get">
    <input type="hidden" name="action" value="search">

    <!-- Loại mặt bằng -->
    <label for="spaceType">Loại mặt bằng:</label>
    <select id="spaceType" name="spaceType">
      <option value="">-- Chọn loại --</option>
      <option value="PRIVATE" ${selectedSpaceType == 'PRIVATE' ? 'selected' : ''}>PRIVATE</option>
      <option value="SHARED" ${selectedSpaceType == 'SHARED' ? 'selected' : ''}>SHARED</option>

    </select>

    <!-- Tầng -->
    <label for="floor">Tầng:</label>
    <select id="floor" name="floor">
      <option value="">-- Chọn tầng --</option>
      <c:forEach var="i" begin="1" end="15">
        <option value="${i}" ${param.floor == i ? 'selected' : ''}>${i}</option>
      </c:forEach>
    </select>

    <!-- Giá thuê -->
    <label for="minPrice">Giá thuê từ:</label>
    <input type="number" id="minPrice" name="minPrice" value="${param.minPrice}" placeholder="VNĐ">

    <label for="maxPrice">Đến:</label>
    <input type="number" id="maxPrice" name="maxPrice" value="${param.maxPrice}" placeholder="VNĐ">

    <button type="submit">Tìm kiếm</button>
  </form>

  <table>
    <thead>
    <tr>
      <th>Mã mặt bằng</th>
      <th>Trạng thái</th>
      <th>Diện tích (m²)</th>
      <th>Tầng</th>
      <th>Loại mặt bằng</th>
      <th>Giá thuê (VND)</th>
      <th>Ngày bắt đầu</th>
      <th>Ngày kết thúc</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="space" items="${rsList}">
      <tr>
        <td>${space.spaceID}</td>
        <td>${space.status}</td>
        <td>${space.area}</td>
        <td>${space.floor}</td>
        <td>${space.spaceType}</td>
        <td>${space.price} VND</td>
        <td>${space.startDate}</td>
        <td>${space.endDate}</td>
        <td>
          <a href="rental_space?action=delete&id=${space.spaceID}" class="action-btn delete"
             onclick="return confirm('Bạn có chắc chắn muốn xóa?')">Delete</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>
