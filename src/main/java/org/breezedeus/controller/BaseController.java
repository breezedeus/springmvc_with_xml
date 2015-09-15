package org.breezedeus.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BaseController {

    private static int counter = 0;
    private static final String VIEW_INDEX = "index";
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(BaseController.class);

    /**
     * @return 这里返回结果为index，所以接下来会去执行WEB-INF/pages/index.jsp文件。
     * 这个文件名的前缀和后缀是在WEB-INF/springmvcwithxml-servlet.xml文件中配置好的，中间的index就是来自于此函数的返回值。
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(ModelMap model) {

        model.addAttribute("message", "Welcome");
        model.addAttribute("counter", ++counter);
        logger.debug("[welcome] counter : {}", counter);

        // Spring uses InternalResourceViewResolver and return back index.jsp
        return VIEW_INDEX;

    }

    /**
     *
     * @param name 取值来自于用户输入的网址。比如用户输入“http://localhost:8080/springmvcwithxml/breezedeus”访问的话，
     *             name的取值就是“breezedeus”。
     * @param model
     * @return
     */
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String welcomeName(@PathVariable String name, ModelMap model) {

        model.addAttribute("message", "Welcome, " + name);
        model.addAttribute("counter", ++counter);
        logger.debug("[welcomeName] counter : {}", counter);
        return VIEW_INDEX;

    }

}