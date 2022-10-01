import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class scythe extends item{
    ArrayList<bullet> scytheslash = new ArrayList<bullet>();
    public scythe() {
        super();
        img = new ImageIcon("src/textures/scythe.png").getImage();
        name = "scythe";
    }

    public void use(boolean trigger, Graphics g, ArrayList<ArrayList<tile>> tilesOnScreen) {
        if (trigger) {
            for (double b = 0; b <= 5; b++) {
                scytheslash.add(new bullet(main.Player.x - 1.25 + (b / 2), main.Player.y - (b / 3), 12,0.1));
            }
        }
        for (int b = 0; b < scytheslash.size(); b++) {
//                if (scytheslash.get(b).isCollided(scytheslash.get(b).x,scytheslash.get(b).y,tilesOnScreen,10,10)) {
//                    scytheslash.remove(b);
//                }
            g.setColor(Color.red);
            g.drawRect((int) ((scytheslash.get(b).x - main.Player.x) * main.tileSize + 960), (int) ((scytheslash.get(b).y - main.Player.y) * main.tileSize + 540), 10, 10);
        }
    }

}
