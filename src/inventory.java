import javax.swing.*;
import java.awt.*;
import java.util.*;

public class inventory {
    ArrayList<Object> inv = new ArrayList<Object>();
    Image quickbarimg = new ImageIcon("src/textures/quickbar.png").getImage();
    int selecteditem;
    public inventory() {
        selecteditem = 0;
    }
    public void draw(Graphics g) {
        g.drawImage(quickbarimg, 960 - 128, 800,null);
        if (inv.get(selecteditem) != null && inv.get(selecteditem) instanceof item) {
            ((item) inv.get(selecteditem)).draw();
        }
    }
}
