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
@DiscriminatorValue("CYCLING")
public class CyclingActivity extends Activity {

    private double avgSpeed;

    public CyclingActivity(String name, Date dateTime, long duration, long distance, double avgSpeed) {
        super(name, dateTime, duration, distance, Unit.CYCLING);
        this.avgSpeed = avgSpeed;
    }
    
}
