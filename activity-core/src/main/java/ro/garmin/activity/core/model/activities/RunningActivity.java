package ro.garmin.activity.core.model.activities;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@DiscriminatorValue("RUNNING")
public class RunningActivity extends Activity {

    private long avgPace;

    public RunningActivity(String name, Date dateTime, long duration, long distance, long avgPace) {
        super(name,dateTime,duration,distance,Unit.RUNNING);
        this.avgPace = avgPace;
    }

}
