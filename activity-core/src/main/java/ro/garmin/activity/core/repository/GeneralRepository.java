package ro.garmin.activity.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;
import ro.garmin.activity.core.model.activities.BaseEntity;

import java.io.Serializable;

@NoRepositoryBean
@Transactional
public interface GeneralRepository<T extends BaseEntity<Long>, ID extends Serializable> extends JpaRepository<T, ID> {

}