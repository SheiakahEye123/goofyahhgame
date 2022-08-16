import java.awt.*;

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
}
