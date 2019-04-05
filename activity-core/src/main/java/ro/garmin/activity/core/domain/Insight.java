package ro.garmin.activity.core.domain;

import lombok.*;
import ro.garmin.activity.core.domain.utils.InsightsType;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class Insight {

    private String message;
    private InsightsType type;

    public Insight(String message) {
        this.message = message;
    }
}
