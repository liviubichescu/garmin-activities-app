package ro.garmin.activity.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.garmin.activity.core.domain.Activity;
import ro.garmin.activity.core.domain.Insight;
import ro.garmin.activity.core.domain.RunningActivity;
import ro.garmin.activity.core.repository.RunningRepository;

import java.util.List;


@Service
public class RunningActivityServiceImpl implements RunningActivityService {

    // logger for registering logs
    private static final Logger log = LoggerFactory.getLogger(RunningActivityServiceImpl.class);

    private final RunningRepository runningActivityRepository;

    private final MetricsService metricService;

    private final InsightService insightService;

    @Autowired
    public RunningActivityServiceImpl(RunningRepository runningActivityRepository, MetricsService metricService, InsightService insightService) {
        this.runningActivityRepository = runningActivityRepository;
        this.metricService = metricService;
        this.insightService = insightService;
    }

    @Override
    public void save(RunningActivity activity) {
        log.trace("save entered! activity -> " , activity);
        runningActivityRepository.save(activity);
        metricService.initializeAllMetrics();
        insightService.initializeAllInsights();
        log.trace("save finished!");
    }

    @Override
    public void remove(Long activityId) {
        log.trace("remove() entered -> ", activityId);
        runningActivityRepository.deleteById(activityId);
        log.trace("remove() finised!");
    }

    @Override
    public void update(Long activityId, Activity activity) {
        throw new RuntimeException("not yet implemented!");
    }

    @Override
    public List<RunningActivity> getAllRunningActivities() {
        log.trace("getAllRunningActivities() --- method entered");
        List<RunningActivity> result = runningActivityRepository.findAll();
        log.trace("getAllRunningActivities() finished: result= ", result);
        return result;
    }

}
