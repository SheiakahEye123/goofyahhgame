import javax.swing.*;
import java.awt.*;

public class HomingBullet extends creature{
    public HomingBullet(tiles2 tiles2_, int x_, int y_, Image image_) {
        super(tiles2_, x_, y_, image_);
        height = 10;
        width = 10;
        health = 10;
        image = new ImageIcon("src/textures/homing.png").getImage();
    }
}
