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

    public void draw(Graphics brush) {
        for (int y = 0; y < tiles.size(); y++) {
            for (int x = 0; x < tiles.get(y).size(); x++) {
                if (tiles.get(y).get(x) != null) {
                    brush.drawImage(tiles.get(y).get(x).image, (int) (((x + -xadd) * tileSize) + 960), (int) (((y + -yadd) * tileSize) + 540), null);
                }
            }
        }
    }
}
