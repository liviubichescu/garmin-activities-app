package ro.garmin.activity.core.domain;


import lombok.*;
import ro.garmin.activity.core.domain.utils.MeasurementUnit;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class Distance {

    private double value;
    private MeasurementUnit measurementUnit;

}
