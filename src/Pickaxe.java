import edu.macalester.graphics.Arc;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Line;

import java.awt.Color;

public class Pickaxe {
    private GraphicsGroup axe;

    public Pickaxe() {
        axe = new GraphicsGroup();

        Arc blade = new Arc(-40,-50, 50, 50, 160, -80); 
        blade.setStrokeColor(Color.GRAY);
        blade.setStrokeWidth(10);
        axe.add(blade);

        Line handle = new Line(0, 0, -30, -50); 
        handle.setStrokeColor(Color.ORANGE);
        handle.setStrokeWidth(7);
        axe.add(handle);
    }

    public void drawAxe(GraphicsGroup group) {
        group.add(axe);
    }

    public GraphicsGroup getAxe() {
        return axe;
    }
    
}
