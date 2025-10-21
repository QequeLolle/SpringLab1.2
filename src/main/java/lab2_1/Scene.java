package lab2_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Scene {

    private List<Shape> figs;

    // ====================

    public Scene() { }

    @Autowired
    public Scene(List<Shape> figs) {
        this.figs = figs;
    }

    // ====================

    public List<Shape> getFigs() {
        return figs;
    }

    public void setFigs(List<Shape> figs) {
        this.figs = figs;
    }

    // ====================

    public void draw() {
        for (var fig : figs) {
            fig.draw();
        }
    }

}
