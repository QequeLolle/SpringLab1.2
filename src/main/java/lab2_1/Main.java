package lab2_1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main (String[] args) {

        var context = new AnnotationConfigApplicationContext(Lab2_1Config.class);

        context.getBean(Scene.class).draw();


    }

}
