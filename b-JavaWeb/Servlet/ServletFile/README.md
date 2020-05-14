## Servlet文件上传与下载Demo

### 文件上传

- Servlet 可以与 HTML form 标签一起使用，来允许用户上传文件到服务器。
- 上传的文件可以是文本文件或图像文件或任何文档。
 
### 文件下载需求
1. 页面显示超链接
2. 点击超链接后弹出下载提示框
3. 完成图片文件下载

分析

1. 超链接指向的资源如果能够被浏览器解析，则在浏览器中展示;如果不能解析，则弹出下载提示框,

2. 任何资源都必须弹出下载提示框

3. 使用响应头设置资源的打开方式
- content-disposition:attachment;filename=xxx

步骤
1. 定义页面，编辑超链接href属性，指向servlet，传递资源名称filename
2. 定义Servlet
    1. 获取文件名称
    2. 使用字节输入流加载文件进内存
    3. 指定response的响应头:content-disposition:attachment；filename=xxx
    4. 将数据写出到response输出流