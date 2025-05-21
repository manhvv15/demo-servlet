<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Create Product</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        h2 {
            color: #333;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: inline-block;
            width: 100px;
        }
        input[type="text"] {
            padding: 5px;
            width: 200px;
        }
        input[type="submit"] {
            padding: 5px 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        a {
            text-decoration: none;
            color: #0066cc;
            margin-left: 10px;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<h2>Create New Product</h2>
<form action="products" method="post">
    <input type="hidden" name="action" value="create"/>
    <div class="form-group">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required placeholder="Enter product name"/>
    </div>
    <div class="form-group">
        <label for="price">Price:</label>
        <input type="number" id="price" name="price" step="0.01" required placeholder="Enter price"/>
    </div>
    <div class="form-group">
        <input type="submit" value="Save"/>
    </div>
</form>
<a href="products">Back to List</a>
</body>
</html>