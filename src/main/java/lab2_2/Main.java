package lab2_2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main (String[] args) {

        var context = new AnnotationConfigApplicationContext(Lab2_2Config.class);

        context.getBean(Scene.class).draw();


    }

}
