package ro.garmin.activity.core.domain.statistics;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ro.garmin.activity.core.domain.utils.StrokeType;

import javax.persistence.Entity;


@Entity
//@NoArgsConstructor
//@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SwimmingMetrics extends Metrics {

    private float avgSwolf;
    private StrokeType favouriteStyle;

}
