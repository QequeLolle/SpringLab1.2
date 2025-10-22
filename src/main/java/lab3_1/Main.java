package lab3_1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main (String[] args) {

        try(var context = new AnnotationConfigApplicationContext(Lab3_1Config.class)) {
            context.getBean(Scene.class).draw();
        }

    }

}
