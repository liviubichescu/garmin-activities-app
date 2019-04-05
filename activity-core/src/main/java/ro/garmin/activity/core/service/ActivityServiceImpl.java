package ro.garmin.activity.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.garmin.activity.core.domain.activities.Activity;
import ro.garmin.activity.core.repository.ActivityRepository;

import java.util.List;


@Service
public class ActivityServiceImpl implements ActivityService{

    // logger for registering logs
    private static final Logger log = LoggerFactory.getLogger(ActivityServiceImpl.class);

    @Autowired
    private ActivityRepository activityRepository;

    @Override
    public void save(Activity activity) {
        log.trace("save entered! activity -> " , activity);
        activityRepository.save(activity);
        log.trace("save finished!");
    }

    @Override
    public void remove(Long activityId) {
        log.trace("remove() entered -> ", activityId);
        activityRepository.deleteById(activityId);
        log.trace("remove() finised!");
    }

    @Override
    public void update(Long activityId, Activity activity) {
        throw new RuntimeException("not yet implemented!");
    }

    @Override
    public List<Activity> getAllActivities() {
        log.trace("getAllActivities() --- method entered");
        List<Activity> result = activityRepository.findAll();
        log.trace("getAllActivities() finished: result= ", result);
        return result;
    }

}
