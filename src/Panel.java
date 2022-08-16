import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.Comparator;

public class Panel extends JPanel{
    tiles tiles;
    tiles2 tiles2;
    Player player;

    shadows shadows;

    dayCycle dayCycle;

    static int framesRendered;

    creature creature;

    inventory inventory;

    Graphics2D brush;
    public Panel(tiles tiles_, tiles2 tiles2_, Player player_, dayCycle dayCycle_, shadows shadows_, creature creature_, inventory inventory_) {
        tiles = tiles_;
        player = player_;
        tiles2 = tiles2_;
        dayCycle = dayCycle_;
        shadows = shadows_;
        creature = creature_;
        inventory = inventory_;
    }
    public void paintComponent(Graphics g) {
        player.startFPS = System.nanoTime();
        player.accelerate();
        creature.accelerate();
        creature.listener = player.listener;

        player.x += player.velx;
        player.y += player.vely;

        if (!tiles2.isCollided(player.x + player.velx, player.y, tiles2)) {
            player.x += player.velx;
            //System.out.println(tiles2.xadd + "/" + tiles2.yadd);
        }
        if (!tiles2.isCollided(player.x, player.y + player.vely, tiles2)) {
            player.y += player.vely;

        }

        creature.x += creature.velx;
        creature.y += creature.vely;




        //Player.movex = Listener.movex;
        //Player.movey = Listener.movey;

        dayCycle.Clock();
        //panel.update(tiles, tiles2, Player, dayCycle);
        super.paintComponent (g);
        brush = (Graphics2D) g;

        var tilesWithinScreen = tiles.tilesWithinScreen(g, player.x, player.y);
        var tilesWithinScreen2 = tiles2.tilesWithinScreen(g, player.x, player.y);

        tiles.draw(g,tilesWithinScreen, player.x % 1, player.y % 1);
        tiles2.draw(g,tilesWithinScreen2, player.x % 1, player.y % 1);
        creature.draw(g,player.x, player.y);
        player.draw(g);

        var rays = shadows.rayCast(8.5,6,tiles2, g, dayCycle.dayCounter%1);
        //shadows.rayDraw(brush);
        //System.out.println(shadows.xpoints[1]);

        int i1 = (rays.size() + 20);
        int[] xpoints = new int[i1];
        int[] ypoints = new int[i1];

        xpoints[0] = 0;
        ypoints[0] = 0;

        xpoints[1] = 1920;
        ypoints[1] = 0;

        xpoints[2] = 1920;
        ypoints[2] = 1080;

        xpoints[3] = 0;
        ypoints[3] = 1080;

        xpoints[4] = 0;
        ypoints[4] = 0;

        xpoints[5] = (int) ((rays.get(0).endx - player.x) * 64 + 960);
        ypoints[5] = (int) ((rays.get(0).endy - player.y) * 64 + 540);

        for (int i = 6; i < rays.size() + 6; i++) {
            xpoints[i] = (int) ((rays.get(i - 6).endx - player.x) * 64 + 960);
            ypoints[i] = (int) ((rays.get(i - 6).endy - player.y) * 64 + 540);
        }

        xpoints[rays.size() +  6] = (int) ((rays.get(0).endx - player.x) * 64 + 960);
        ypoints[rays.size() + 6] = (int) ((rays.get(0).endy - player.y) * 64 + 540);

        //g.drawLine(xpoints[rays.size()], ypoints[rays.size()], xpoints[rays.size()+1],ypoints[rays.size()+1]);

        Color skycolor = dayCycle.setSkyColor();

        brush.setColor(new Color(0,0,40, skycolor.getAlpha()));
        brush.fillPolygon(xpoints, ypoints, rays.size() + 7);
        shadows.rayClear();

        brush.setColor(skycolor);
        brush.fillRect(0,0,1920,1080);

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
