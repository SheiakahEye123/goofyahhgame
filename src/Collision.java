import java.util.ArrayList;

public class Collision extends accelerate{
    public boolean isCollided(double xadd, double yadd, ArrayList<ArrayList<tile>> tilesonscreen, double hitboxX, double hitboxY) {
        if (xadd - hitboxX < 0 || xadd + hitboxX > tilesonscreen.get(0).size() || yadd - hitboxY < 0 || yadd + hitboxY > tilesonscreen.size()) {
            return false;
        }
        if (tilesonscreen.get((int)(yadd - hitboxY)).get((int)(xadd - hitboxX)) != null) {
            System.out.println(tilesonscreen.size());
            return true;
        }
        if (tilesonscreen.get((int)(yadd + hitboxY)).get((int)(xadd + hitboxX)) != null) {
            System.out.println(tilesonscreen.size());
            return true;
        }
        if (tilesonscreen.get((int)(yadd - hitboxY)).get((int)(xadd + hitboxX)) != null) {
            System.out.println(tilesonscreen.size());
            return true;
        }
        if (tilesonscreen.get((int)(yadd + hitboxY)).get((int)(xadd - hitboxX)) != null) {
            System.out.println(tilesonscreen.size());
            return true;
        }

        return false;
    }
    public creature enemyCollided(double x, double y, creature creature, double size) {
        if (Math.hypot(creature.x - x, creature.y - y) <= size) {
            return creature;
        }
        return null;
    }


}
