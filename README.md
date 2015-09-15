
# Maven使用

## 生成Web应用
<code>
$ mvn archetype:generate -DgroupId={project-packaging}
	-DartifactId={project-name}
	-DarchetypeArtifactId=maven-archetype-webapp
	-DinteractiveMode=false
</code>

例如：<br>
<code>
$ mvn archetype:generate -DgroupId=org.breezedeus
	-DartifactId=springmvcwithxml
	-DarchetypeArtifactId=maven-archetype-webapp
	-DinteractiveMode=false
</code>


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

## 部署到服务器上
把打包后的`.war`拷贝到服务器上tomcat的目录webapps里面，tomcat会自动把`.war`文件解包，然后服务就可以用了。

当用户更新`.war`包文件后，tomcat会自动重新解包。

## 运行网址
* <http://localhost:8080/springmvcwithxml/>
* <http://localhost:8080/springmvcwithxml/breezedeus>

上面网址里的`springmvcwithxml`，是在文件`pom.xml`里通过下面的行设定的：<br>
     `<finalName>springmvcwithxml</finalName>` <br>
其实也就是放到tomcat里webapps目录下的war包名称。

而在`springmvcwithxml`后的部分，则根据代码里Controller的设置进行路由。
在我们的例子中，`springmvcwithxml/`会调用`BaseController::welcome()`，
而`springmvcwithxml/breezedeus`则会调用`BaseController::welcomeName()`。