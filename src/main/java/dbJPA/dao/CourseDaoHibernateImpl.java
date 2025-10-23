package dbJPA.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository("courseDao")
public class CourseDaoHibernateImpl implements CourseDao {

    private SessionFactory sessionFactory;

    // ==============================

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Value("#{sessionFactory}")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // ==============================

    // good to use this annotation if we don`t change anything in db
    @Transactional(readOnly = true)
    @Override
    public Course findById(int id) {

        return getSessionFactory().getCurrentSession()
                .find(Course.class, id);
//                .byId(Course.class).load(id);  // DEPRECATED METHOD !!! use find() instead
    }

    /* these methods work only with @NaturalId annotation that doesn`t work with @Id field */
//                .bySimpleNaturalId(Course.class).load();
//
//                .byNaturalId(Course.class)
//                .using("id", id)
//                .load();

    @Transactional(readOnly = true)
    @Override
    public List<Course> findAll() {
        return getSessionFactory().getCurrentSession()
                .createSelectionQuery("from Course c", Course.class).list();  // HQL
    }

    @Transactional(readOnly = true)
    @Override
    public List<Course> findByTitle(String title) {
        return getSessionFactory().getCurrentSession()
                .createSelectionQuery("from Course c where c.title LIKE :title", Course.class)
                .setParameter("title", "%"+title+"%")
                .list();
    }
    /* NOTE: we can still use case-insensitive ILIKE in our HQL query to PostgreSql db */

    @Override
    public void insert(Course course) {
        /* save() method from example is deprecated and deleted, use persist() instead */
        getSessionFactory().getCurrentSession().persist(course);
    }

    @Override
    public void update(Course course) {
        /* update() method from example is deprecated and deleted, use merge() instead */
        getSessionFactory().getCurrentSession().merge(course);
    }

    @Override
    public void delete(int id) {
        Course c = new Course();
        c.setId(id);
        getSessionFactory().getCurrentSession().remove(c);  // "fake" object
    }
}
