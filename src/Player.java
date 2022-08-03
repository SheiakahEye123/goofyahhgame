import kotlin.Pair;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Player extends accelerate{
    int hp = 100;
    ArrayList<item> inventory = new ArrayList<item>();

    public Player(Listener listener_) {
        listener = listener_;
        int hp = 100;
    }

    public void draw(Graphics g) {
        g.setColor(Color.red);
        g.fillOval((int)(960 - width/2), (int)(540 - (int) length/2), (int) width, (int) length);
    }
}


