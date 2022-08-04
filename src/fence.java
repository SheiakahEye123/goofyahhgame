import javax.swing.*;
import java.awt.*;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageProducer;

public class fence extends tile{
    public fence() {
        breakable = false;
        image = new ImageIcon("src/textures/fence1.png").getImage();
        blocktype = "fence1";
    }


}
