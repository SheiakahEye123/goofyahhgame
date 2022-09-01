import java.awt.*;
import java.util.ArrayList;

public class bullet{
    double dirx = 0;
    double diry = 0;
    double x;
    double y;

    public bullet(double dirx_, double diry_) {
        dirx = dirx_;
        diry = diry_;
    }


    public void shoot(Graphics g, ArrayList<ArrayList<tile>> tilesOnScreen) {
        for (int y = 0; y < tilesOnScreen.size(); y++) {
            for (int x = 0; x < tilesOnScreen.get(0).size(); x++) {
                if (tilesOnScreen.get((int) (y)).get((int) (x)) != null) {
                    dirx = 0;
                    diry = 0;
                }
                x += dirx;
                y += diry;
            }
        }
        g.drawLine(960,540,(int)(x * 64),(int)(y * 64));
    }
}
