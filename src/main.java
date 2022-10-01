import javax.swing.*;
import java.nio.file.Path;

public class main {
    static int tileSize = 64;
    static double screenWidthTiles = 30;
    static double screenHeightTiles = 17;

    public static void main (String Args[]) {
        JFrame screen = new JFrame();
        Listener Listener = new Listener();
        Player Player = new Player(Listener);
        Pathfinding pathfinding = new Pathfinding();
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
        Player.inventory.inv.get(0).player = Player;
        var creature = new creature(tiles2,7,8,new ImageIcon("src/textures/guy.png").getImage());
        screen.addKeyListener(Listener);
        screen.setFocusable(true);
        screen.setFocusTraversalKeysEnabled(false);


        //tiles2.tileslist2.get(0).set(0,null);
        //tiles2.tileslist2.get(0).set(1,null);
        //tiles2.tileslist2.get(1).set(1,null);
        //tiles2.tileslist2.get(1).set(0,null);

        Panel panel = new Panel(tiles, tiles2, Player, dayCycle, shadows, creature, pathfinding);
        panel.setSize(1920, 1080);
        screen.add(panel);
        panel.setDoubleBuffered(true);



        while (true) {
            panel.repaint();
        }
    }
}
