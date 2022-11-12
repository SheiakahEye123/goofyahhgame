import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class weapon extends item{
    long time;
    long timeatlastuse;
    double seconds;
    double dmg;
    public weapon() {
        super();
        img = new ImageIcon("src/textures/scythe.png").getImage();
        name = "weapon";
        time = System.nanoTime();
    }

    public void use(boolean trigger, Graphics g, ArrayList<ArrayList<tile>> tilesOnScreen, WorldState worldstate) {
        if (cooldown()) {
            if (trigger) {
                Point p = WorldState.getMouseLocation();
                double bvely = p.y - 572;
                double bvelx = p.x - 960;
                double dist = (Math.hypot(960 - p.x,572 - p.y)) * 10;
                worldstate.bullets.add(new bullet(worldstate.Player.x - 0.05,worldstate.Player.y - 0.05,dmg, 0.1, true, "bleed", bvelx/dist, bvely/dist));
                timeatlastuse = System.nanoTime();
            }
        }
    }

    public boolean cooldown() {
        if (((System.nanoTime()-timeatlastuse)/1000000000.0) >= seconds) {
            return true;
        }
        return false;
    }
}
