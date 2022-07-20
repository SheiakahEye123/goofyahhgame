
import java.awt.*;
import java.util.ArrayList;

public class tiles {
    ArrayList<ArrayList<tile>> tiles = new ArrayList<ArrayList<tile>>();
    double xadd = 0;
    double yadd = 0;

    int tileSize = 64;

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
