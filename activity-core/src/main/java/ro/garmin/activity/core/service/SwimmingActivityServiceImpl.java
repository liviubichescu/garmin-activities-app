package ro.garmin.activity.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.garmin.activity.core.domain.Activity;
import ro.garmin.activity.core.domain.RunningActivity;
import ro.garmin.activity.core.domain.SwimmingActivity;
import ro.garmin.activity.core.repository.SwimmingRepository;

import java.util.List;


@Service
public class SwimmingActivityServiceImpl implements SwimmingActivityService {

    // logger for registering logs
    private static final Logger log = LoggerFactory.getLogger(SwimmingActivityServiceImpl.class);

    private final SwimmingRepository swimmingRepository;

    @Autowired
    public SwimmingActivityServiceImpl(SwimmingRepository swimmingRepository) {
        this.swimmingRepository = swimmingRepository;
    }

    @Override
    public void save(SwimmingActivity activity) {
        log.trace("save entered! activity -> " , activity);
        swimmingRepository.save(activity);
        log.trace("save finished!");
    }

    @Override
    public void remove(Long activityId) {
        log.trace("remove() entered -> ", activityId);
        swimmingRepository.deleteById(activityId);
        log.trace("remove() finised!");
    }

    @Override
    public void update(Long activityId, Activity activity) {
        throw new RuntimeException("not yet implemented!");
    }

    @Override
    public List<SwimmingActivity> getAllSwimmingActivities() {
        log.trace("getAllRunningActivities() --- method entered");
        List<SwimmingActivity> result = swimmingRepository.findAll();
        log.trace("getAllRunningActivities() finished: result= ", result);
        return result;
    }

}
