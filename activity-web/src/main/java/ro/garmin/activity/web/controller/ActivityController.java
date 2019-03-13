package ro.garmin.activity.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.garmin.activity.core.model.Activity;
import ro.garmin.activity.core.model.CyclingActivity;
import ro.garmin.activity.core.service.ActivityService;
import ro.garmin.activity.web.converter.ActivityConverter;
import ro.garmin.activity.web.converter.CyclingActivityConverter;
import ro.garmin.activity.web.dto.ActivityDto;
import ro.garmin.activity.web.dto.CyclingActivityDto;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @Autowired
    private ActivityConverter activityConverter;

    @Autowired
    private CyclingActivityConverter cyclingActivityConverter;


    @RequestMapping(value = "/activities", method = RequestMethod.GET)
    List<Activity> getActivities() {

        List<Activity> activities = activityService.getAllActivities();

        return new ArrayList<>(activities);
    }


    @RequestMapping(value = {"/activities"}, method = RequestMethod.POST)
    ActivityDto saveActivity(@RequestBody ActivityDto activityDto) {

        Activity activity = activityConverter.convertDtoToModel(activityDto);

        activityService.save(activity);

        return activityConverter.convertModelToDto(activity);

    }

    @RequestMapping(value = "/cyclingActivities", method = RequestMethod.POST)
    CyclingActivityDto saveCyclingActivity(@RequestBody CyclingActivityDto cyclingActivityDto) {

        CyclingActivity activity = cyclingActivityConverter.convertDtoToModel(cyclingActivityDto);

        activityService.save(activity);

        return cyclingActivityConverter.convertModelToDto(activity);

    }



    @RequestMapping(value = "/activities/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteActivity(@PathVariable("id") Long id){

        activityService.remove(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }



}
