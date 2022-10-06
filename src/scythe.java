import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class scythe extends item{
    long time1 = 0;
    public scythe() {
        super();
        img = new ImageIcon("src/textures/scythe.png").getImage();
        name = "scythe";
        time = System.nanoTime()/1000000000;
    }

    public void use(boolean trigger, Graphics g, ArrayList<ArrayList<tile>> tilesOnScreen, WorldState worldstate) {
        System.out.println(time + "/" + time1);
        if (cooldown(0.5)) {
            System.out.println("e");
            if (trigger) {
                for (double b = 0; b <= 5; b++) {
                    worldstate.bullets.add(new bullet(worldstate.Player.x - 1.25 + (b / 2), worldstate.Player.y - (b / 3), 12, 0.1, false, "bleed"));
                }
            }
            for (int b = 0; b < worldstate.bullets.size(); b++) {
//                if (scytheslash.get(b).isCollided(scytheslash.get(b).x,scytheslash.get(b).y,tilesOnScreen,10,10)) {
//                    scytheslash.remove(b);
//                }
            }
        }
        time1 = time;
    }

    public boolean cooldown(double s) {
        if ((time - time1) >= s) {
            return true;
        }
        return false;
    }



}
