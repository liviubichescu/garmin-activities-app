package ro.garmin.activity.core.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import ro.garmin.activity.core.domain.enumsType.ActivityType;

import javax.persistence.Embedded;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.util.Date;


@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
//@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "TYPE")
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@Component
public abstract class Activity extends BaseEntity<Long> {

    protected String name;
    protected ActivityType type;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    protected Date dateTime;
    protected long duration;
    @Embedded
    protected Distance distance;

}
