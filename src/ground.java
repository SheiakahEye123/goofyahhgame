import javax.swing.*;
import java.awt.*;


public class ground extends tile {
    public ground() {
        breakable = false;
        image = new ImageIcon("src/textures/cobble.jpg").getImage();
        blocktype = "ground";
        Color color = new Color(136,140,141);
    }
}
