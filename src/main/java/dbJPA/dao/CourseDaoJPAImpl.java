package dbJPA.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository("courseDao")
public class CourseDaoJPAImpl implements CourseDao {

    @PersistenceContext
    private EntityManager em;

    // ==============================

    @Transactional(readOnly = true)
    @Override
    public Course findById(int id) {
        return em.find(Course.class, id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Course> findAll() {
        return em.createQuery("select c from Course c", Course.class).getResultList();  // JPQL
    }

    @Transactional(readOnly = true)
    @Override
    public List<Course> findByTitle(String title) {
        return em.createQuery("select c from Course c where c.title LIKE :title", Course.class)
                .setParameter("title", "%"+title+"%")
                .getResultList();
    }
    /* NOTE: we can still use case-insensitive ILIKE in our HQL query to PostgreSql db */

    @Override
    public void insert(Course course) {

        em.persist(course);
    }

    @Override
    public void update(Course course) {

        em.merge(course);
    }

    @Override
    public void delete(int id) {

        em.remove(findById(id));
    }
}
