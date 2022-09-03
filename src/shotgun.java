import javax.swing.*;

public class shotgun extends item{
    Player player;
    public shotgun(Player player_) {
        super(player_);
        player = player_;
        img = new ImageIcon("src/textures/shotgun.png").getImage();
    }

    public void use() {
        var one = new bullet(0,0.1, 960, 540);
        var two = new bullet(0.1,0.1, 960, 540);
        var three = new bullet(-0.1,0.1, 960, 540);
        one.shoot();
        two.shoot();
        three.shoot();
    }

}
