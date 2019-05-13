package ro.garmin.activity.core.domain;

import lombok.*;
import ro.garmin.activity.core.domain.enumsType.InsightsType;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "insight")
@Getter
@Setter
@ToString(callSuper = true)
public class Insight extends BaseEntity<Long>{

    private String message;
    private InsightsType type;

    public Insight(String message) {
        this.message = message;
    }
}
