
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class tiles {
    ArrayList<ArrayList<tile>> tileslist = new ArrayList<ArrayList<tile>>(24);

    double xadd = 0;
    double yadd = 0;

    int tileSize = 64;


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
                System.out.println(line);
            }
        } catch (IOException x) {
            System.err.format("doesnt work");
        }

    }

    public void draw(Graphics brush, ArrayList<ArrayList<tile>> tilesToDraw) {
        for (int y = 0; y < tilesToDraw.size(); y++) {
            for (int x = 0; x < tilesToDraw.get(y).size(); x++) {
                if (tilesToDraw.get(y).get(x) != null) {
                    brush.drawImage(tilesToDraw.get(y).get(x).image, (int) ((x * tileSize)), (int) ((y * tileSize)), null);
                    brush.setColor(tilesToDraw.get(y).get(x).color);
                    brush.fillRect(x*15,y*15,15,15);
                }
            }
        }
    }
    public ArrayList<ArrayList<tile>> tilesWithinScreen(Graphics g) {
        ArrayList<ArrayList<tile>> tilesOnScreen = new ArrayList<ArrayList<tile>>();
        int left = (int)xadd - 17;
        int right = (int)xadd + 17;
        int top = (int)yadd - 12;
        int bottom = (int)yadd + 12;


        for (int y = top; y < bottom; y++) {
            if (y < 0 || y >= tileslist.size()) {
                var ylist = new ArrayList<tile>();
                for (int i = 0; i < 34; i++) {
                    ylist.add(null);
                }
                tilesOnScreen.add(ylist);
                continue;
            }
            var ylist = new ArrayList<tile>();
            for (int x = left; x < right; x++) {
                if (x < 0 || x >= tileslist.get(0).size()) {
                    ylist.add(null);
                }
                else {
                    ylist.add(tileslist.get(y).get(x));
                }
            }
            tilesOnScreen.add(ylist);
        }

        return tilesOnScreen;
    }

}
