import java.util.ArrayList;

public class Collision {
    public boolean isCollided(double xadd, double yadd, ArrayList<ArrayList<tile>> tilesonscreen, double hitboxX, double hitboxY) {
        if (tilesonscreen.get((int)(yadd - hitboxY)).get((int)(xadd - hitboxX)) != null) {
            return true;
        }
        if (tilesonscreen.get((int)(yadd + hitboxY)).get((int)(xadd + hitboxX)) != null) {
            return true;
        }
        if (tilesonscreen.get((int)(yadd - hitboxY)).get((int)(xadd + hitboxX)) != null) {
            return true;
        }
        if (tilesonscreen.get((int)(yadd + hitboxY)).get((int)(xadd - hitboxX)) != null) {
            return true;
        }
        return false;
    }
}
