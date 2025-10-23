package dbSpringData;

import dbSpringData.dao.Course;
import dbSpringData.dao.CourseDao;
import dbSpringData.dao.CourseDaoConfig;
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

//            System.out.println(dao.findById(2));
//
//            System.out.println("\n====================================\n");
//
//            dao.delete(2);
//
//            System.out.println("\n====================================\n");

//            Course webAsp = dao.findById(7);
//            webAsp.setTitle("Developing web app with ASP.NET Core MVC 3");
//            dao.update(webAsp);
//
//            System.out.println("\n====================================\n");
//
//            Course spring = new Course();
//            spring.setTitle("Spring Base 3");
//            spring.setLength(40);
//            spring.setDescription("Цель нашего курса – освоить Spring Core и осветить преимущества использования современных возможностей Spring.");
//
//            dao.insert(spring);
//
//            for (Course course : dao.findAll()) {
//                System.out.println(course);
//            }
//
//            System.out.println("\n====================================\n");

            System.out.println(dao.findByTitle("Web"));


        }

    }

}
