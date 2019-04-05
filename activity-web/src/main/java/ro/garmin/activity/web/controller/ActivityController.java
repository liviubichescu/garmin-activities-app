//package ro.garmin.activity.web.controller;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import ro.garmin.activity.core.model.activities.Activity;
//import ro.garmin.activity.core.service.ActivityService;
//import ro.garmin.activity.web.converter.ActivityConverter;
//import ro.garmin.activity.web.dto.ActivityDto;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//public class ActivityController {
//
//    private static final Logger log = LoggerFactory.getLogger(ActivityController.class);
//
//    @Autowired
//    private ActivityService activityService;
//
//    @Autowired
//    private ActivityConverter activityConverter;
//
//
//    @RequestMapping(value = "/activities", method = RequestMethod.GET)
//    List<Activity> getActivities() {
//
//        List<Activity> activities = activityService.getAllActivities();
//
//        return new ArrayList<>(activities);
//    }
//
//
//    @RequestMapping(value = {"/activities"}, method = RequestMethod.POST)
//    ActivityDto saveActivity(@RequestBody ActivityDto activityDto) {
//
//        log.trace("saveActivity: activityDto={}", activityDto);
//
//        Activity activity = activityConverter.convertDtoToModel(activityDto);
//
//        activityService.save(activity);
//
//        return activityConverter.convertModelToDto(activity);
//
//    }
//
//
//    @RequestMapping(value = "/activities/{id}", method = RequestMethod.DELETE)
//    ResponseEntity<?> deleteActivity(@PathVariable("id") Long id){
//
//        activityService.remove(id);
//
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//
//
//}
