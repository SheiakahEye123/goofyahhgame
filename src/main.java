import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Objects;

public class main {
    public static void main (String Args[]) {
        JFrame screen = new JFrame();
        tiles tiles = new tiles();
        tiles2 tiles2 = new tiles2();
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
        screen.addKeyListener(Listener);
        screen.setFocusable(true);
        screen.setFocusTraversalKeysEnabled(false);



        for (int i = 0; i < 17; i++) {
            ArrayList<tile> ylist = new ArrayList<tile>();
            for (int e = 0; e < 30; e++) {
                ylist.add(new ground(false, new ImageIcon("src/textures/cobble.jpg")));
            }
            tiles.tiles.add(ylist);
        }

        for (int i2 = 0; i2 < 30; i2++) {
            ArrayList<tile> ylistw = new ArrayList<tile>();
            for (int e2 = 0; e2 < 17; e2++) {
                if (Math.random() < 0.2) {
                    ylistw.add(new ground(false, new ImageIcon("src/textures/large.jpg")));
                }
                else {
                    ylistw.add(null);
                }

            }
            tiles2.tiles.add(ylistw);
        }

        Panel panel = new Panel(tiles, tiles2, Player, dayCycle, shadows);
        panel.setSize(1920, 1080);
        screen.add(panel);
        panel.setDoubleBuffered(true);
        panel.tiles2.xadd = 1;
        panel.tiles2.yadd = 1;
        panel.tiles.xadd = 1;
        panel.tiles.yadd = 1;



        while (true) {
            panel.repaint();
        }
    }
}
