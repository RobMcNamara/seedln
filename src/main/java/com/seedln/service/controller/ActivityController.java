package com.seedln.service.controller;

import com.seedln.service.model.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/activities")
public class ActivityController {


    @RequestMapping(method = RequestMethod.POST)
    public String createActivity(@RequestBody Activity activity){
        return "creating "+ activity.getName();
    }
}
