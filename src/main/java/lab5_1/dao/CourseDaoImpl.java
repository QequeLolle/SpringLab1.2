package lab5_1.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements CourseDaoCustomized{

    @PersistenceContext
    private EntityManager em;

    @Transactional(isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRED,
            readOnly = true)
    @Override
    public double medianaLength() {
        List<Integer> l = em.createQuery("SELECT c.length FROM Course c ORDER BY c.length", Integer.class).getResultList();

        if (l.size() % 2 == 1) {
            return l.get(l.size() / 2);
        }
        else {
            return (l.get(l.size() / 2 - 1) + l.get(l.size() / 2))/ 2d;
        }
    }

    @Transactional(isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRED,
            readOnly = true)
    @Override
    public double averageLength() {
        return em.createQuery("SELECT AVG(c.length) FROM Course c", Double.class).getSingleResult();
    }

    /* option 1 */
//    @Transactional(isolation = Isolation.SERIALIZABLE,
//            propagation = Propagation.REQUIRED,
//            readOnly = true)
//    @Override
//    public List<Double> getAverageAndMedianaLength() {
//        List<Double> l = new ArrayList<>();
//        l.add(averageLength());
//        l.add(medianaLength());
//
//        return l;
//    }

    /* option 2 */
    @Transactional(isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRED,
            readOnly = true)
    @Override
    public List<Double> getAverageAndMedianaLength() {

        List<Integer> l = em.createQuery("SELECT c.length FROM Course c ORDER BY c.length", Integer.class).getResultList();

        double mediana;
        if (l.size() % 2 == 1) {
            mediana = l.get(l.size() / 2);
        }
        else {
            mediana = (l.get(l.size() / 2 - 1) + l.get(l.size() / 2))/ 2d;
        }

        double average = l.stream().mapToInt(c->c).average().orElse(0.0);

        List<Double> am = new ArrayList<>();
        am.add(average);
        am.add(mediana);

        return am;
    }


//    @Override
//    public averageMediana getAverageAndMedianaLength() {
//        return List.of();
//    }


}
