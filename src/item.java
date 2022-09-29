import java.awt.*;

public class item extends Collision{
    Image img;
    Player player;

    String name;
    item(Player player_){
        player = player_;
    }

    public void use(boolean trigger) {

    }

    public String type() {
        return name;
    }
}
