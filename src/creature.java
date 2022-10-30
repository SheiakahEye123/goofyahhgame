import java.awt.*;
import java.util.ArrayList;

public class creature extends Collision{
    double health = 100;
    double dmg;
    double x;
    double y;
    double speed = 0.000000000000015;

    int width = 64;
    int height = 64;

    tiles2 tiles2;
    Image image;


    public creature(tiles2 tiles2_, int x_, int y_, Image image_){
        tiles2 = tiles2_;
        image = image_;
        x = x_;
        y = y_;
    }

    public void draw(Graphics g, double x_, double y_, Color color){
        g.drawImage(image, (int) (((x - x_) * 64 + 960) - width/2), (int) (((y - y_) * 64 + 540) - height/2),null);
        g.setColor(color);
        g.drawRect((int) ((x - x_) * 64 + 960), (int) (((y - y_) * 64 + 540)),width + 12, height + 12);
    }
    public void move(ArrayList<ArrayList<Integer>> intmap, int px, int py) {
        if (intmap.get((int) y).get((int) x) != intmap.get(py).get(px)) {
            if (intmap.get((int) y).get((int) x - 1) == intmap.get((int) y).get((int) x) - 1) {
                accelerate(false, true, false, false, false,speed);
                if (!tiles2.isCollided(x + velx, y, tiles2.tileslist, 0.45, 0.45)) {
                    x += velx;
                }
                if (!tiles2.isCollided(x, y + vely, tiles2.tileslist, 0.45, 0.45)) {
                    y += vely;
                }
                return;
            }
            if (intmap.get((int) y).get((int) x + 1) == intmap.get((int) y).get((int) x) - 1) {
                accelerate(false, false, false, true, false,speed);
                if (!tiles2.isCollided(x + velx, y, tiles2.tileslist, 0.45, 0.45)) {
                    x += velx;
                }
                if (!tiles2.isCollided(x, y + vely, tiles2.tileslist, 0.45, 0.45)) {
                    y += vely;
                }
                return;
            }
            if (intmap.get((int) y - 1).get((int) x) == intmap.get((int) y).get((int) x) - 1) {
                accelerate(true, false, false, false, false,speed);
                if (!tiles2.isCollided(x + velx, y, tiles2.tileslist, 0.45, 0.45)) {
                    x += velx;
                }
                if (!tiles2.isCollided(x, y + vely, tiles2.tileslist, 0.45, 0.45)) {
                    y += vely;
                }
                return;
            }
            if (intmap.get((int) y + 1).get((int) x) == intmap.get((int) y).get((int) x) - 1) {
                accelerate(false, false, true, false, false,speed);
                if (!tiles2.isCollided(x + velx, y, tiles2.tileslist, 0.45, 0.45)) {
                    x += velx;
                }
                if (!tiles2.isCollided(x, y + vely, tiles2.tileslist, 0.45, 0.45)) {
                    y += vely;
                }
                return;
            }
            accelerate(false, false, false, false, false,speed);
        }
    }

}
