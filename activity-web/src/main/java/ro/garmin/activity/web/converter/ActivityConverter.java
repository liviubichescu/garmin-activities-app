package ro.garmin.activity.web.converter;


import org.springframework.stereotype.Component;
import ro.garmin.activity.core.model.Activity;
import ro.garmin.activity.web.dto.ActivityDto;


@Component
public class ActivityConverter extends BaseConverter<Activity, ActivityDto> {

    @Override
    public Activity convertDtoToModel(ActivityDto dto) {
        Activity activity = new Activity(dto.getName(),dto.getDateTime(),dto.getDuration(),dto.getDistance());
        activity.setId(dto.getId());

        return activity;
    }

    @Override
    public ActivityDto convertModelToDto(Activity activity) {
        ActivityDto dto = new ActivityDto(activity.getName(), activity.getDateTime(),activity.getDuration(),activity.getDistance());
        dto.setId(activity.getId());
        return dto;
    }

}
