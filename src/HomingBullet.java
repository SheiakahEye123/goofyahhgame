import javax.swing.*;
import java.awt.*;

public class HomingBullet extends creature{
    public HomingBullet(int x_, int y_, Image image_, WorldState worldState_) {
        super(x_, y_, image_, worldState_);
        height = 10;
        width = 10;
        health = 10;
        dmg = 0.01;
        image = new ImageIcon("src/textures/homing.png").getImage();
        speed = 0.00000000000015;
    }
    public void draw(Graphics g, double x_, double y_) {
        g.drawImage(image, (int) (((x - x_) * 64 + 960) - width / 2), (int) (((y - y_) * 64 + 540) - height / 2), null);
    }
}
