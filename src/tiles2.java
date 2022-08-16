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
    public boolean isCollided(double xadd, double yadd, tiles2 tiles2) {
        if (xadd >= tiles2.tileslist.get(0).size() - 1.5|| yadd >= tiles2.tileslist.size() - 1.5) {

            return true;
        }
        if (xadd <= 0.5 || yadd <= 0.5) {
            return true;
        }
        if (tiles2.tileslist.get((int)(yadd - 0.45)).get((int)(xadd - 0.45)) != null) {

            return true;
        }
        if (tiles2.tileslist.get((int)(yadd + 0.45)).get((int)(xadd + 0.45)) != null) {

            return true;
        }
        if (tiles2.tileslist.get((int)(yadd - 0.45)).get((int)(xadd + 0.45)) != null) {

            return true;
        }
        if (tiles2.tileslist.get((int)(yadd + 0.45)).get((int)(xadd - 0.45)) != null) {

            return true;
        }
        return false;
    }

    public void draws(Graphics brush, ArrayList<ArrayList<tile>> tilesos, double x_, double y_) {
        for (int y = 0; y < tilesos.size(); y++) {
            for (int x = 0; x < tilesos.get(y).size(); x++) {
                if (tilesos.get(y).get(x) != null) {
                    if (y > 0 && y < tilesos.size() - 1) {
                        if (tilesos.get(y).get(x).type() == "fence1" && (tilesos.get(y - 1).get(x) != null || tilesos.get(y + 1).get(x) != null)) {
                            tilesos.get(y).get(x).image = new ImageIcon("src/textures/fence2.png").getImage();
                            tilesos.get(y).get(x).blocktype = "fence2";
                        }
                    }
                    if (x > 0 && x < tilesos.get(0).size() - 1) {
                        if (tilesos.get(y).get(x).type() == "fence2" && (tilesos.get(y).get(x - 1) != null || tilesos.get(y).get(x + 1) != null)) {
                            tilesos.get(y).get(x).image = new ImageIcon("src/textures/fence2.png").getImage();
                            tilesos.get(y).get(x).blocktype = "fence1";
                        }
                    }
                    brush.drawImage(tilesos.get(y).get(x).image, (int) ((x + -x_)* tileSize), (int) ((y + -y_) * tileSize), null);
                    brush.setColor(Color.red);
                    brush.fillRect(x*15,y*15,15,15);
                }
            }
        }
    }

    public void streetTree(int x, int y) {
    }

    public void createRoad(int x, int y) {

    }


}
