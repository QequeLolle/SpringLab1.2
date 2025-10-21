package lab2_1;

import org.springframework.beans.factory.annotation.Value;

public abstract class Shape {

    private String colour;

    // ====================

    public Shape() {
        this.colour = "black";
    }

    public Shape(String colour) {
        this.colour = colour;
    }

    // ====================

    public String getColour() {
        return colour;
    }

//    @Value("${yellowCircle.colour}")
    public void setColour(String colour) {
        this.colour = colour;
    }

    // ====================

    public abstract void draw();
}
