<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<form action="/ServletFile/UploadServlet" method="post" enctype="multipart/form-data">
    <table width = "600px">
        <tr>
            <td>上传者</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>上传文件</td>
            <td><input type="file" name="myfile"></td>
        </tr>
        <tr>
            <td colspan="2"> <input type="submit"value="上传"/></td>
        </tr>
    </table>
</form>
</body>
</html>
