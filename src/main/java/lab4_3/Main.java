package lab4_3;

import lab4_3.dao.Teacher;
import lab4_3.dao.TeacherDao;
import lab4_3.dao.TeacherDaoConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

public class Main {

    public static void main (String[] args) {

        try(var context = new AnnotationConfigApplicationContext(TeacherDaoConfig.class)) {

            TeacherDao dao = context.getBean(TeacherDao.class);

            /* 1. findAll() */
            for (Teacher teacher : dao.findAll()) {
                System.out.println(teacher);
            }

            System.out.println("\n====================================\n");


            /* 2. findById */
            final int idToFind = 5;
            Optional<Teacher> t = dao.findById(idToFind);
            t.ifPresentOrElse(System.out::println,
                    ()->System.out.println("УЧИТЕЛЬ С id == "+ idToFind + " НЕ НАЙДЕН!"));

            System.out.println("\n====================================\n");


            /* 3. deleteById() */
//            final int idToDelete = 3;
//            dao.deleteById(idToDelete);
//
//            for (Teacher teacher : dao.findAll()) {
//                System.out.println(teacher);
//            }

            System.out.println("\n====================================\n");


            /* 4. update == save() */
//            dao.findById(4).ifPresent(c->{
//                c.setAddr("Балашиха, Ленина, 19");
//                dao.save(c);
//            });
//
//            for (Teacher teacher : dao.findAll()) {
//                System.out.println(teacher);
//            }

            System.out.println("\n====================================\n");


            /* 5. insert == save() */
//            Teacher newTeacher = new Teacher();
//            newTeacher.setName("Бульба Сумкин");
//            newTeacher.setAddr("Шир, Ленинского комсомола, 5");
//            newTeacher.setPhone("111-22-33");
//
//            dao.save(newTeacher);
//
//            for (Teacher teacher : dao.findAll()) {
//                System.out.println(teacher);
//            }

            System.out.println("\n====================================\n");


            /* 6. findByName() */
            final String nameSubStr = "кин";
            System.out.println(dao.findByName(nameSubStr));

            System.out.println("\n====================================\n");


        }
    }

}
