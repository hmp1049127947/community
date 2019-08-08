## 简单社区

### 参考资料
[spring boot文档](https://zed058.cn/code/dev/Spring%20Boot%20%E5%85%A5%E9%97%A8.html) （后端框架）

[bootstrap文档](https://v3.bootcss.com/getting-started/) （前端框架）

[Thymeleaf文档](https://spring.io/guides/gs/serving-web-content/)  （模板引擎）

[github OAuth](https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/) （通过GitHub API登录社区）


### 所用工具
[Visual Paradigm](https://www.visual-paradigm.com/cn/download/) （用来画uml时序图）

[okHttp](https://square.github.io/okhttp/) （okHttp文档，发送post请求）

[FastJSON](https://mvnrepository.com/artifact/com.alibaba/fastjson) （用fastJson转换工具）


## github登录
![githubLogin](images/git登录时序图.jpg)

## user表脚本"
    DROP TABLE IF EXISTS `user`;
    CREATE TABLE `user` (
      `id` int(11) NOT NULL AUTO_INCREMENT,
      `account_id` varchar(100) DEFAULT NULL,
      `name` varchar(50) DEFAULT NULL,
      `token` varchar(36) DEFAULT NULL,
      `gmt_create` bigint(20) DEFAULT NULL,
      `gmt_modified` bigint(20) DEFAULT NULL,
      PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
    


