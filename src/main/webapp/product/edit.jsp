<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="product" type="model.Product" scope="request" />
<html>
<head>
    <title>Edit Product</title>
</head>
<body>
<h2>Edit Product</h2>
<form method="post" action="products">
    <input type="hidden" name="action" value="update"/>
    <input type="hidden" name="id" value="${product.id}"/>
    <div>
        Name: <input type="text" name="name" value="${product.name}" required/>
    </div>
    <div>
        Price: <input type="number" name="price" step="0.01" value="${product.price}" required/>
    </div>
    <div>
        <input type="submit" value="Update"/>
    </div>
</form>
<a href="products">Back to List</a>
</body>
</html>
