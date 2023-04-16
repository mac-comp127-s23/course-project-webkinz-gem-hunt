import edu.macalester.graphics.Arc;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Line;
import edu.macalester.graphics.Path;
import edu.macalester.graphics.Point;

import java.awt.Color;

public class Pickaxe {
    private static GraphicsGroup axe;

    public Pickaxe() {
    }

    public static GraphicsGroup drawAxe() {
        axe = new GraphicsGroup();

        Arc blade = new Arc(-40,-50, 50, 50, 160, -80); 
        blade.setStrokeColor(Color.GRAY);
        blade.setStrokeWidth(10);
        axe.add(blade);

        Line handle = new Line(0, 0, -30, -50); 
        handle.setStrokeColor(Color.ORANGE);
        handle.setStrokeWidth(7);
        axe.add(handle);

        return axe;
    }

    public GraphicsGroup getAxe() {
        return axe;
    }

    public Rock testRockHit(CanvasWindow canvas, Mine currentMine) {
        Point p = axe.getCenter();
        Point testP = new Point(p.getX() - 5, p.getY()); // move the test point slightly off center so the pickaxe isn't detected
        GraphicsObject rock = canvas.getElementAt(testP);
        if(rock instanceof Path && currentMine.hasRock(rock)){
            return currentMine.getRock((Path) rock);
        }

        return null;
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
