import java.awt.*;
import java.util.ArrayList;

public class item extends Collision{
    Image img;
    Player player;

    long time;

    String name;
    item(Player player_){
        player = player_;
    }

    public item() {

    }

    public String type() {
        return name;
    }

    public void use(boolean e, Graphics g, ArrayList<ArrayList<tile>> tilesOnScreen, WorldState worldstate) {
    }
}
