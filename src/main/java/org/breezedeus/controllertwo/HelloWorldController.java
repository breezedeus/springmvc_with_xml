package org.breezedeus.controllertwo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    /**
     * 调用方式：“/hello?name=breezedeus”
     * @param name Http请求里传入的参数名称
     * @param model
     * @return
     */
    @RequestMapping("/hello")
    public String hello(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
                        Model model) {

        model.addAttribute("name", name + " From ControllerTwo");
        //returns the view name
        return "helloworld";

    }

}
