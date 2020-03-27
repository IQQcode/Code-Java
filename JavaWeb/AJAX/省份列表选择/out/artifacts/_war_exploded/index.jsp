<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Select列表选择</title>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script>
      $(function() {
        //发送ajax请求，加载所有省份数据
        $.get("provinceServlet" ,{} , function (data) {
          //[{"id":1,"name":"北京"},{"id":2,"name":"上海"},{"id":3,"name":"广州"},{"id":4,"name":"陕西"}]
          //获取servlet
          var province = $("#province");
          //遍历JSON数组
          $(data).each(function() {
            //创建<option>
            var option = "<option name='" + this.id + "'>" + this.name + "</option>";

            //调用select的append追加option
            province.append(option);
          })
        });
      });
    </script>
  </head>
  <body>
    <select id="province">
      <option>---省份选择---</option>
    </select>
  </body>
</html>
