import javax.swing.*;
import java.awt.*;


public class ground extends tile {
    public ground(boolean b, ImageIcon icon) {
        breakable = b;
        image = icon.getImage();
        blocktype = "ground";
    }
}
