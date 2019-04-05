package ro.garmin.activity.web.dto;

import lombok.*;
import ro.garmin.activity.core.domain.Distance;
import ro.garmin.activity.core.domain.utils.ActivityType;
import ro.garmin.activity.core.domain.utils.StrokeType;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class SwimmingActivityDTO extends ActivityDto {

    private StrokeType strokeType;
    // duration(seconds) + number of strokes
    private Integer swolf;
    private Integer numberOfStrokes;

    @Builder
    public SwimmingActivityDTO(String name, ActivityType type, Date dateTime, long duration, Distance distance, StrokeType strokeType, Integer swolf, Integer numberOfStrokes) {
        super(name, type, dateTime, duration, distance);
        this.strokeType = strokeType;
        this.swolf = swolf;
        this.numberOfStrokes = numberOfStrokes;
    }
}