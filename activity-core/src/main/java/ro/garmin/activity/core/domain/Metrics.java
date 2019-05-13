package ro.garmin.activity.core.domain;

import lombok.*;
import ro.garmin.activity.core.domain.enumsType.ActivityType;

import javax.persistence.Entity;
import javax.persistence.Table;

/*
 * Inregistreaza metrice pentru toate activitatile de un anumit tip
 */

@Entity
//@AllArgsConstructor
//@NoArgsConstructor
@Table(name = "metrics")
@Getter
@Setter
@ToString(callSuper = true)
public class Metrics extends BaseEntity<Long> {

    protected ActivityType activityType; // tip de activitate
    protected int activitiesCount; // cate activitati avem
    protected double averageSpeed; // viteza medie


}
