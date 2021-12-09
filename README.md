# JWiki

本项目是蓄谋已久的想法了，很早之前就想自己独立开发一个wiki软件了。  
长久以来我都是使用Mediawiki搭建的服务记录笔记的。  
虽然Mediawiki是一个很完善，有大量开发者的现成的框架。  
不过我还是想要自己开发一个完全由自己开发的项目，诶嘿～  
啊，对了，为什么叫``Jwiki``，因为本项目是使用``Java``开发的``Wiki``项目（笑）

## 项目架构

项目目前采用单体架构，数据库使用Mysql储存关系数据，Redis缓存，MongoDb存储文本数据（可能会换）

## 预想完成状态

- [ ] 有完整的权限系统
- [ ] 有完整的记录系统
- [ ] 支持Markdown格式
- [ ] 有Redis缓存
- [ ] 有RabbitMq消息队列（kafka？） ……

## 项目使用技术

* Java
* Spring
* Spring MVC
* Spring Boot
* Spring Security
* Mybatis
* Mybatis-plus
* Redis
* RabbitMq
* knife4j
