import javax.swing.*;

public class MosinNagant extends weapon{
    public MosinNagant() {
        super();
        img = new ImageIcon("src/textures/scythe.png").getImage();
        name = "Mosin Nagant";
        time = System.nanoTime();
        seconds = 2;
        dmg = 100;
        speed = 5;
    }
}
