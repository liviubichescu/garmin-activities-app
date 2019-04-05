package ro.garmin.activity.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.garmin.activity.core.domain.activities.Activity;
import ro.garmin.activity.core.domain.activities.RunningActivity;
import ro.garmin.activity.core.service.ActivityService;
import ro.garmin.activity.web.converter.Converter;
import ro.garmin.activity.web.converter.RunningActivityConverter;
import ro.garmin.activity.web.dto.ActivityDto;
import ro.garmin.activity.web.dto.RunningActivityDTO;
import ro.garmin.activity.web.dto.SwimmingActivityDTO;

import java.util.ArrayList;
import java.util.List;


@RestController
public class RunningActivityController {

    @Autowired
    private ActivityService activityService;

    @Autowired
    private RunningActivityConverter activityConverter;


    @RequestMapping(value = "/runningActivities", method = RequestMethod.GET)
    List<Activity> getActivities() {

        List<Activity> activities = activityService.getAllActivities();

        return new ArrayList<>(activities);
    }

    @RequestMapping(value = "/runningActivities", method = RequestMethod.POST)
    RunningActivityDTO saveRunningActivity(@RequestBody RunningActivityDTO runningActivityDTO) {

        RunningActivity activity = activityConverter.convertDtoToModel(runningActivityDTO);

        activityService.save(activity);

        return activityConverter.convertModelToDto(activity);

    }



    @RequestMapping(value = "/runningActivities/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteActivity(@PathVariable("id") Long id){

        activityService.remove(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }



}
