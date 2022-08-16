import javax.swing.*;
import java.nio.file.Path;
import java.util.ArrayList;

public class main {
    public static void main (String Args[]) {
        JFrame screen = new JFrame();
        tiles tiles = new tiles(Path.of("src/textures/map.txt"));
        tiles2 tiles2 = new tiles2(Path.of("src/textures/map2.txt"));
        screen.setSize(1920,1080);
        screen.setExtendedState(JFrame.MAXIMIZED_BOTH);
        screen.setUndecorated(false);
        screen.setVisible(true);
        screen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        int fps = 0;

        dayCycle dayCycle = new dayCycle();
        shadows shadows = new shadows(dayCycle,tiles2);

        Listener Listener = new Listener();
        Player Player = new Player(Listener);
        inventory inventory = new inventory(Player.vely, Player.velx);
        var creature = new creature(tiles2,1,1,new ImageIcon("src/textures/guy.png").getImage(), Player.listener);
        screen.addKeyListener(Listener);
        screen.setFocusable(true);
        screen.setFocusTraversalKeysEnabled(false);


        //tiles2.tileslist2.get(0).set(0,null);
        //tiles2.tileslist2.get(0).set(1,null);
        //tiles2.tileslist2.get(1).set(1,null);
        //tiles2.tileslist2.get(1).set(0,null);

        Panel panel = new Panel(tiles, tiles2, Player, dayCycle, shadows, creature, inventory);
        panel.setSize(1920, 1080);
        screen.add(panel);
        panel.setDoubleBuffered(true);
        panel.tiles2.xadd = 10;
        panel.tiles2.yadd = 10;
        panel.tiles.xadd = 10;
        panel.tiles.yadd = 10;



        while (true) {
            panel.repaint();
        }
    }
}
