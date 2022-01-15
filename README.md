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

```
在今天也就是2022年1月15日，我看到了一个很触动我的视频。这个视频是B站LKs的视频`BV1xa411B7Qo`  
为什么说这个视频让我很触动呢？在很长一段时间内我都很拒绝录下自己或者拍下自己。就不说原因了。这直接导致了我缺失了很长一段时间的“记忆”  
LKs的视频放出了他25年前的影像资料。听着看着他的世界，我想这我丢失了或者无法回忆起的那些时间，既没有什么留下的东西。  
这让我想到了这个项目创立的目的，就是记录一些自己的想法挂念，乃至于视频影像。
这让我愈发的想完成这个项目，并使用这个项目。当然这是一点作为开发者的小感悟，并不值得深究。但是这的确是我开发这个项目的原动力。
作为只有一个人的开发组，项目的立项、设计、开发、测试等全部都是我一个人的工作，当然在现在我的项目还是一个私有的开发状态。在合适的时间我会将其开源出来。
作为一个初来乍到的小开发者，开发的项目可能不是好，但是作为项目的创始者，我还是希望它越来愈好。  
日后这段话可能就会被删除了，不过可以作为小彩蛋嘛（笑）
```

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

并且，需要预先在数据库中创建一个`url`描述过的空的数据库。
例如：
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
