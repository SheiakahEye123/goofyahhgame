import javax.swing.*;
import java.awt.event.*;



public class Listener extends JPanel implements KeyListener, ActionListener {
    boolean w;
    boolean a;
    boolean s;
    boolean d;
    boolean jump = false;



    public void Listener() {
        addKeyListener(this);
    }
    public void actionPerformed(ActionEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        int c = e.getKeyCode();

        if (c == KeyEvent.VK_LEFT || c == KeyEvent.VK_A) {
            a = true;
        }
        if (c == KeyEvent.VK_UP || c == KeyEvent.VK_W) {
            w = true;
        }
        if (c == KeyEvent.VK_RIGHT || c == KeyEvent.VK_D) {
            d = true;
        }
        if (c == KeyEvent.VK_DOWN || c == KeyEvent.VK_S) {
            s = true;
        }
        if (c == KeyEvent.VK_SPACE) {
            jump = true;
        }
    }

    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {
        int c = e.getKeyCode();

        if (c == KeyEvent.VK_LEFT || c == KeyEvent.VK_A) {
            a = false;
        }
        if (c == KeyEvent.VK_UP || c == KeyEvent.VK_W) {
            w = false;
        }
        if (c == KeyEvent.VK_RIGHT || c == KeyEvent.VK_D) {
            d = false;
        }
        if (c == KeyEvent.VK_DOWN || c == KeyEvent.VK_S) {
            s = false;
        }
        if (c == KeyEvent.VK_SPACE) {
            jump = false;
        }
    }

}
