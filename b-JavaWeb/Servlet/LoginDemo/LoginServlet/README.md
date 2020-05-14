-[x] 检验用户名是否存在
## 校验用户名是否存在

- ajax + JSON

服务器响应的数据，在客户端使用时，当做json数据格式使用
1. `$.get(type)`：将最后一个参数type指定为`"json"`
2. 在服务器端设置MME类型
    `response.setContentType("application/json;charset=utf-8");`

![](https://blogimage-1255618592.cos.ap-chengdu.myqcloud.com/img20200317121633.png)

![](https://blogimage-1255618592.cos.ap-chengdu.myqcloud.com/img20200317121704.png)