import javax.swing.*;
import java.awt.*;

public class Player extends Collision{
    int hp = 100;
    int stamina = 100;
    double dmg = 100;
    int sanity = 100;
    double x = 10;
    double y = 5;

    public static double playerTileSize = 0.8;
    public static double hitBoxWidth = 1;
    Hitbox hitbox = new Hitbox(x,y,x+1,y+1 );
    inventory inventory = new inventory();
    Image sprite = new ImageIcon("src/textures/you.png").getImage();

    public Player(Listener listener_) {
        listener = listener_;
        int hp = 100;
        inventory.inv.add(new MachineGun());
    }

    public void draw(Graphics g) {
        g.setColor(Color.red);
        inventory.draw(g);
        //g.fillOval((int)(960 - width/2), (int)(540 - (int) length/2), (int) width, (int) length);
        g.drawImage(sprite, (int)(WorldState.screenWidthTiles/2 * WorldState.tileSize - WorldState.tileSize/2),
                            (int)(WorldState.screenHeightTiles/2 * WorldState.tileSize - (int) WorldState.tileSize/2), null);
        g.setColor(Color.RED);
        g.fillRect(10,10,hp * 10,100);
        var g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(10));
        g.setColor(Color.GRAY);
        g.drawRect(0,10,1010,110);
        g2d.setStroke(new BasicStroke(1));
    }
}


