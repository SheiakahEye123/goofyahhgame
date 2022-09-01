import javax.swing.*;

public class shotgun extends item{
    Player player;
    public shotgun(Player player_) {
        super(player_);
        player = player_;
        img = new ImageIcon("src/textures/shotgun.png").getImage();
    }

    public void use() {
        new bullet(0,0.1);
        new bullet(0.1,0.1);
        new bullet(-0.1,0.1);
    }

}
