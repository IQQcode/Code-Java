## 验证码登录Demo

**之前Demo案例参考**

- [**Servlet登录案例Demo(详解每一步操作)**](https://blog.csdn.net/weixin_43232955/article/details/104245163) **基础登录功能实现**

- [**java动态实现验证码(详细案例)**](https://blog.csdn.net/weixin_43232955/article/details/104290465)

---------------------------------------


### 用户登录需求

用户登录案例需求：

1. 编写login.html登录页面username&password 两个输入框

2. 使用Druid数据库连接池技术，操作mysql，LoginDemo数据库中user表

3. 使用dbcTemplate技术封装 JDBC

4. 登录成功跳转到Successservlet展示：登录成功！用户名，欢迎您

5. 登录失败跳转到Failservlet展示：登录失败，用户名或密码错误

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200218162441962.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzIzMjk1NQ==,size_16,color_FFFFFF,t_70)

### 验证码登录要求


访问带有验证码的登录页面 `login.jsp`

用户输入用户名，密码以及验证码

* 如果用户名和密码输入有误，跳转登录页面，提示：用户名或密码错误

* 如果验证码输入有误，跳转登录页面，提示：验证码错误

* 如果全部输入正确，则跳转到主页`success.jsp`，显示：用户名，欢迎图

### 分析

Q1：将用户信息`username` 和 `password`与验证码分成两次请求，先来验证验证码的请求

- 如果先验证用户信息正确，验证码错误的话，无法登陆，会加重数据库的访问次数

Q2：将程序生成的验证码放入到Session中，与用户输入的进行比对！两次请求进行数据共享

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200218162240777.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzIzMjk1NQ==,size_16,color_FFFFFF,t_70)
