package lab3_1;

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

    public void setColour(String colour) {
        this.colour = colour;
    }

    // ====================

    public abstract void draw();

    public abstract void erase();
}
