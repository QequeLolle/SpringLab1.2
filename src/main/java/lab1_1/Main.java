package lab1_1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main (String[] args) {

        System.out.println("Before context");

        var context = new ClassPathXmlApplicationContext("applicationConfig.xml");

        System.out.println("After context");

        Person person = context.getBean("person", Person.class);
        System.out.println("NAME: " + person.getName() + "\nAGE: " + person.getAge());

        Person person1 = context.getBean("person1", Person.class);
        System.out.println("NAME: " + person1.getName() + "\nAGE: " + person1.getAge());
    }
}
