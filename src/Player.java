import kotlin.Pair;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Player extends accelerate{
    int hp = 100;
    int stamina = 100;
    double dmg = 0.1;
    int sanity = 100;
    inventory inventory = new inventory(vely, velx);
    Image sprite = new ImageIcon("src/textures/guy.png").getImage();

    public Player(Listener listener_) {
        listener = listener_;
        int hp = 100;
    }

    public void draw(Graphics g) {
        g.setColor(Color.red);
        inventory.draw(g);
        //g.fillOval((int)(960 - width/2), (int)(540 - (int) length/2), (int) width, (int) length);
        g.drawImage(sprite, (int)(960 - width/2), (int)(540 - (int) length/2), null);
    }
}


