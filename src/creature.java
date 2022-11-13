import java.awt.*;
import java.util.ArrayList;

public class creature extends Collision{
    double health = 100;
    double dmg;
    double x;
    double y;

    public static double hitBoxWidth = 1;

    WorldState worldState;

    long current;
    long last;
    double speed = 0.000000000000015;

    boolean dead;

    Image image;

    ArrayList<HomingBullet> homingBullets = new ArrayList<HomingBullet>();


    public creature(int x_, int y_, Image image_, WorldState worldState_){
        image = image_;
        x = x_;
        y = y_;
        last = System.currentTimeMillis();
        worldState = worldState_;
        dmg = 0.0001;
    }

    public void draw(Graphics g, double x_, double y_){
        g.drawImage(image, (int) (((x - x_) * WorldState.tileSize + 960) - hitBoxWidth/2), (int) (((y - y_) * WorldState.tileSize + 540) - hitBoxWidth/2),null);
        //if (homingBullets.size() < 1) { homingBullets.add(new HomingBullet((int) x,(int) y,null)); }
        if (System.currentTimeMillis() - last >= 2000) {
            worldState.enemyBullets.add(new HomingBullet((int) x,(int) y,null, worldState));
            last = System.currentTimeMillis();
        }
    }


    public void move(ArrayList<ArrayList<Integer>> intmap, int px, int py) {
        if (!Util.inBounds(x-1,y-1,intmap)) {
            accelerate(false, false, false, false, false,speed);
            return;
        }
        if (!Util.inBounds(x+1,y+1,intmap)) {
            accelerate(false, false, false, false, false,speed);
            return;
        }
        if (intmap.size() > 0 && !intmap.get((int) y).get((int) x).equals(intmap.get(py).get(px))) {
            if (intmap.get((int) y).get((int) x - 1) == intmap.get((int) y).get((int) x) - 1) {
                accelerate(false, true, false, false, false,speed);
                if (!worldState.tiles2.isCollided(x + velx, y, worldState.tiles2.tileslist, 0.45, 0.45)) {
                    x += velx;
                }
                if (!worldState.tiles2.isCollided(x, y + vely, worldState.tiles2.tileslist, 0.45, 0.45)) {
                    y += vely;
                }
                return;
            }
            if (intmap.get((int) y).get((int) x + 1) == intmap.get((int) y).get((int) x) - 1) {
                accelerate(false, false, false, true, false,speed);
                if (!worldState.tiles2.isCollided(x + velx, y, worldState.tiles2.tileslist, 0.45, 0.45)) {
                    x += velx;
                }
                if (!worldState.tiles2.isCollided(x, y + vely, worldState.tiles2.tileslist, 0.45, 0.45)) {
                    y += vely;
                }
                return;
            }
            if (intmap.get((int) y - 1).get((int) x) == intmap.get((int) y).get((int) x) - 1) {
                accelerate(true, false, false, false, false,speed);
                if (!worldState.tiles2.isCollided(x + velx, y, worldState.tiles2.tileslist, 0.45, 0.45)) {
                    x += velx;
                }
                if (!worldState.tiles2.isCollided(x, y + vely, worldState.tiles2.tileslist, 0.45, 0.45)) {
                    y += vely;
                }
                return;
            }
            if (intmap.get((int) y + 1).get((int) x) == intmap.get((int) y).get((int) x) - 1) {
                accelerate(false, false, true, false, false,speed);
                if (!worldState.tiles2.isCollided(x + velx, y, worldState.tiles2.tileslist, 0.45, 0.45)) {
                    x += velx;
                }
                if (!worldState.tiles2.isCollided(x, y + vely, worldState.tiles2.tileslist, 0.45, 0.45)) {
                    y += vely;
                }
                return;
            }
            accelerate(false, false, false, false, false,speed);
        }
    }

}
