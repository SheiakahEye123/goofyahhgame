import javax.swing.*;

public class MosinNagant extends weapon{
    public MosinNagant() {
        super();
        img = new ImageIcon("src/textures/scythe.png").getImage();
        name = "weapon";
        time = System.nanoTime();
        seconds = 0.5;
        dmg = 100;
    }
}
