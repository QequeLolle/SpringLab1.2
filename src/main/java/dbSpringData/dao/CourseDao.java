package dbSpringData.dao;

import org.hibernate.boot.model.relational.Sequence;
import org.springframework.data.repository.CrudRepository;

import java.sql.Types;

public interface CourseDao extends CrudRepository<Course, Integer> {

}
