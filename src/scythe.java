import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class scythe extends item{
    public scythe() {
        super();
        img = new ImageIcon("src/textures/scythe.png").getImage();
        name = "shotgun";
    }

    public void use(boolean trigger, Graphics g, ArrayList<ArrayList<tile>> tilesOnScreen) {
        ArrayList<bullet> scytheslash = new ArrayList<bullet>();
        if (trigger) {
            for (double b = 0; b <= 5; b++) {
                scytheslash.add(new bullet((main.screenWidthTiles / 2) - 1.25 + (b / 2), ((main.screenHeightTiles / 2) - (b / 3))));
            }
            for (int b = 0; b < scytheslash.size(); b++) {
                if (Collision.isCollided(scytheslash.get(b).x,scytheslash.get(b).y,tilesOnScreen,10,10)) {
                    scytheslash.remove(b);
                }
                g.setColor(Color.red);
                g.drawRect((int) (scytheslash.get(b).x * 64), (int) (scytheslash.get(b).y * 64), 10, 10);
            }
        }
    }

}
