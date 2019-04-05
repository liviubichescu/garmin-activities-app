package ro.garmin.activity.core.domain.statistics;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ro.garmin.activity.core.domain.utils.ActivityType;

import javax.persistence.Entity;

/*
 * Inregistreaza metrice pentru toate activitatile de un anumit tip
 */

@Entity
//@NoArgsConstructor
//@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public abstract class Metrics {

    protected ActivityType activityType; // tip de activitate
    protected int activitiesCount; // cate activitati avem
    protected double averageSpeed; // viteza medie


}
