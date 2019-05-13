package ro.garmin.activity.core.domain;


import lombok.*;
import ro.garmin.activity.core.domain.enumsType.MeasurementUnit;

import javax.persistence.Embeddable;

//@Entity
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class Distance {

    private double value;
    private MeasurementUnit measurementUnit;

}
