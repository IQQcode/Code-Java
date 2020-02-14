<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>UploadDownload</title>
  </head>
  <body>
  <h2>文件上传</h2>
  <form action="/ServletFile/UploadServlet" method="post" enctype="multipart/form-data">
    <table width = "500px">
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
  <br>
  <hr>
  <br>
  <h2>文件下载</h2>
  <table width = "300px">
    <tr>
      <td>文件预览</td>
      <td>
        <a href="/ServletFile/img/云韵.jpg">图片</a>
        <a href="/ServletFile/img/11.avi">视频</a>
      </td>
    </tr>
    <tr>
      <td>上传下载</td>
      <td>
        <a href="/ServletFile/DownLoadServlet?fileName=云韵.jpg">图片</a>
        <a href="/ServletFile/DownLoadServlet?fileName=11.avi">视频</a>
      </td>
    </tr>
  </table>
  </body>
</html>



