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
  <h2>Danh sách mặt bằng cho thuê</h2>
  <a href="rental_space?action=create">
    <button class="btn btn-add">Thêm Mới</button>
  </a>

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
          <!-- Nút Xóa -->
          <form action="deleteRentalSpace" method="post" onsubmit="return confirm('Bạn có chắc chắn muốn xóa không?')">
            <input type="hidden" name="spaceID" value="${space.spaceID}">
            <button type="submit" class="btn btn-delete">Xóa</button>
          </form>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>
