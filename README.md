# 家政服务平台后台

## 项目介绍

毕业设计家政服务平台

* [用户端](https://github.com/mysilicons/HouseKeepDemo)
* [商家端](https://github.com/mysilicons/Merchant)
* [管理员端](https://github.com/mysilicons/RuoYi)
* [后台SpringBoot](https://github.com/mysilicons/LoginServer)

## 本项目环境

* JDK17
* Maven3.8.1
* MySQL8.0.25
* IDEA2023.1.1
* SpringBoot3.0.4

## 后台运行方法

1. 安装JDK17
2. 安装Maven3.8.1
3. 安装MySQL8.0.25
4. 安装IDEA2023.1.1
5. 完成[管理员端](https://github.com/mysilicons/RuoYi)sql文件导入
6. 修改```resources```目录下的```application.properties```文件

```properties
server.port=端口
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=数据库地址
spring.datasource.username=用户名
spring.datasource.password=密码
logging.level.cn.mysilicon.loginserver.mapper=debug
```

7. 项目运行