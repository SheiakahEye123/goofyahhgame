import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class tiles2 extends tiles{
    public tiles2(Path src) {
        super(src);
    }


    public void draws(Graphics brush, ArrayList<ArrayList<tile>> tilesos, double x_, double y_) {
        for (int y = 1; y < tilesos.size() - 1 ; y++) {
            for (int x = 1; x < tilesos.get(0).size() - 1; x++) {
                if (x < tilesos.get(y).size() && tilesos.get(y).get(x) != null) {
                    System.out.println(y + " " + x + " " + tilesos.get(y).size());
//                    if (tilesos.get(y).get(x).type().equals("fence1") && (tilesos.get(y - 1).get(x) != null || tilesos.get(y + 1).get(x) != null)) {
//                        tilesos.get(y).get(x).image = new ImageIcon("src/textures/fence2.png").getImage();
//                        tilesos.get(y).get(x).blocktype = "fence2";
//                    }
//                    if (tilesos.get(y).get(x).type().equals("fence2") && (tilesos.get(y).get(x - 1) != null || tilesos.get(y).get(x + 1) != null)) {
//                        tilesos.get(y).get(x).image = new ImageIcon("src/textures/fence2.png").getImage();
//                        tilesos.get(y).get(x).blocktype = "fence1";
//                    }
                    brush.drawImage(tilesos.get(y).get(x).image, (int) ((x + -x_ - Util.globalRenderOffset) * WorldState.tileSize), (int) ((y + -y_ - Util.globalRenderOffset) * WorldState.tileSize), null);
                }
            }
        }

    }

    public void streetTree(int x, int y) {
    }

    public void createRoad(int x, int y) {

    }


}
