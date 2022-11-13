import javax.swing.*;
import java.awt.*;

public class EBullet extends creature{
    int height;
    int width;
    public EBullet(int x_, int y_, Image image_, WorldState worldState_) {
        super(x_, y_, image_, worldState_);
        height = 10;
        width = 10;
        health = 10;
        dmg = 0.000001;
        image = new ImageIcon("src/textures/homing.png").getImage();
        speed = 0.00000000000015;
        velx = ;
        vely;
    }

    public void draw(Graphics g, double x_, double y_) {
        g.drawImage(image, (int) (((x - x_) * WorldState.tileSize + 960) - width / 2), (int) (((y - y_) * 64 + 540) - height / 2), null);
    }
}