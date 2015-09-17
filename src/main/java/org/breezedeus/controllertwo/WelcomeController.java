package org.breezedeus.controllertwo;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {

    private static int counter = 0;
    private static final String VIEW_INDEX = "index";
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(WelcomeController.class);

    /**
     * TODO http://localhost:8080/springmvcwithxml/two/ 为什么末尾带斜杠就能解析到这里，而不带斜杠则会使用下面的函数进行解析？？？
     * @return 这里返回结果为index，所以接下来会去执行WEB-INF/pages/index.jsp文件。
     * 这个文件名的前缀和后缀是在WEB-INF/springmvcwithxml-servlet.xml文件中配置好的，中间的index就是来自于此函数的返回值。
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(ModelMap model) {

        model.addAttribute("message", "Welcome From ControllerTwo");
        model.addAttribute("counter", ++counter);
        logger.debug("[welcome] counter : {}", counter);

        // Spring uses InternalResourceViewResolver and return back index.jsp
        return VIEW_INDEX;

    }

    /**
     *
     * @param name 取值来自于用户输入的网址。比如用户输入“http://localhost:8080/springmvcwithxml/two/breezedeus”访问的话，
     *             name的取值就是“breezedeus”。
     * @param model
     * @return
     */
    @RequestMapping(value = "/{name:.+}", method = RequestMethod.GET)
    public String welcomeName(@PathVariable String name, ModelMap model) {

        model.addAttribute("message", "Welcome, " + name + " From 有名字");
        model.addAttribute("counter", ++counter);
        logger.debug("[welcomeName] counter : {}", counter);
        return VIEW_INDEX;

    }

}