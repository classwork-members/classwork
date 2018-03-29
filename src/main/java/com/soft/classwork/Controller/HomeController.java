package com.soft.classwork.Controller;

import com.soft.classwork.model.Msg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class HomeController {
    private final static Logger logger = LoggerFactory.getLogger(HomeController.class);
    @RequestMapping("/")
    public String index(Model model) {
        logger.debug("______________arrive in HomeController____________________");
        Msg msg = new Msg("测试标题", "测试内容", "额外信息，只对管理员显示");
        model.addAttribute("msg", msg);
        return "index";
    }
}