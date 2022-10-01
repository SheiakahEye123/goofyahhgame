import java.util.ArrayList;

public class Collision extends accelerate{
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
    public boolean enemyCollided(double x, double y, double ex, double ey, double size) {
        if (Math.hypot(ex - x, ey - y) <= size) {
            return true;
        }
        return false;
    }
}
