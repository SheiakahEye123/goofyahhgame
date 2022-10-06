import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class scythe extends item{
    long time;
    long time1;
    public scythe() {
        super();
        img = new ImageIcon("src/textures/scythe.png").getImage();
        name = "scythe";
        time = System.nanoTime();
    }

    public void use(boolean trigger, Graphics g, ArrayList<ArrayList<tile>> tilesOnScreen, WorldState worldstate) {
        time1 = System.nanoTime();
        if (true) {
            System.out.println("e");
            if (trigger) {
                bullet leadBullet = new bullet(worldstate.Player.x - 1.25, worldstate.Player.y, 12, 0.1, false, "bleed");

                double targetX = worldstate.Player.x + 1.25;
                double targetY = worldstate.Player.y - 1;
                worldstate.bullets.add(leadBullet);
                if (leadBullet.x > targetX) {
                    leadBullet.accelerate(false,true,false,false, false,0.0000000000003);
                    worldstate.bullets.add(new bullet(leadBullet.x, leadBullet.y, 12, 0.1, false, "bleed"));
                }
                if (leadBullet.x < targetX) {
                    leadBullet.accelerate(false,false,false,true, false,0.0000000000003);
                    worldstate.bullets.add(new bullet(leadBullet.x, leadBullet.y, 12, 0.1, false, "bleed"));
                }
                if (leadBullet.y < targetY) {
                    leadBullet.accelerate(false,false,true,false, false,0.0000000000003);
                    worldstate.bullets.add(new bullet(leadBullet.x, leadBullet.y, 12, 0.1, false, "bleed"));
                }
                if (leadBullet.y > targetY) {
                    leadBullet.accelerate(true,false,false,false, false,0.0000000000003);
                    worldstate.bullets.add(new bullet(leadBullet.x, leadBullet.y, 12, 0.1, false, "bleed"));
                }

            }
            for (int b = 0; b < worldstate.bullets.size(); b++) {
                g.drawRect((int) ((worldstate.bullets.get(b).x * 64 + 960)), (int) ((worldstate.bullets.get(b).y) * 64 + 540),10,10);
            }
            time = System.nanoTime();
        }
    }

    public boolean cooldown(double s) {
        if ((time - time1) >= s) {
            return true;
        }
        return false;
    }



}
