package ro.garmin.activity.web.dto;

import lombok.*;
import ro.garmin.activity.core.model.activities.Unit;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class ActivityDto extends BaseDto {

    private String name;
    private Date dateTime;
    private long duration;
    private long distance;
    private Unit type;


}