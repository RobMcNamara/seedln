package com.seedln.service.service;

import com.seedln.service.model.Activity;
import com.seedln.service.repo.ActivityRepository;
import org.springframework.stereotype.Service;

@Service
public class ActivityManager {

    private ActivityRepository activityRepository;

    public ActivityManager(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public Activity checkIfAcitivityExistsAndSave(Activity activity){
        try {
            return  activityRepository.save(activity);
        } catch (Exception ex){
            System.out.printf(ex.getMessage());
        }
        return new Activity("bolox", "bolox");
    }
}
