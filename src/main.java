import javax.swing.*;
import java.nio.file.Path;

public class main {
    static JFrame screen = new JFrame();
    static WorldState worldstate = new WorldState();
    public static void main (String Args[]) {
        screen.setSize(1920,1080);
        screen.setExtendedState(JFrame.MAXIMIZED_BOTH);
        screen.setUndecorated(false);
        screen.setVisible(true);
        screen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        screen.addKeyListener(worldstate.Listener);
        screen.setFocusable(true);
        screen.setFocusTraversalKeysEnabled(false);
        Panel panel = new Panel(worldstate);
        panel.setSize(1920, 1080);
        screen.add(panel);
        panel.setDoubleBuffered(true);
        while (true) {
            panel.repaint();
        }
    }
}
