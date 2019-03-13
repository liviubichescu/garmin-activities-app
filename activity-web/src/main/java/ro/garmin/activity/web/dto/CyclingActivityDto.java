package ro.garmin.activity.web.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class CyclingActivityDto extends ActivityDto {

//    private String name;
//    private Date dateTime;
//    private long duration;
//    private long distance;
    private double avgSpeed;

    public CyclingActivityDto(String name, Date dateTime, long duration, long distance, double avgSpeed) {
        super(name, dateTime, duration, distance);
        this.avgSpeed = avgSpeed;
    }

//    @Override
//    public String toString() {
//        return "CyclingActivityDto{" +
//                "name='" + name + '\'' +
//                ", dateTime=" + dateTime +
//                ", duration=" + duration +
//                ", distance=" + distance +
//                ", avgSpeed=" + avgSpeed +
//                '}'+ super.toString();
//    }
}