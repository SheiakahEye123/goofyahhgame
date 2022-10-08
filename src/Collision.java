import java.util.ArrayList;

public class Collision extends accelerate{
    public boolean isCollided(double xadd, double yadd, ArrayList<ArrayList<tile>> tilesonscreen, double hitboxX, double hitboxY) {
        if (xadd < 0 || xadd > tilesonscreen.get(0).size() || yadd < 0 || yadd > tilesonscreen.size()) {
            return false;
        }
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
    public creature enemyCollided(double x, double y, creature creature, double size) {
        if (Math.hypot(creature.ex - x, creature.ey - y) <= size) {
            return creature;
        }
        return null;
    }
}
