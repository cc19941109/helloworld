package com.neo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpRequest;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
    @RequestMapping("/hello")
    public String index() {
        return "Hello World xx";
    }
    @RequestMapping(value = "/home",method = RequestMethod.GET)
    private void backgroud(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse){
       
       
    }
    
}