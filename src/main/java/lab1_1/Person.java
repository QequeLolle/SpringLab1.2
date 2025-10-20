package lab1_1;

public class Person {

    private String name;
    private int age;

    public Person() {
        System.out.println("DEFAULT CONSTRUCTOR");
    }

    public Person(String name) {
        System.out.println("NAME CONSTRUCTOR");
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("CONSTRUCTOR FULL");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
