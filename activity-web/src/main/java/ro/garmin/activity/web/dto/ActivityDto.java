package ro.garmin.activity.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ActivityDto extends BaseDto {

    private String name;
    private Date dateTime;
    private long duration;
    private long distance;

    @Override
    public String toString() {
        return "ActivityDto{" +
                "name='" + name + '\'' +
                ", dateTime=" + dateTime +
                ", duration=" + duration +
                ", distance=" + distance +
                '}'+ super.toString();
    }

}