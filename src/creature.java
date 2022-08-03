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

    public void draw(Graphics g){
        g.drawImage(image, (int) ((x - tiles2.xadd) * 64 + 960), (int) ((y - tiles2.yadd) * 64 + 540),null);
    }
}
