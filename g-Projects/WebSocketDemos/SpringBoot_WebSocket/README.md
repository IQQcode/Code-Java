## 四个关于SpringBoot-WebSocket Demos

### WebSocket 示例一：实现简单的广播模式
WebSocket 常分为广播与队列模式，广播模式是向订阅广播的用户发送信息，只要订阅相关广播就能收到对应信息。而队列模式常用于点对点模式，为单个用户向另一个用户发送信息，这里先介绍下广播模式的实现示例。


  
### WebSocket 示例二：实现点对点模式(引入 Spring Security 实现鉴权)
这里使用 Maven 工具管理依赖包，分别引入下面依赖：

lombok： Lombok 工具依赖，便于生成实体对象的 Get 与 Set 方法。
spring-boot-starter-websocket：SpringBoot 实现 WebSocket 的依赖，里面对 WebSocket 进行了一些列封装，并且也包含了 SpringBoot Web 依赖。
spring-boot-starter-security：Spring Security，这是一种基于 Spring AOP 和 Servlet 过滤器的安全框架。它提供全面的安全性解决方案，同时在 Web 请求级和方法调用级处理身份确认和授权。


### WebSocket 示例三：实现点对点模式(根据请求头 Header 实现鉴权)
这里使用 Maven 工具管理依赖包，分别引入下面依赖：

lombok： Lombok 工具依赖，便于生成实体对象的 Get 与 Set 方法。
spring-boot-starter-security：Spring Security，这是一种基于 Spring AOP 和 Servlet 过滤器的安全框架。它提供全面的安全性解决方案，同时在 Web 请求级和方法调用级处理身份确认和授权。


### WebSocket 示例四：实现点对点模式(根据 HTTP Session 实现鉴权)