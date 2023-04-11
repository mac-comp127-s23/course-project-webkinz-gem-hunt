import edu.macalester.graphics.Arc;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Line;

import java.awt.Color;

public class Pickaxe {
    private static GraphicsGroup axe;

    public Pickaxe() {
    }

    public static GraphicsGroup drawAxe() {
        axe = new GraphicsGroup();

        // Arc blade = new Arc(-10,-50, 50, 50, 100, -80); // right facing
        Arc blade = new Arc(-40,-50, 50, 50, 160, -80); // left facing
        blade.setStrokeColor(Color.GRAY);
        blade.setStrokeWidth(10);
        axe.add(blade);

        // Line handle = new Line(0, 0, 30, -50); // right facing
        Line handle = new Line(0, 0, -30, -50); // left facing
        handle.setStrokeColor(Color.ORANGE);
        handle.setStrokeWidth(7);
        axe.add(handle);

        return axe;
    }

    public static void mineAnimate(CanvasWindow canvas) {
        for (int i = 0; i < 3; i++) { // 3 repeats of motion
            axe.rotateBy(90);
            canvas.draw();
            canvas.pause(150);

            axe.rotateBy(-90);
            canvas.draw();
            canvas.pause(150);
        }
    }

    // // for testing:
    // public static void main(String[] args) {
    //     drawAxe();

    //     CanvasWindow canvas = new CanvasWindow("Pickaxe", 800, 600);

    //     canvas.add(axe, 100, 100); // arbitrary starting point
    //     canvas.draw();

    //     canvas.onMouseMove(event -> {
    //         axe.setPosition(event.getPosition());
    //     });

    //     canvas.onClick(event -> {
    //         mineAnimate(canvas);
    //     });
    // }
    
}
