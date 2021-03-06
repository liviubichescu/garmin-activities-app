package ro.garmin.activity.core.service;

import ro.garmin.activity.core.domain.Activity;
import ro.garmin.activity.core.domain.RunningActivity;
import ro.garmin.activity.core.domain.SwimmingActivity;

import java.util.List;

public interface SwimmingActivityService {

    /**
     * Save an activity
     * @param activity activity
     */
    void save(SwimmingActivity activity);

    /**
     * Remove an activity based on the id witch is unique
     * @param id activity id
     */
    void remove(Long id);

    /**
     * Updates a activity based on the id
     * @param activityId activity id from the db
     * @param activity the new activity
     */
    void update(Long activityId, Activity activity);

    /**
     * Retrieves all the domain from database
     * @return a list of domain
     */
    List<SwimmingActivity> getAllSwimmingActivities();
}
