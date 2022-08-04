import javax.swing.*;
import java.awt.*;


public class bloodwater extends tile {

    public bloodwater() {
        breakable = false;
        image = new ImageIcon("src/textures/large.jpg").getImage();
        blocktype = "bloodwater";
    }
}
