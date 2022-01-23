<div align='center'>
     此处有一张炫酷的图标
     <br/>
     <sub> (请自行脑补，笑) </sub>
</div>
<h1 align='center'> JlWiki </h1>

<div align="center">
  <strong>:high_brightness: 下一代 wiki :crescent_moon:</strong>
  <br>一个高性能的 wiki，兼顾安全和便捷<br>
  <sub>可用于 Linux、macOS 和 Windows 乃至 Android、ios。</sub>
</div>

<br/>

<div align='center'>
  <a href = "LICENSE">
     <img src = "https://img.shields.io/github/license/cgglyle/JlWiki.svg" alt = "LICENSE"/>
  </a>
  <a href = "forks">
     <img src = "https://img.shields.io/github/forks/cgglyle/JlWiki.svg" alt = "forks"/>
  </a>
  <a href = "stars">
     <img src = "https://img.shields.io/github/stars/cgglyle/JlWiki.svg" alt = "stars"/>
  </a>
  <a href = "watchers">
     <img src = "https://img.shields.io/github/watchers/cgglyle/JlWiki.svg" alt = "watchers"/>
  </a>
</div>

<div align="center">
  <sub>此 wiki 架构由
    <a href="https://github.com/cgglyle">cgglyle</a> 和
    <a href="https://github.com/cgglyle/JlWiki/graphs/contributors">
      贡献者们
    </a>
    倾力 ❤︎ 打造</sub>
</div>

<div align="center">
     <a href="https://t.me/JlWiki">
        <sub>Telegram开发群组</sub>
     </a>
</div>

## READEME
***项目目前处于原型状态！甚至还没有添加前端，不具备可用性。下方介绍只是事先拟定好的。***

## 为什么开发 JlWiki
本项目是蓄谋已久的想法了，很早之前就想自己独立开发一个wiki软件了。长久以来我都是使用Mediawiki搭建的服务记录笔记，虽然Mediawiki是一个很完善，有大量开发者的现成的框架。不过我还是想要自己开发一个完全由自己开发的项目，诶嘿～  
啊，对了，为什么叫``JlWiki``，因为本项目是使用``Java``开发的``Wiki``项目，至于`l`，那是我的姓（笑）  


>在今天也就是2022年1月15日，我看到了一个很触动我的视频。这个视频是B站LKs的视频`BV1xa411B7Qo`  
为什么说这个视频让我很触动呢？在很长一段时间内我都很拒绝录下自己或者拍下自己。就不说原因了。这直接导致了我缺失了很长一段时间的“记忆”  
LKs的视频放出了他25年前的影像资料。听着看着他的世界，我想这我丢失了或者无法回忆起的那些时间，既没有什么留下的东西。  
这让我想到了这个项目创立的目的，就是记录一些自己的想法挂念，乃至于视频影像。
这让我愈发的想完成这个项目，并使用这个项目。当然这是一点作为开发者的小感悟，并不值得深究。但是这的确是我开发这个项目的原动力。
作为只有一个人的开发组，项目的立项、设计、开发、测试等全部都是我一个人的工作，当然在现在我的项目还是一个私有的开发状态。在合适的时间我会将其开源出来。
作为一个初来乍到的小开发者，开发的项目可能不是好，但是作为项目的创始者，我还是希望它越来愈好。  
日后这段话可能就会被删除了，不过可以作为小彩蛋嘛（笑）

## 为什么选择JlWiki

* JlWiki有完善的系统架构，支持高质量的缓存系统，具有良好的系统鲁棒性。
* JlWiki具有完善的权限系统，动态授权系统，所有wiki都在其保护之下，只有具有相应权限的用户才可以访问的相应wiki。
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

## FAQ

### 我不是一个IT人员我可以使用JlWiki吗？
当然，这是肯定的，尽管您不是一名IT人员，但是这并不妨碍您使用JlWiki，实际上，JlWiki是面向所有用户的，您可以考虑使用我们提供的[JlWiki网站]()，或者您可以考虑自己搭建一个JlWiki，这并不困难。具体的搭建方式可以查看上方提供的搭建技巧，或者查看更为详细的搭建文档。

### JlWiki足够安全么？我可以存放一些相当机密的文件么？
JlWiki有足够的安全性，访问的每一个接口都有安全检查。但是我们仍不建议您将相当机密的文档，或者其他放到公开的JlWiki之上，因为不排除服务器收到未曾预料的攻击。但是如果您是一名具有一定安全知识的开发人员，我们建议您将JlWiki搭建到内网服务器中，并完全隔绝与外网的通信，只要排出社会工程学的攻击，我们可以保证您的数据有足够的安全性。

### 使用JlWiki需要付款么？
JlWiki目前是完全免费的。您可以尽情的使用JlWiki。

### JlWiki会提供技术性支持么？
JlWiki目前只有非常少的开发者，可能无法提供7x24小时的技术型支持。但是您仍可以在[Issues](https://github.com/cgglyle/JlWiki/issues/new)中提交您的问题，如果我们看到您的问题，我们会提供解决方案的。

### JlWiki会不会丢失数据？
JlWiki只是一个写作的框架，存储结构还是您的硬盘。（我们建议您存储重要数据的时候，使用多重备份的手段，以保证数据安全。）当然，我们提供的[JlWiki网站]()是可以保证数据安全的，我们正在使用阿里云的存储空间，如果阿里云不出问题，您的数据也不应当出现问题。

### JlWiki的管理员或者开发者会不会看到我的私有文件？
我们可以向您保证，**不会**！我们专门设计了这部分，和公开的wiki不一样，如果您的wiki被您设置成私有状态，您的wiki会被妥善的加密处理，并且只有您才能解开这份加密wiki。

### JlWiki可以成为维基百科那样的wiki么？
尽管我们很想将JlWiki打造成一个像维基百科一样的供全球使用的超乎想象的wiki，但是受现实所迫，这可能非常困难，甚至有点不切实际。不过，这仍不影响JlWiki朝着那美好的愿景出发！

### 我可以为JlWiki做些什么？它实在是太棒了！
很高兴您可以这样评价我们的JlWiki，实际上我们相当的高兴！如果您想为JlWiki做出贡献，有几种方式：
* 如果您是一名开发者，您可以做出开发并提交PR或者ISSUES，我们建议您这么做。
* 如果您不是一名开发者，您可以帮助我们宣传JlWiki，或者提供资助，**您的资助将全部用于开发JlWiki和JlWiki服务器的续期或者升级**。

## 维护者
[@cgglyle](https://github.com/cgglyle)

## 贡献
随意提交[Issues](https://github.com/cgglyle/JlWiki/issues/new)或[Pull requests](https://github.com/cgglyle/JlWiki/pulls)  
***请贡献者开发时尽量保证系统的弹性，以保证后续开发的便捷，以及维护的便利***

## 贡献者

## License
[GPL v3](https://www.gnu.org/licenses/gpl-3.0.html) © cgglyle

## 项目增长幅度
![](https://starchart.cc/cgglyle/JlWiki.svg)
