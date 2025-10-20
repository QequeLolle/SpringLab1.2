package lab1_2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main (String[] args) {

        var context = new ClassPathXmlApplicationContext("lab1_2Config.xml");

        context.getBean(Scene.class).draw();


    }

}
