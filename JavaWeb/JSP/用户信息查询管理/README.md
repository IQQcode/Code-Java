## 用户信息查询

### 1.需求用户信息的增删改查操作

#### 1.简单功能，列表查询

- 登录

- 添加

- 刪除

- 修改

#### 2.复杂功能

**1.刪除选中**

前台展示页面`list.jsp`中通过JS代码实现，选择每一行记录的id删除即可

-------------------

**2.分页查询**

【目的】
- 减轻服务器内存的开销
- 提升用户体验

【服务器向客户端输出PageBean对象】
1. 总记录数`totalCount`
2. 总页码`totalPage`
3. 每页的数据`list`集合
4. `currentPage`当前页码

【客户端向服务器输入参数】
1. totalCount = select count(*) from user;
2. totalPage = rows //提供每页显示条数给服务器
3. list = select * from user limit index(开始查询的索引) rows
4. index = (currentPage - 1) * rows;

---------------------------------

**3.复杂条件查询**

【服务器向客户端输出PageBean对象】
1. 总记录数`totalCount`
2. 每页的数据`list`集合

【客户端向服务器输入表单参数】
1. totalCount = select count(*) from user;
2. list = select * from user limit index(开始查询的索引) rows



### 2.设计

1. 技术选型：Servlet+JSP+MySQL+DBCTemplate+Druid+BeanUtils+Tomcat



实现原理：三层架构

![](https://blogimage-1255618592.cos.ap-chengdu.myqcloud.com/img20200222145919.png)



### 3.Filter权限控制

- 如果未登录，则不能访问其他页面
- 返回让用户登录

**Q：判断是否包含登录相关的资源资源**

- 不包含；验证用户是否完成了登录？--->否则没有登陆，拦截并跳转到登录页面
- 包含，用户就是想要登录，放行

**Q：判断当前用户是否登录**
- 添加Filter,判断`session`中是否有user

### 4.Filter敏感词汇过滤

1. 对`request`对象的`getParamater()`进行增强，产生一个新的request对象
2. 放行，传递代理对象，将新request对象传入


### TODO

-[ ] 分页功能最后一页`currentPage`处理


sql语句：
```sql
SELECT * FROM `user` where name like '%李%' and address like '%上海%' ;

insert into user(id,name,gender,age,address,qq,email) values (null,'张三','男',18,'上海','123456','163@qq.com');
```




