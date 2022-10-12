import kotlin.Pair;

import java.awt.*;

public class QuadTree {
    WorldState worldstate = new WorldState();
    public Pair<Point,Point> split(int sMinBoundX, int sMinBoundY, int sMaxBoundX, int sMaxBoundY){

        Point size = new Point(maxBoundsX/4,maxBoundsY/4);
        if (size.x != 1 & size.y != 1) {
            int subRectX = maxBoundsX/2;
            int subRectY = maxBoundsY/2;
        }
        return new Pair(new Point(sMinBoundX,sMinBoundY),new Point(sMaxBoundX, sMaxBoundY));
    }
}
