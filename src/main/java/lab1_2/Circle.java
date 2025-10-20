package lab1_2;

public class Circle extends Shape {

    private Coords centre;
    private int radius;

    // ====================

    public Circle(Coords centre, int radius) {
        super();
        this.centre = centre;
        this.radius = radius;
    }

    public Circle(Coords centre, int radius, String colour) {
        super(colour);
        this.centre = centre;
        this.radius = radius;
    }

    public Circle(Coords centre) {
        this(centre, 0);
    }


    // ====================

    public Coords getCentre() {
        return centre;
    }

    public void setCentre(Coords centre) {
        this.centre = centre;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getX() {
        return getCentre().getX();
    }

    public void setX(int x) {
        getCentre().setX(x);
    }

    public int getY() {
        return getCentre().getY();
    }

    public void setY(int y) {
        getCentre().setY(y);
    }

    // ====================

    @Override
    public void draw() {
        System.out.println("DRAW A " + getColour() + " CIRCLE AT (" + centre.getX() + ", " + centre.getY() + ") " +
                "WITH R = " + getRadius());
    }
}
