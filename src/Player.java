import javax.swing.*;
import java.awt.*;

public class Player extends accelerate{
    int hp = 100;
    int stamina = 100;
    double dmg = 0.1;
    int sanity = 100;
    double x = 10;
    double y = 5;
    inventory inventory;
    Image sprite = new ImageIcon("src/textures/guy.png").getImage();

    public Player(Listener listener_) {
        listener = listener_;
        int hp = 100;
    }

    public void draw(Graphics g) {
        g.setColor(Color.red);
        inventory.draw(g);
        //g.fillOval((int)(960 - width/2), (int)(540 - (int) length/2), (int) width, (int) length);
        g.drawImage(sprite, (int)(main.screenWidthTiles/2 * main.tileSize - width/2),
                            (int)(main.screenHeightTiles/2 * main.tileSize - (int) length/2), null);
    }
}


