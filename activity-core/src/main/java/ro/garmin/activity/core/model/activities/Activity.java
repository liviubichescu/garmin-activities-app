package ro.garmin.activity.core.model.activities;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

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

    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateTime;
    private long duration;
    private long distance;
    private Unit type;

}
