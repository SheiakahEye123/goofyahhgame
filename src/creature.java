import java.awt.*;
import java.util.ArrayList;

public class creature extends accelerate{
    double health;
    double dmg;
    int ex;
    int ey;

    tiles2 tiles2;
    Image image;


    public creature(tiles2 tiles2_, int x_, int y_, Image image_, Listener listener_){
        tiles2 = tiles2_;
        image = image_;
        listener = listener_;
        ex = x_;
        ey = y_;
    }

    public void draw(Graphics g, double x_, double y_){
        g.drawImage(image, (int) ((ex - x_) * 64 + 960), (int) ((ey - y_) * 64 + 540),null);
    }
    public void move(ArrayList<ArrayList<Integer>> intmap) {
        var nearby = new ArrayList<Integer>();
        nearby.add(intmap.get(ey-1).get(ex-1));
    }
}
