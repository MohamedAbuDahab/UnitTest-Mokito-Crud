<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Product</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <h1>Add New Product</h1>
    <form action="product" method="post">
        <label for="name">Product Name:</label>
        <input type="text" id="name" name="name" required><br>
        <label for="price">Product Price:</label>
        <input type="text" id="price" name="price" required><br>
        <button type="submit">Add Product</button>
    </form>
    <a href="../product">Back to Product List</a>
</body>
</html>
