package lab5_1;

import lab5_1.dao.Course;
import lab5_1.dao.CourseDao;
import lab5_1.dao.CourseDaoConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main (String[] args) {

        // try with resources
        try(var context = new AnnotationConfigApplicationContext(CourseDaoConfig.class)) {

            CourseDao dao = context.getBean(CourseDao.class);

            for (Course course : dao.findAll()) {
                System.out.println(course);
            }

            System.out.println("\n====================================\n");

//            System.out.println(dao.findById(3));  // returns Optional !!!
//
//            Optional<Course> c = dao.findById(3);
//            c.ifPresentOrElse(System.out::println, ()->System.out.println("Курс не найден"));

            System.out.println("\n====================================\n");

            /* replaced dao.delete() */
//            dao.deleteById(8);

            System.out.println("\n====================================\n");

            /* this update part doesn`t work */
//            Course webAsp = dao.findById(7);
//            webAsp.setTitle("Developing web app with ASP.NET Core MVC 3");
//            /* replaced dao.update(); */
//            dao.save(webAsp);

            /* new working one */
//            dao.findById(7).ifPresent(c->{
//                c.setTitle("Developing web app with ASP.NET Core MVC 4");
//                dao.save(c);
//            });


            System.out.println("\n====================================\n");

//            Course spring = new Course();
//            spring.setTitle("Spring Base 3");
//            spring.setLength(40);
//            spring.setDescription("Цель нашего курса – освоить Spring Core и осветить преимущества использования современных возможностей Spring.");
//
//            /* replaced dao.insert();*/
//            dao.save(spring);

            for (Course course : dao.findAll()) {
                System.out.println(course);
            }

            System.out.println("\n====================================\n");

            /* this findByTitle part doesn`t work, there is no such standard method in CrudRepository */
//            System.out.println(dao.findByTitle("Web"));


        }

    }

}
