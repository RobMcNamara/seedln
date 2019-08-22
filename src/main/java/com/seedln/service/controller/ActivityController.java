package com.seedln.service.controller;

import com.seedln.service.model.Activity;
import com.seedln.service.service.ActivityManager;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/activities")
public class ActivityController {

    private ActivityManager activityManager;

    public ActivityController(ActivityManager activityManager) {
        this.activityManager = activityManager;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createActivity(@RequestBody Activity activity) {
        Activity result = activityManager.checkIfAcitivityExistsAndSave(activity);
        return result.getTitle();
    }
}
