package ro.garmin.activity.web.dto;

import lombok.*;
import ro.garmin.activity.core.domain.enumsType.ActivityType;
import ro.garmin.activity.core.domain.Distance;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class RunningActivityDTO extends ActivityDto {

    private Integer elevation;
    // distance/elevation
    private Double slope;
    // minutes/km
    private Double pace; // in cate minute parcurgi un km

    @Builder
    public RunningActivityDTO(String name, ActivityType type, Date dateTime, long duration, Distance distance, Integer elevation, Double slope, Double pace) {
        super(name, type, dateTime, duration, distance);
        this.elevation = elevation;
        this.slope = slope;
        this.pace = pace;
    }


}