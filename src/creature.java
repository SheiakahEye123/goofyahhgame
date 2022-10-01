import java.awt.*;
import java.util.ArrayList;

public class creature extends Collision{
    double health;
    double dmg;
    double ex;
    double ey;
    double speed = 0.000000000000015;

    int width = 64;
    int height = 64;

    tiles2 tiles2;
    Image image;

    public creature(tiles2 tiles2_, int x_, int y_, Image image_){
        tiles2 = tiles2_;
        image = image_;
        ex = x_;
        ey = y_;
    }

    public void draw(Graphics g, double x_, double y_){
        g.drawImage(image, (int) (((ex - x_) * 64 + 960) - width/2), (int) (((ey - y_) * 64 + 540) - height/2),null);
    }
    public void move(ArrayList<ArrayList<Integer>> intmap, int px, int py) {
        if (intmap.get((int) ey).get((int) ex) != intmap.get(py).get(px)) {
            if (intmap.get((int) ey).get((int) ex - 1) == intmap.get((int) ey).get((int) ex) - 1) {
                accelerate(false, true, false, false, false,speed);
                if (!tiles2.isCollided(ex + velx, ey, tiles2.tileslist, 0.45, 0.45)) {
                    ex += velx;
                }
                if (!tiles2.isCollided(ex, ey + vely, tiles2.tileslist, 0.45, 0.45)) {
                    ey += vely;
                }
                return;
            }
            if (intmap.get((int) ey).get((int) ex + 1) == intmap.get((int) ey).get((int) ex) - 1) {
                accelerate(false, false, false, true, false,speed);
                if (!tiles2.isCollided(ex + velx, ey, tiles2.tileslist, 0.45, 0.45)) {
                    ex += velx;
                }
                if (!tiles2.isCollided(ex, ey + vely, tiles2.tileslist, 0.45, 0.45)) {
                    ey += vely;
                }
                return;
            }
            if (intmap.get((int) ey - 1).get((int) ex) == intmap.get((int) ey).get((int) ex) - 1) {
                accelerate(true, false, false, false, false,speed);
                if (!tiles2.isCollided(ex + velx, ey, tiles2.tileslist, 0.45, 0.45)) {
                    ex += velx;
                }
                if (!tiles2.isCollided(ex, ey + vely, tiles2.tileslist, 0.45, 0.45)) {
                    ey += vely;
                }
                return;
            }
            if (intmap.get((int) ey + 1).get((int) ex) == intmap.get((int) ey).get((int) ex) - 1) {
                accelerate(false, false, true, false, false,speed);
                if (!tiles2.isCollided(ex + velx, ey, tiles2.tileslist, 0.45, 0.45)) {
                    ex += velx;
                }
                if (!tiles2.isCollided(ex, ey + vely, tiles2.tileslist, 0.45, 0.45)) {
                    ey += vely;
                }
                return;
            }
            accelerate(false, false, false, false, false,speed);
        }
    }
}
