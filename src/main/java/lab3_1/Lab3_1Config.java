package lab3_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan("lab3_1")
@PropertySource("scene.properties")
public class Lab3_1Config {

    /*  <bean id="point1" class="lab1_2.Point" scope="singleton">
            <constructor-arg ref="coords"/>
            <property name="x" value="${point.x}"/>
            <property name="y" value="${point.y}"/>
            <property name="circle3Colour" value="blue"/>
        </bean>
    */

    @Bean
    Point point1(@Value("${point.x}") int x, @Value("${point.y}") int y, @Value("#{coords}") Coords coords) {
        Point p = new Point(coords);
        p.setX(x);
        p.setY(y);
        p.setColour("blue");
        return p;
    }

    //======================================

    /*  <bean id="point2" class="lab1_2.Point"></bean>  */

    @Bean
    Point point2() {
        return new Point();
    }

    //======================================

    /*
    <bean id="coordsGreen" class="lab1_2.Coords">
        <constructor-arg index="0" value="44"/>
        <constructor-arg name="y" value="55"/>
    </bean>
    */

    @Bean
    Coords coordsGreen() {
        return new Coords(44, 55);
    }

    //======================================

    /*
    <bean id="point3" class="lab1_2.Point">
        <constructor-arg ref="coordsGreen"/>
        <property name="circle3Colour" value="green"/>
    </bean>
    */

//    @Bean
//    Point point3(@Qualifier("coordsGreen") Coords coordsGreen) {
//        Point p = new Point();
//        p.setCoords(coordsGreen);
//        System.out.println("COORDS GREEN: " + coordsGreen());
//        p.setColour("green");
//        return p;
//    }

    @Bean
    Point point3() {
        Point p = new Point(coordsGreen());
        p.setColour("green");
        return p;
    }

    //======================================

    /*
    <bean id="circle" class="lab1_2.Circle">
        <constructor-arg ref="coords"/>
        <constructor-arg value="5"/>
    </bean>
    */

    @Bean
    Circle circle(@Qualifier("coords") Coords coords) {

        return new Circle(coords, 5);
    }

    //======================================

    /*
    <bean id="yellowCircle" class="lab1_2.Circle">
        <constructor-arg ref="coords"/>
        <property name="x" value="${yellowCircle.x}"/>
        <property name="y" value="${yellowCircle.y}"/>
        <property name="circle3Colour" value="${yellowCircle.circle3Colour}"/>
        <constructor-arg index="1" value="${yellowCircle.r}"/>
    </bean>

    */

    @Bean
    Circle yellowCircle(@Value("#{coords}") Coords coords,
                        @Value("${yellowCircle.x}") int x,
                        @Value("${yellowCircle.y}") int y,
                        @Value("${yellowCircle.r}") int r,
                        @Value("${yellowCircle.colour}") String colour) {
        Circle c = new Circle(coords, r);
        c.setX(x);
        c.setY(y);
        c.setColour(colour);
        return c;
    }


    //======================================

    @Bean
    Coords coords77() {
        return new Coords(7, 7);
    }

    @Bean
    Point redPoint() {
        return new Point(coords77(), "red");
    }

    @Autowired
    private Environment env;

    @Bean
    Circle circle3() {
        final String circle3Colour = env.getProperty("yellowCircle.colour", String.class,"grey");
        return new Circle(coords77(), 11, circle3Colour);
    }

    @Bean
    Circle whiteCircle() {
        return new Circle(coords77(), 11, "white");
    }

}
