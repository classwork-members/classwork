package com.soft.classwork.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * Created by Yuukiiii
 * on 2018/3/15 14:34
 */

@Controller
public class FrontController {

    @RequestMapping("/hello")
    public String helloHtml(){
        return "hello";
    }
}
