package ro.garmin.activity.core.service;

import ro.garmin.activity.core.model.Activity;

import java.util.List;

public interface ActivityService {

    /**
     * Save an activity
     * @param activity activity
     */
    void save(Activity activity);

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
     * Retrieves all the activities from database
     * @return a list of activities
     */
    List<Activity> getAllActivities();
}
