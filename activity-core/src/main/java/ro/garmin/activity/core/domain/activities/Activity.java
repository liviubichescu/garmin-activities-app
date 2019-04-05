package ro.garmin.activity.core.domain.activities;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import ro.garmin.activity.core.domain.BaseEntity;
import ro.garmin.activity.core.domain.Distance;
import ro.garmin.activity.core.domain.utils.ActivityType;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
//@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "TYPE")
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Activity extends BaseEntity<Long> {

    protected String name;
    protected ActivityType type;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    protected Date dateTime;
    protected long duration;
    protected Distance distance;


}
