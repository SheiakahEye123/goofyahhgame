import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class scythe extends item{
    Player player;
    public scythe(Player player_) {
        super(player_);
        player = player_;
        img = new ImageIcon("src/textures/shotgun.png").getImage();
        name = "shotgun";
    }

    public void use(boolean trigger, Graphics g) {
        ArrayList<bullet> scytheslash = new ArrayList<bullet>();
        for (double b = 0; b <= 10; b++) {
            scytheslash.add(new bullet((main.screenWidthTiles/2) - 2.5 + (b/2) , (main.screenHeightTiles) - 0.5 + (b/2)));
        }
        for (bullet b: scytheslash) {
            g.drawRect(b.x - 0.1, b.y - 0.1,0.1,0.1)
        }
    }

}
