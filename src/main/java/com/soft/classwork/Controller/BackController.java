package com.soft.classwork.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Yuukiiii
 * on 2018/3/15 14:59
 */

@RestController
public class BackController {
    @PostMapping(value = "/login")
    public String login(@Valid TUser tUser, BindingResult result) {
        if(!result.hasErrors())
            return "success: "+tUser.getUsername()+" "+tUser.getPassword();
        else
            return "failed: "+tUser.getUsername()+" "+tUser.getPassword();
    }
}
