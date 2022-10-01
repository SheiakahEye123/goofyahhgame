
import com.sun.tools.javac.Main;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class tiles extends Collision{
    ArrayList<ArrayList<tile>> tileslist = new ArrayList<ArrayList<tile>>(24);

    public tiles(Path src) {

        try (BufferedReader reader = Files.newBufferedReader(src)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                var ylist = new ArrayList<tile>();
                for (int i = 0; i < line.length(); i++) {
                    switch (line.charAt(i)) {
                        case '@' : {
                            ylist.add(new bloodwater());
                            break;
                        }
                        case '#' : {
                            ylist.add(new ground());
                            break;
                        }
                        case '$' : {
                            ylist.add(new fence());
                            break;
                        }
                        case ',' : {
                            ylist.add(null);
                            break;
                        }
                    }
                }
                tileslist.add(ylist);
            }
        } catch (IOException e) {
            System.err.format("doesnt work");
        }

    }

    public void draw(Graphics brush, ArrayList<ArrayList<tile>> tilesToDraw, double x_, double y_) {
        for (int y = 0; y < tilesToDraw.size(); y++) {
            for (int x = 0; x < tilesToDraw.get(y).size(); x++) {
                if (tilesToDraw.get(y).get(x) != null) {
                    brush.drawImage(tilesToDraw.get(y).get(x).image, (int) ((x + -x_) * WorldState.tileSize), (int) ((y + -y_) * WorldState.tileSize), null);
                    brush.setColor(tilesToDraw.get(y).get(x).color);
                    brush.fillRect(x*15,y*15,15,15);
                }
            }
        }
    }
    public ArrayList<ArrayList<tile>> tilesWithinScreen(Graphics g, double x, double y) {
        ArrayList<ArrayList<tile>> tilesOnScreen = new ArrayList<ArrayList<tile>>();
        double left = x - WorldState.screenWidthTiles/2;
        double right = x + WorldState.screenWidthTiles/2;
        double top = y - WorldState.screenHeightTiles/2;
        double bottom = y + WorldState.screenHeightTiles/2;


        for (double i = top; i < bottom; i++) {
            if (i < 0 || i >= tileslist.size()) {
                var ylist = new ArrayList<tile>();
                for (int e = 0; e < WorldState.screenWidthTiles; e++) {
                    ylist.add(null);
                }
                tilesOnScreen.add(ylist);
                continue;
            }
            else {
                var ylist = new ArrayList<tile>();
                for (double a = left; a < right; a++) {
                    if (a < 0 || a >= tileslist.get(0).size()) {
                        ylist.add(null);
                    } else {
                        ylist.add(tileslist.get((int) i).get((int) a));
                    }
                }
                tilesOnScreen.add(ylist);
            }
        }

        return tilesOnScreen;
    }

}
