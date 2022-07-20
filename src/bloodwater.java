import javax.swing.*;
import java.awt.*;


public class bloodwater extends tile {

    public bloodwater(boolean b, ImageIcon icon) {
        breakable = b;
        image = icon.getImage();
        blocktype = "bloodwater";
    }
}
