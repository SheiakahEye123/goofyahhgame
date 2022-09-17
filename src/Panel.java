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

        var tilesWithinScreen = tiles.tilesWithinScreen(g, player.x, player.y);
        var tilesWithinScreen2 = tiles2.tilesWithinScreen(g, player.x, player.y);

        double playerOffsetX = player.x % 1;
        double playerOffsetY = player.y % 1;

        if (!tiles2.isCollided(player.x + player.velx, player.y, tiles2.tileslist)) {
            player.x += player.velx;
        }
        if (!tiles2.isCollided(player.x, player.y + player.vely, tiles2.tileslist)) {
            player.y += player.vely;
        }

        creature.x += creature.velx;
        creature.y += creature.vely;

        dayCycle.Clock();
        //panel.update(tiles, tiles2, Player, dayCycle);
        super.paintComponent (g);
        brush = (Graphics2D) g;

        tiles.draw(g,tilesWithinScreen, playerOffsetX, playerOffsetY);
        tiles2.draws(g,tilesWithinScreen2, playerOffsetX, playerOffsetY);
        creature.pathfind(tilesWithinScreen2);
        creature.draw(g,player.x, player.y);
        player.draw(g);
        inventory.inv.get(0).use();

        var rays = shadows.rayCast(main.screenWidthTiles/2 + playerOffsetX,
                                               main.screenHeightTiles/2 + playerOffsetY,
                                                tilesWithinScreen2, g);

        // shift all X and Y points in ray by playerOffset
        for(var ray : rays) {
            ray.startx -= playerOffsetX;
            ray.endx -= playerOffsetX;
            ray.starty -= playerOffsetY;
            ray.endy -= playerOffsetY;
        }

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

        xpoints[5] = (int) (rays.get(0).endx * 64);
        ypoints[5] = (int) (rays.get(0).endy * 64);

        for (int i = 6; i < rays.size() + 6; i++) {
            xpoints[i] = (int) (rays.get(i - 6).endx * 64);
            ypoints[i] = (int) (rays.get(i - 6).endy * 64);
        }

        xpoints[rays.size() + 6] = (int) (rays.get(0).endx * 64);
        ypoints[rays.size() + 6] = (int) (rays.get(0).endy * 64);

        //g.drawLine(xpoints[rays.size()], ypoints[rays.size()], xpoints[rays.size()+1],ypoints[rays.size()+1]);

        Color skycolor = dayCycle.setSkyColor();

        brush.setColor(new Color(0,0,40, skycolor.getAlpha() + 100));
        brush.fillPolygon(xpoints, ypoints, rays.size() + 7);
        shadows.rayClear();

        brush.setColor(skycolor);
        brush.fillRect(0,0,1920,1080);

        //brush.fillRect(0,0,1920,1080);
        framesRendered += 1;
        player.elapsedFrame = Math.abs(player.startFPS - player.endFPS);
        player.endFPS = player.startFPS;
    }

}
