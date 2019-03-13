package ro.garmin.activity.core.model;

import lombok.*;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SwimmingActivity extends Activity {

    private enum strokeType{
        Butterfly, Breaststroke,Backstroke;
    }
    private int swolf; //SWOLF is the combination of your stroke count and time taken in the water
    private long avgPaceSwim;


}
