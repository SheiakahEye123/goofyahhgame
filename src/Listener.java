import javax.swing.*;
import java.awt.event.*;



public class Listener extends JPanel implements KeyListener, MouseListener, ActionListener {
    boolean w;
    boolean a;
    boolean s;
    boolean d;
    boolean e;
    boolean jump = false;

    double mousex;
    double mousey;

    boolean button1;
    boolean button2;
    boolean button3;



    public void Listener() {
        addKeyListener(this);
        addMouseListener(this);
    }
    public void actionPerformed(ActionEvent E) {
    }

    public void keyPressed(KeyEvent E) {
        int c = E.getKeyCode();

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
        if (c == KeyEvent.VK_E) {
            e = true;
        }
        if (c == KeyEvent.VK_SPACE) {
            jump = true;
        }
    }

    public void keyTyped(KeyEvent E) {}
    public void keyReleased(KeyEvent E) {
        int c = E.getKeyCode();

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
        if (c == KeyEvent.VK_E) {
            e = false;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int c = e.getButton();
        if (c == MouseEvent.BUTTON1) {
            button1 = true;
            mousex = e.getX();
            mousey = e.getY();
        }
        if (c == MouseEvent.BUTTON2) {
            button2 = true;
            mousex = e.getX();
            mousey = e.getY();
        }
        if (c == MouseEvent.BUTTON3) {
            button3 = true;
            mousex = e.getX();
            mousey = e.getY();
        }
        if (c == MouseEvent.NOBUTTON) {
            button1 = false;
            button2 = false;
            button3 = false;
            mousex = e.getX();
            mousey = e.getY();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int c = e.getButton();
        if (c == MouseEvent.BUTTON1) {
            button1 = false;
            mousex = e.getX();
            mousey = e.getY();
        }
        if (c == MouseEvent.BUTTON2) {
            button2 = false;
            mousex = e.getX();
            mousey = e.getY();
        }
        if (c == MouseEvent.BUTTON3) {
            button3 = false;
            mousex = e.getX();
            mousey = e.getY();
        }
        if (c == MouseEvent.NOBUTTON) {
            button1 = false;
            button2 = false;
            button3 = false;
            mousex = e.getX();
            mousey = e.getY();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
