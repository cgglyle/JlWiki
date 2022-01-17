# JWiki

[![](https://img.shields.io/github/license/cgglyle/JWiki.svg)](https://img.shields.io/github/license/cgglyle/JWiki/main/LICENSE)
![](https://img.shields.io/github/forks/cgglyle/JWiki.svg)
![](https://img.shields.io/github/stars/cgglyle/JWiki.svg)
![](https://img.shields.io/github/watchers/cgglyle/JWiki.svg)

本项目是蓄谋已久的想法了，很早之前就想自己独立开发一个wiki软件了。  
长久以来我都是使用Mediawiki搭建的服务记录笔记的。  
虽然Mediawiki是一个很完善，有大量开发者的现成的框架。  
不过我还是想要自己开发一个完全由自己开发的项目，诶嘿～  
啊，对了，为什么叫``Jwiki``，因为本项目是使用``Java``开发的``Wiki``项目（笑）

## 为什么选择JWiki

* JWiki有完善的系统架构，支持高质量的缓存系统，具有良好的系统鲁棒性。
* JWiki具有完善的权限系统，动态授权系统，所有wiki都在其保护之下，只有具有相应权限的用户才可以访问的相应wiki。
* 支持JWT单点登录，保证只需登陆一次，即可访问所有项目。

## 项目架构

项目目前采用单体架构，数据库使用Mysql储存关系数据，Redis缓存，MongoDb存储文本数据（可能会换）

## 预想完成状态

- [x] 有完整的权限系统
- [x] 有完整的记录系统
- [ ] 支持Markdown格式
- [x] 有Redis缓存
- [ ] 有RabbitMq消息队列（kafka？） ……

## 项目使用技术

* 编程语言：`Java`
* 编程框架：`Spring`, `Spring MVC`, `Spring Boot`
* ORM框架：`MyBatis`, `MyBatis-Plus`
* 安全框架：`Spring Security`
* 关系数据库：`MySQL`
* 文档数据库：`MongoDB`
* 缓存：`Redis`
* 接口工具：`Knife4j`
* JWT工具：`JJWT`
* 消息队列框架：`RabbitMQ`

## 使用方式

* Docker启动
* 裸机启动

### Docker方式启动

可以直接使用`Docker-file`文件直接创建，修改一点配置文件即可，几乎不用配置。

```dockerfile

```

## 配置文件

首先需要配置`application.yml`文件，该文件有几个必须配置的项：

* `datasource.url` 数据库地址
* `datasource.username` 数据库用户名
* `datasource.password` 数据库密码

并且，需要预先在数据库中创建一个`url`描述过的空的数据库。 例如：

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/wiki?allowMultiQueries=true&useUnicode=true&nullCatalogMeansCurrent=true&characterEncoding=UTF-8  
```

也就是一个名为`wiki`的mysql数据库。

## 维护者

[@cgglyle](https://github.com/cgglyle)

## 贡献

随意提交[Issues](https://github.com/cgglyle/JWiki/issues/new)或[Pull requests](https://github.com/cgglyle/JWiki/pulls)

## 贡献者

## License

[GPL v3](https://www.gnu.org/licenses/gpl-3.0.html) © cgglyle

## 项目增长幅度

![](https://starchart.cc/cgglyle/JWiki.svg)
