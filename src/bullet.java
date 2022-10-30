import java.awt.*;

public class bullet extends Collision{
    double x;
    double y;
    double dmg;
    double size;
    boolean hostile;
    String type;
    double velx;
    double vely;
    Hitbox hitbox;

    public bullet(double x_, double y_, double dmg_, double size_, boolean hostile_, String type_, double velx_, double vely_) {
        x = x_;
        y = y_;
        dmg = dmg_;
        size = size_;
        hostile = hostile_;
        type = type_;
        velx = velx_;
        vely = vely_;
        hitbox = new Hitbox(x,y,x+size,y+size);
    }

    public void draw(WorldState worldstate, Graphics g, Color color) {
        g.setColor(color);
        g.drawRect((int) ((x - worldstate.Player.x) * WorldState.tileSize + 960), (int) ((y - worldstate.Player.y) * WorldState.tileSize + 540), 10, 10);
    }
    public void bulletMotion(WorldState worldstate) {
        x += velx;
        y += vely;
        hitbox = new Hitbox(x,y,x+size,y+size);
    }
}
