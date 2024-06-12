<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*, com.unittest.bank.crud.model.Product" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product List</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <h1>Product List</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
        </tr>
        <%
            List<Product> products = (List<Product>) request.getAttribute("products");
            for (Product product : products) {
        %>
        <tr>
            <td><%= product.getId() %></td>
            <td><%= product.getName() %></td>
            <td><%= product.getPrice() %></td>
        </tr>
        <% } %>
    </table>
    <a href="addproduct.jsp">Add New Product</a>
</body>
</html>
