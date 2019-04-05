package ro.garmin.activity.web.converter;


import org.springframework.stereotype.Component;
import ro.garmin.activity.core.domain.activities.RunningActivity;
import ro.garmin.activity.web.dto.RunningActivityDTO;


@Component
public class RunningActivityConverter extends BaseConverter<RunningActivity, RunningActivityDTO> {


    @Override
    public RunningActivity convertDtoToModel(RunningActivityDTO dto) {
        RunningActivity activity = new RunningActivity(dto.getName(), dto.getType(), dto.getDateTime(), dto.getDuration(),
                dto.getDistance(), dto.getElevation(), dto.getSlope(), dto.getPace());
        activity.setId(dto.getId());

        return activity;
    }

    @Override
    public RunningActivityDTO convertModelToDto(RunningActivity runningActivity) {
        RunningActivityDTO activityDto = new RunningActivityDTO(runningActivity.getName(), runningActivity.getType(), runningActivity.getDateTime(),
                                                        runningActivity.getDuration(), runningActivity.getDistance(), runningActivity.getElevation(),
                                                        runningActivity.getSlope(), runningActivity.getPace());
        activityDto.setId(runningActivity.getId());
        return activityDto;
    }


}
