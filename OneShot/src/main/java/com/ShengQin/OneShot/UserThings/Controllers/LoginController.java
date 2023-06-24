package com.ShengQin.OneShot.UserThings.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {



    @GetMapping("/user/login")
    public String test(){
        return "hello post Man";
    }
}
