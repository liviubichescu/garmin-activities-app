package ro.garmin.activity.web.dto;

import lombok.*;
import ro.garmin.activity.core.model.activities.Unit;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class CyclingActivityDto extends ActivityDto {

    private double avgSpeed;

    public CyclingActivityDto(String name, Date dateTime, long duration, long distance, double avgSpeed) {
        super(name, dateTime, duration, distance, Unit.CYCLING);
        this.avgSpeed = avgSpeed;
    }

}