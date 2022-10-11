import java.awt.*;

public class QuadTree {
    WorldState worldstate = new WorldState();
    public void split(){
        int maxBoundsX = worldstate.tiles.tileslist.get(0).size();
        int maxBoundsY = worldstate.tiles.tileslist.size();
        int minBoundsX = 0;
        int minBoundsY = 0;

        Point size = new Point(maxBoundsX/4,maxBoundsY/4);
        if (size.x != 1 & size.y != 1) {
            int subRectX = maxBoundsX/2;
            int subRectY = maxBoundsY/2;
        }


    }
}
