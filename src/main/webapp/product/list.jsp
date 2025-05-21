<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Product List</h1>
<a href="products?action=create">+ Add Product</a>

<table border="1">
  <thead>
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Price</th>
    <th>Actions</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="p" items="${products}">
    <tr>
      <td>${p.id}</td>
      <td>${p.name}</td>
      <td>${p.price}</td>
      <td>
        <a href="products?action=edit&id=${p.id}">Edit</a>
        <a href="products?action=delete&id=${p.id}" onclick="return confirm('Delete?')">Delete</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
