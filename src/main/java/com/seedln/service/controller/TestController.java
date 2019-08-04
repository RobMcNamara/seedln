package com.seedln.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/fun")
public class TestController {

    @RequestMapping(value = "/bob", method = RequestMethod.GET)
    public String index(){
        return "Hi";
    }
}
