package ro.garmin.activity.web.converter;

import org.springframework.stereotype.Component;
import ro.garmin.activity.core.domain.activities.RunningActivity;
import ro.garmin.activity.core.domain.activities.SwimmingActivity;
import ro.garmin.activity.web.dto.RunningActivityDTO;
import ro.garmin.activity.web.dto.SwimmingActivityDTO;


@Component
public class SwimmingActivityConverter extends BaseConverter<SwimmingActivity, SwimmingActivityDTO> {


    @Override
    public SwimmingActivity convertDtoToModel(SwimmingActivityDTO dto) {
        SwimmingActivity activity = new SwimmingActivity(dto.getName(), dto.getType(), dto.getDateTime(),
                                                        dto.getDuration(),dto.getDistance(), dto.getStrokeType(),
                                                        dto.getSwolf(), dto.getNumberOfStrokes());
        activity.setId(dto.getId());

        return activity;
    }

    @Override
    public SwimmingActivityDTO convertModelToDto(SwimmingActivity swact) {
        
        SwimmingActivityDTO activityDto = new SwimmingActivityDTO(swact.getName(), swact.getType(), swact.getDateTime(),
                                                        swact.getDuration(),swact.getDistance(), swact.getStrokeType(),
                                                        swact.getSwolf(), swact.getNumberOfStrokes());
        
        activityDto.setId(swact.getId());
        return activityDto;
    }


}
