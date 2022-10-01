import java.awt.*;

public class bullet extends Collision{
    double x;
    double y;
    double dmg;
    double size;
    boolean hostile;
    String type;

    public bullet(double x_, double y_, double dmg_, double size_, boolean hostile_, String type_) {
        x = x_;
        y = y_;
        dmg = dmg_;
        size = size_;
        hostile = hostile_;
        type = type_;
    }

    public void draw(WorldState worldstate, Graphics g) {
        g.setColor(Color.red);
        g.drawRect((int) ((x - worldstate.Player.x) * WorldState.tileSize + 960), (int) ((y - worldstate.Player.y) * WorldState.tileSize + 540), 10, 10);
    }
}
