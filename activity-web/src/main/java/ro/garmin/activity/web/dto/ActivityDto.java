package ro.garmin.activity.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import ro.garmin.activity.core.domain.enumsType.ActivityType;
import ro.garmin.activity.core.domain.Distance;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public abstract class ActivityDto extends BaseDto {

    protected String name;
    protected ActivityType type;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    protected Date dateTime;
    protected long duration;
    protected Distance distance;


}