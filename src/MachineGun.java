import javax.swing.*;

public class MachineGun extends weapon{
    public MachineGun() {
        super();
        img = new ImageIcon("src/textures/scythe.png").getImage();
        name = "Machine Gun";
        time = System.nanoTime();
        seconds = 0.001;
        dmg = 10;
        speed = 2;
    }
}
