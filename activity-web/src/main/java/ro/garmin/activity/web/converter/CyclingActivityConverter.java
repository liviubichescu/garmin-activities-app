package ro.garmin.activity.web.converter;


import org.springframework.stereotype.Component;
import ro.garmin.activity.core.model.activities.CyclingActivity;
import ro.garmin.activity.core.model.activities.Unit;
import ro.garmin.activity.web.dto.CyclingActivityDto;


@Component
public class CyclingActivityConverter extends BaseConverter<CyclingActivity, CyclingActivityDto> {

    @Override
    public CyclingActivity convertDtoToModel(CyclingActivityDto dto) {
        CyclingActivity activity = new CyclingActivity(dto.getName(), dto.getDateTime(), dto.getDuration(), dto.getDistance(), dto.getAvgSpeed());
        activity.setType(Unit.CYCLING);
        activity.setId(dto.getId());

        return activity;
    }

    @Override
    public CyclingActivityDto convertModelToDto(CyclingActivity cyclingActivity) {
        CyclingActivityDto activityDto = new CyclingActivityDto(cyclingActivity.getName(),
                                                                cyclingActivity.getDateTime(),
                                                                cyclingActivity.getDuration(),
                                                                cyclingActivity.getDistance(),
                                                                cyclingActivity.getAvgSpeed());
        activityDto.setType(Unit.CYCLING);
        activityDto.setId(cyclingActivity.getId());
        return activityDto;
    }

}
