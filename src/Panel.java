import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel{
    tiles tiles;
    tiles2 tiles2;
    Player player;

    shadows shadows;

    dayCycle dayCycle;

    static int framesRendered;



    Graphics2D brush;
    public Panel(tiles tiles_, tiles2 tiles2_, Player player_, dayCycle dayCycle_, shadows shadows_) {
        tiles = tiles_;
        player = player_;
        tiles2 = tiles2_;
        dayCycle = dayCycle_;
        shadows = shadows_;
    }
    public void paintComponent(Graphics g) {
        player.startFPS = System.nanoTime();
        player.accelerate();

        if (!tiles2.isCollided(tiles2.xadd + player.velx, tiles2.yadd, tiles2)) {
            tiles.xadd += player.velx;
            tiles2.xadd += player.velx;
        }
        if (!tiles2.isCollided(tiles2.xadd, tiles2.yadd + player.vely, tiles2)) {
            tiles.yadd += player.vely;
            tiles2.yadd += player.vely;
        }

        //Player.movex = Listener.movex;
        //Player.movey = Listener.movey;

        dayCycle.Clock();
        //panel.update(tiles, tiles2, Player, dayCycle);
        super.paintComponent (g);
        brush = (Graphics2D) g;
        tiles.draw(g,tiles.tilesWithinScreen());
        tiles2.draws(g,tiles2.tilesWithinScreens());
        player.draw(g);
        //brush.setColor(dayCycle.setSkyColor());
        brush.setColor(Color.red);
        shadows.rayCast(tiles.xadd,tiles.yadd,tiles2, brush);
        //shadows.rayDraw(brush);
        shadows.rayClear();

        //brush.fillRect(0,0,1920,1080);
        framesRendered += 1;
        player.elapsedFrame = Math.abs(player.startFPS - player.endFPS);
        player.endFPS = player.startFPS;
    }
    public void update(tiles tiles_, tiles2 tiles2_, Player player_, dayCycle dayCycle_) {
        tiles = tiles_;
        player = player_;
        tiles2 = tiles2_;
        dayCycle = dayCycle_;
    }
}
