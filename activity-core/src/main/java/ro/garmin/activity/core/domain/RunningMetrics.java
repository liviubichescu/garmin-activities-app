package ro.garmin.activity.core.domain;

import lombok.*;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RunningMetrics extends Metrics {

    private double averagePace;

}
