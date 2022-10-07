import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel{
    tiles tiles;
    tiles2 tiles2;
    Player player;

    shadows shadows;

    dayCycle dayCycle;

    static int framesRendered;

    creature creature;

    inventory inventory;

    Pathfinding pathfinding;

    WorldState worldstate;

    static long elapsedFrame,startFPS=System.nanoTime(),endFPS=System.nanoTime();

    Graphics2D brush;
    public Panel(WorldState worldstate) {
        tiles = worldstate.tiles;
        player = worldstate.Player;
        tiles2 = worldstate.tiles2;
        dayCycle = worldstate.dayCycle;
        shadows = worldstate.shadows;
        creature = worldstate.creature;
        pathfinding = worldstate.pathfinding;
        this.worldstate = worldstate;
    }
    public void paintComponent(Graphics g) {
        startFPS = System.nanoTime();
        player.accelerate(player.listener.w,player.listener.a,player.listener.s,player.listener.d,player.listener.jump,0.00000000000015);
        //creature.listener = player.listener;

        var tilesWithinScreen = tiles.tilesWithinScreen(g, player.x, player.y);
        var tilesWithinScreen2 = tiles2.tilesWithinScreen(g, player.x, player.y);

        double playerOffsetX = player.x % 1;
        double playerOffsetY = (player.y + 0.5) % 1;

        if (!tiles2.isCollided(player.x + player.velx, player.y, tiles2.tileslist, 0.45, 0.45)) {
            player.x += player.velx;
        }
        if (!tiles2.isCollided(player.x, player.y + player.vely, tiles2.tileslist, 0.45, 0.45)) {
            player.y += player.vely;
        }

        creature.ex += creature.velx;
        creature.ey += creature.vely;

        dayCycle.Clock();
        //panel.update(tiles, tiles2, Player, dayCycle);
        super.paintComponent (g);
        brush = (Graphics2D) g;

        tiles.draw(g,tilesWithinScreen, playerOffsetX, playerOffsetY);
        tiles2.draws(g,tilesWithinScreen2, playerOffsetX, playerOffsetY);
        pathfinding.pathfind((int) (player.x), (int) (player.y));
        creature.move(Pathfinding.intmap,(int) player.x,(int) player.y);
        creature.draw(g,player.x, player.y);
        player.draw(g);

        for (item i : player.inventory.inv) {
            i.use(player.listener.e, g, tilesWithinScreen2, worldstate);
        }
        for (bullet b : worldstate.bullets) {
            b.draw(worldstate,g);
            b.bulletMotion(worldstate);
        }

        //player.inventory.inv.get(0).use(player.listener.e, g, tilesWithinScreen2);
        //System.out.println(player.inventory.inv);

        var rays = shadows.rayCast(WorldState.screenWidthTiles/2 + playerOffsetX,
                WorldState.screenHeightTiles/2 + playerOffsetY,
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
        elapsedFrame = Math.abs(startFPS - endFPS);
        endFPS = startFPS;
    }

}
