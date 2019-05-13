package ro.garmin.activity.web.controller;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.garmin.activity.core.domain.Activity;
import ro.garmin.activity.core.domain.RunningActivity;
import ro.garmin.activity.core.service.RunningActivityService;
import ro.garmin.activity.web.converter.RunningActivityConverter;
import ro.garmin.activity.web.dto.RunningActivityDTO;

import java.util.ArrayList;
import java.util.List;


@RestController
public class RunningActivityController {

//    private static final Logger log = LoggerFactory.getLogger(RunningActivityController.class);

    private final RunningActivityService runningActivityService;

    private final RunningActivityConverter activityConverter;

    @Autowired
    public RunningActivityController(RunningActivityService runningActivityService, RunningActivityConverter activityConverter) {
        this.runningActivityService = runningActivityService;
        this.activityConverter = activityConverter;
    }


    @RequestMapping(value = "/runningActivities", method = RequestMethod.GET)
    List<Activity> getActivities() {
//        log.trace("getStudents");
        List<RunningActivity> activities = runningActivityService.getAllRunningActivities();
//        log.trace("getStudents: students={}", activities);

        return new ArrayList<>(activities);
    }

    @RequestMapping(value = "/runningActivities", method = RequestMethod.POST)
    RunningActivityDTO saveRunningActivity(@RequestBody RunningActivityDTO runningActivityDTO) {

        RunningActivity activity = activityConverter.convertDtoToModel(runningActivityDTO);

        runningActivityService.save(activity);

        return activityConverter.convertModelToDto(activity);

    }

    @RequestMapping(value = "/runningActivities/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteActivity(@PathVariable("id") Long id){

        runningActivityService.remove(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }



}
