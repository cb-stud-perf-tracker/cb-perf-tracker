<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>CB Tracker - Upload</title>
</head>
<body>
    <h1>Upload CSV</h1>
    <form action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">
        <label for="csvFile">Select CSV file:</label>
        <input type="file" name="csvFile" />
        <br><br>
        <button type="submit">Upload</button>
    </form>
</body>
</html>
