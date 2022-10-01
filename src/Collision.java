import java.util.ArrayList;

public class Collision {
    public static boolean isCollided(double xadd, double yadd, ArrayList<ArrayList<tile>> tilesonscreen, double hitboxX, double hitboxY) {
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
    public boolean enemyCollided(double x, double y, double ex, double ey) {
        if (Math.hypot(ex - x, ey - y) <= 0.1) {
            return true;
        }
        return false;
    }
}
