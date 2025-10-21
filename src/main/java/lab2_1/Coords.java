package lab2_1;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component  // id == coords
@Scope("prototype")
@Primary
public class Coords {

    private int x;
    private int y;

    // ====================

    public Coords() {
        this.x = 0;
        this.y = 0;
    }

    public Coords(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // ====================

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    // ====================

    @Override
    public String toString() {
        return "Coords{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
