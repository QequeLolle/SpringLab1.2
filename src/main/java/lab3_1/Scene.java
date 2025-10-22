package lab3_1;

import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Lazy
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

    @PreDestroy
    public void onDestroy() {
        for (var fig : figs) {
            fig.erase();
        }
    }


//    public void close() {
//        for (var fig : figs) {
//            fig.erase();
//        }
//    }

}
