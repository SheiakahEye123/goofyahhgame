import java.awt.*;

public class item {
    Image img;
    Player player;
    item(Player player_){
        player = player_;
    }
    public void use() {
        new bullet(0,0.1);
        new bullet(0.1,0.1);
        new bullet(-0.1,0.1);
    }

    public void shoot() {
        new bullet(0,0.1);
        new bullet(0.1,0.1);
        new bullet(-0.1,0.1);
    }
}
