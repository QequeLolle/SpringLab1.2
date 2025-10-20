package lab1_2;

import java.util.List;

public class Scene {

    private List<Shape> figs;

    // ====================

    public Scene() { }

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
