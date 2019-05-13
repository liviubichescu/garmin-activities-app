package ro.garmin.activity.core.domain;

import lombok.*;
import ro.garmin.activity.core.domain.enumsType.ActivityType;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "running_act")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
//@DiscriminatorValue("RUNNING")
public class RunningActivity extends Activity {

    private Integer elevation;
    // distance/elevation
    private Double slope;
    // minutes/km
    private Double pace; // in cate minute parcurgi un km

//    @Builder
    public RunningActivity(String name, ActivityType type, Date dateTime, long duration, Distance distance, Integer elevation, Double slope, Double pace) {
        super(name, type, dateTime, duration, distance);
        this.elevation = elevation;
        this.slope = slope;
        this.pace = pace;
    }
}
