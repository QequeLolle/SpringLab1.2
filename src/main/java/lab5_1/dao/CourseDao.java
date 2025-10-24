package lab5_1.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CourseDao extends CrudRepository<Course, Integer>, CourseDaoCustomized {

    /* autogenerate method with spring */
//    @Query("SELECT AVG(c.length) FROM Course c")
//    double averageLength();

    /* autogenerate method with spring */
    /* we don`t need to implement it, because we wrote an JPQL for this method */
    @Query("SELECT c FROM Course c WHERE c.title LIKE CONCAT('%', :title, '%')")
    Iterable<Course> findByTitle(@Param("title") String title);
}
