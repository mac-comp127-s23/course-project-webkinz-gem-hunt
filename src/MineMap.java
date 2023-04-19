import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Line;
import edu.macalester.graphics.Rectangle;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class MineMap {

    private static Color color;
    private static GraphicsGroup mapGroup;
    private static double CANVAS_WIDTH = 800; 
    private static double CANVAS_HEIGHT = 600;
    private static final Color MAP_BACKGROUND = new Color(242, 223, 169);


    public MineMap() {
        mapGroup = new GraphicsGroup(0,0);
    }

    public static void main(String[] args) {
        MineMap map = new MineMap();
        CanvasWindow canvas = new CanvasWindow("Mine", 800, 600);
        canvas.setBackground(MAP_BACKGROUND);

        map.addMountains();
        map.addMines();

        mapGroup.add(map.addCluster(30,300));
        mapGroup.add(map.addCluster(425,450));
        mapGroup.add(map.addCluster(325,200));
        mapGroup.add(map.addCluster(700,250));
        mapGroup.add(map.addCluster(100,510));

        canvas.add(mapGroup);
        canvas.draw();
    }

    private void addMountains() {
        List<Line> lineList = new ArrayList<>();

        Line line1 = new Line(-50, 200, 110, 75);
        lineList.add(line1);
        Line line2 = new Line(110, 75, 270, 200);
        lineList.add(line2);
        Line line3 = new Line(180, 500, 300, 450);
        lineList.add(line3);
        Line line4 = new Line(300, 450, 420, 500);
        lineList.add(line4);
        Line line5 = new Line(375, 260, 600, 100);
        lineList.add(line5);
        Line line6 = new Line(600, 100, 875, 260);
        lineList.add(line6);

        for (Line l: lineList){
            l.setStrokeColor(new Color(185, 168, 116));
            l.setStrokeWidth(5);
            mapGroup.add(l);
        }

    }

    private GraphicsGroup addCluster(double x, double y) {
        GraphicsGroup cluster = new GraphicsGroup(x,y);
        List<Line> clusterList = new ArrayList<>();

        Line lineA = new Line(0,12, 19,0);
        clusterList.add(lineA);
        Line lineB = new Line(19,0, 38,12);
        clusterList.add(lineB);
        Line lineC = new Line(47,12, 66,0);
        clusterList.add(lineC);
        Line lineD = new Line(66,0, 85,12);
        clusterList.add(lineD);
        Line lineE = new Line(30,0, 42.5,-7);
        clusterList.add(lineE);
        Line lineF = new Line(42.5,-7, 55,0);
        clusterList.add(lineF);

        for (Line l: clusterList){
            l.setStrokeColor(new Color(185, 168, 116));
            l.setStrokeWidth(3);
            cluster.add(l);
        }

        return cluster;

    }

    private void addMines() {
        Rectangle blueRect = new Rectangle(80, 120, 60, 60);
        blueRect.setFillColor(Color.BLUE);
        mapGroup.add(blueRect);

        Rectangle redRect = new Rectangle(570, 140, 60, 60);
        redRect.setFillColor(Color.RED);
        mapGroup.add(redRect);

        Rectangle greenRect = new Rectangle(280, 250, 60, 60);
        greenRect.setFillColor(Color.GREEN);
        mapGroup.add(greenRect);

        Rectangle yellowRect = new Rectangle(270, 480, 60, 60);
        yellowRect.setFillColor(Color.YELLOW);
        mapGroup.add(yellowRect);

        Rectangle whiteRect = new Rectangle(660, 380, 60, 60);
        whiteRect.setFillColor(Color.LIGHT_GRAY);
        mapGroup.add(whiteRect);
    }

    
}
