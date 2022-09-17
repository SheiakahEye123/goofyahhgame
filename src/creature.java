import java.awt.*;
import java.util.ArrayList;

public class creature extends accelerate{
    double x;
    double y;
    double health;
    double dmg;

    tiles2 tiles2;
    Image image;


    public creature(tiles2 tiles2_, double x_, double y_, Image image_, Listener listener_){
        tiles2 = tiles2_;
        x = x_;
        y = y_;
        image = image_;
        listener = listener_;
    }

    public void draw(Graphics g, double x_, double y_){
        g.drawImage(image, (int) ((x - x_) * 64 + 960), (int) ((y - y_) * 64 + 540),null);
    }

    public void pathfind(ArrayList<ArrayList<tile>> tiles2){
        var grid = new ArrayList<ArrayList<Integer>>();

        for (int y = 0; y < tiles2.size(); y++) {
            var row = new ArrayList<Integer>();
            for (int x = 0; x < tiles2.get(0).size(); x++) {
                if (tiles2.get(y).get(x) != null) {
                    row.add(-1);
                }
                if (tiles2.get(y).get(x) == null) {
                    row.add(0);
                }
            }
            grid.add(row);
        }

        for (int i = 0; i < grid.size(); i++) {
            System.out.println(grid.get(i));
        }

    }
}
