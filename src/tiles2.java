import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class tiles2 extends tiles{
    ArrayList<ArrayList<tile>> tiles = new ArrayList<ArrayList<tile>>();
    public boolean isCollided(double xadd, double yadd, tiles2 tiles2) {
        if (xadd >= tiles2.tiles.get(0).size() - 1.5|| yadd >= tiles2.tiles.size() - 1.5) {
            return true;
        }
        if (xadd <= 0.5 || yadd <= 0.5) {
            return true;
        }
        if (tiles2.tiles.get((int)(yadd - 0.45)).get((int)(xadd - 0.45)) != null) {
            return true;
        }
        if (tiles2.tiles.get((int)(yadd + 0.45)).get((int)(xadd + 0.45)) != null) {
            return true;
        }
        if (tiles2.tiles.get((int)(yadd - 0.45)).get((int)(xadd + 0.45)) != null) {
            return true;
        }
        if (tiles2.tiles.get((int)(yadd + 0.45)).get((int)(xadd - 0.45)) != null) {
            return true;
        }
        return false;
    }

    public void draws(Graphics brush, ArrayList<ArrayList<tile>> tilesos) {
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
                    brush.drawImage(tilesos.get(y).get(x).image, (int) (((x + -xadd) * tileSize) + 960), (int) (((y + -yadd) * tileSize) + 540), null);
                }
            }
        }
    }

    public ArrayList<ArrayList<tile>> tilesWithinScreens() {
        var tilesOnScreen = new ArrayList<ArrayList<tile>>();
        //var ylist = new ArrayList<tile>();

        for (int y = 0; y < tiles.size(); y++) {
            if ((yadd - 13.0) < y && y < (yadd + 13.0)) {
                ArrayList<tile> rowArray = new ArrayList<tile>();
                for (int x = 0; x < tiles.get(y).size(); x++) {
                    if ((xadd - 17.0) < x && x < (xadd + 17.0)) {
                        rowArray.add(tiles.get(y).get(x));
                    }
                }
                tilesOnScreen.add(rowArray);
            }
        }
        return tilesOnScreen;
    }

    public void streetTree(int x, int y) {
    }

    public void createRoad(int x, int y) {

    }


}
