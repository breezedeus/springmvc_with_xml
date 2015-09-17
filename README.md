
# Maven使用

## 生成Web应用
```bash
$ mvn archetype:generate -DgroupId={project-packaging}
	-DartifactId={project-name}
	-DarchetypeArtifactId=maven-archetype-webapp
	-DinteractiveMode=false
```

例如：
```bash
$ mvn archetype:generate -DgroupId=org.breezedeus
	-DartifactId=springmvcwithxml
	-DarchetypeArtifactId=maven-archetype-webapp
	-DinteractiveMode=false
```

当然，更简单的方式是直接用IDE界面进行操作。

## 依赖分析
* `mvn dependency:list`
* `mvn dependency:tree`
* `mvn dependency:analyze`

## 打包
* `mvn package`

# Spring MVC Web Application


## resources下的文件【不太对，待确认】
所有在`${basedir}/src/main/resources`目录下的文件，在打包时都会放到打包后的根目录下。

## IDEA / Edit Configurations
`+` > Maven > Command line: tomcat7:run

## 调用图

* 启动时：<br>
web.xml --> springmvcwithxml-servlet.xml --> Controllers
* 调用时：<br>

## web.xml
### 设置`contextConfigLocation`的两种方法

* 在设置`servlet-class`时一起设置：
```xml
    <servlet>
        <servlet-name>springmvcwithxml</servlet-name>
        <!-- 这个类会把给定package（在{servlet-name}-servlet.xml文件中通过context:component-scan指定）内
        所有标记为@Controller的类作为请求处理的类。 -->
        <servlet-class>
            org.springframework.web.servlet.DispatcherServlet
        </servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>/WEB-INF/springmvcwithxml-servlet.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>
```
    注：init-param必须要放在load-on-startup前面。
    
* 在`context-param`里单独设置：<br>
```xml
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <!-- 默认情况会使用调用{servlet-name}-servlet.xml文件，所以下面这行可以写成：“<param-value></param-value> ”。 -->
        <param-value>/WEB-INF/springmvcwithxml-servlet.xml</param-value>
    </context-param>
```

## 部署到服务器上
把打包后的`.war`拷贝到服务器上tomcat的目录webapps里面，tomcat会自动把`.war`文件解包，然后服务就可以用了。

当用户更新`.war`包文件后，tomcat会自动重新解包。

## 运行网址
* <http://localhost:8080/springmvcwithxml/>
* <http://localhost:8080/springmvcwithxml/breezedeus>
* <http://localhost:8080/springmvcwithxml/hello>
* <http://localhost:8080/springmvcwithxml/two>
* <http://localhost:8080/springmvcwithxml/two/breezedeus>
* <http://localhost:8080/springmvcwithxml/two/hello>

上面网址里的`springmvcwithxml`，是在文件`pom.xml`里通过下面的行设定的：<br>
     `<finalName>springmvcwithxml</finalName>` <br>
其实也就是放到tomcat里webapps目录下的war包名称。

而在`springmvcwithxml`后的部分，则根据代码里Controller的设置进行路由。
在我们的例子中，`springmvcwithxml/`会调用`BaseController::welcome()`，
而`springmvcwithxml/breezedeus`则会调用`BaseController::welcomeName()`。


# References

* <http://www.mkyong.com/maven/how-to-create-a-web-application-project-with-maven/>
* <http://javahash.com/spring-4-mvc-hello-world-tutorial-full-example/>
* <http://docs.spring.io/spring-framework/docs/current/spring-framework-reference/html/mvc.html>