<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload File</title>
</head>
<body>
<h2>Upload File</h2>
<form action="upload" method="post" enctype="multipart/form-data">
    <label>Select file:</label>
    <input type="file" name="file"><br><br>
    <input type="submit" value="Upload">
</form>
<a href="products">Back to Product List</a>
</body>
</html>
