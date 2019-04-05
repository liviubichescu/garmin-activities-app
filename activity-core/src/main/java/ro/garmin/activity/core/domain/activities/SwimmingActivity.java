package ro.garmin.activity.core.domain.activities;

import lombok.*;
import ro.garmin.activity.core.domain.Distance;
import ro.garmin.activity.core.domain.utils.ActivityType;
import ro.garmin.activity.core.domain.utils.StrokeType;

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

public class SwimmingActivity extends Activity {

    private StrokeType strokeType;
    // duration(seconds) + number of strokes
    private Integer swolf;
    private Integer numberOfStrokes;

    @Builder
    public SwimmingActivity(String name, ActivityType type, Date dateTime, long duration, Distance distance, StrokeType strokeType, Integer swolf, Integer numberOfStrokes) {
        super(name, type, dateTime, duration, distance);
        this.strokeType = strokeType;
        this.swolf = swolf;
        this.numberOfStrokes = numberOfStrokes;
    }

}
