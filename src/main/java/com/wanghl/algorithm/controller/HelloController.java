package com.wanghl.algorithm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

    private static final String INDEX = "form";

    @RequestMapping(value = "form",method = RequestMethod.GET)
    public String getIndex(){
        return INDEX;
    }

}
