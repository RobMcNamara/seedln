package com.seedln.service.controller;

import com.seedln.service.kafka.Publisher;
import com.seedln.service.model.Activity;
import com.seedln.service.service.ActivityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/activities")
public class ActivityController {

    private ActivityManager activityManager;

    @Autowired
    private Publisher publisher;

    public ActivityController(ActivityManager activityManager) {
        this.activityManager = activityManager;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Activity createActivity(@RequestBody Activity activity) {
        Activity result = activityManager.checkIfAcitivityExistsAndSave(activity);
        publisher.send("activity", result.getTitle());
        return result;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Activity> getActivities(){
        return activityManager.getActivities();
    }
}
