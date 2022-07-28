
import java.awt.*;
import java.util.ArrayList;

public class tiles {
    ArrayList<ArrayList<tile>> tiles = new ArrayList<ArrayList<tile>>();
    double xadd = 0;
    double yadd = 0;

    int tileSize = 64;

    public void draw(Graphics brush, ArrayList<ArrayList<tile>> tilesToDraw) {
        for (int y = 0; y < tilesToDraw.size(); y++) {
            for (int x = 0; x < tilesToDraw.get(y).size(); x++) {
                if (tilesToDraw.get(y).get(x) != null) {
                    brush.drawImage(tilesToDraw.get(y).get(x).image, (int) (((x + -xadd) * tileSize) + 960), (int) (((y + -yadd) * tileSize) + 540), null);
                }

            }
        }
    }

    public ArrayList<ArrayList<tile>> tilesWithinScreen() {
        var tilesOnScreen = new ArrayList<ArrayList<tile>>();
        var ylist = new ArrayList<tile>();

        for (int y = 0; y < tiles.size(); y++) {
            var rowArray = new ArrayList<tile>();
            if ((yadd - 11) < y && y < (yadd + 11)) {
                if (tiles.get(y) == null) {
                    tilesOnScreen.add(tiles.get(y));
                }
                for (int x = 0; x < tiles.get(y).size(); x++) {
                    if ((xadd - 17) < x && x < (xadd + 17)) {
                        rowArray.add(tiles.get(y).get(x));
                    }
                }
                tilesOnScreen.add(rowArray);
            }
        }
        return tilesOnScreen;
    }

}
