package lab3_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Point extends Shape {

    private Coords coords;

    // ====================

    public Point() {
        super();
        this.coords = new Coords();
    }

    @Autowired
    public Point(Coords coords) {
        super();
        this.coords = coords;
    }

    public Point(Coords coords, String colour) {
        super(colour);
        this.coords = coords;
    }

    // ====================

    public int getX() {
        return coords.getX();
    }

//    @Value("${point.x}")
    public void setX(int x) {
        coords.setX(x);
    }

    public int getY() {
        return coords.getY();
    }

//    @Value("${point.y}")
    public void setY(int y) {
        coords.setY(y);
    }

    public Coords getCoords() {
        return coords;
    }

    public void setCoords(Coords coords) {
        this.coords = coords;
    }

    public void setCoords(int x, int y) {
        this.coords.setX(x);
        this.coords.setY(y);
    }

    // ====================

    @Override
    public void draw() {
        System.out.println("DRAW A " + getColour() + " POINT AT (" + coords.getX() + ", " + coords.getY() + ")");
    }

    @Override
    public void erase() {
        System.out.println("ERASE A " + getColour() + " POINT AT (" + coords.getX() + ", " + coords.getY() + "). " +
                "NO MORE POINT");
    }
}
