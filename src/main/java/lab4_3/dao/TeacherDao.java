package lab4_3.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TeacherDao extends CrudRepository<Teacher, Integer> {

    @Query("SELECT t FROM Teacher t WHERE t.name ILIKE ('%' || ?1 || '%')" )
    List<Teacher> findByName(String subStr);

    // '||' is equal to 'CONCAT()'
    // ?1 is a parameter in method call (subStr)
}
