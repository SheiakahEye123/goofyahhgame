import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Panel extends JPanel{
    tiles tiles;
    tiles2 tiles2;
    Player player;

    shadows shadows;

    dayCycle dayCycle;

    static int framesRendered;

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

        dayCycle.Clock();
        //panel.update(tiles, tiles2, Player, dayCycle);
        super.paintComponent (g);
        brush = (Graphics2D) g;


        if (dayCycle.timeOfDay >= 0.8 && Math.random() <= 0.0000003 * Panel.elapsedFrame) {
            creature creatureToAdd = new creature(tiles2,
                    (int) (tiles.tileslist.get(0).size() * Math.random()),
                    (int) (tiles.tileslist.size() * Math.random()),
                    new ImageIcon("src/textures/guy.png").getImage());
            if (!tiles2.isCollided(creatureToAdd.x, creatureToAdd.y, tiles2.tileslist, 0.45, 0.45)) {
                worldstate.creatures.add(creatureToAdd);
            }
        }
        tiles.draw(g,tilesWithinScreen, playerOffsetX, playerOffsetY);
        tiles2.draws(g,tilesWithinScreen2, playerOffsetX, playerOffsetY);
        pathfinding.pathfind((int) (player.x), (int) (player.y));
        player.draw(g);
        for(creature creature : worldstate.creatures) {
            creature.x += creature.velx;
            creature.y += creature.vely;
            creature.move(Pathfinding.intmap,(int) player.x,(int) player.y);
            creature.draw(g,player.x, player.y);
        }

        for (item i : player.inventory.inv) {
            i.use(player.listener.e, g, tilesWithinScreen2, worldstate);
        }
        ArrayList<bullet> index = new ArrayList<bullet>();
        for (int b = 0; b < worldstate.bullets.size(); b++) {
            worldstate.bullets.get(b).draw(worldstate,g);
            worldstate.bullets.get(b).bulletMotion(worldstate);
            if (!worldstate.bullets.get(b).isCollided(worldstate.bullets.get(b).x,worldstate.bullets.get(b).y,tiles2.tileslist,0.1,0.1)) {
                index.add(worldstate.bullets.get(b));
            }
        }
        worldstate.bullets = index;
        //for (int i = 0; i < 1000; i++) {
            //xCoords[i] = Math.pow(Math.random(), 2) * 1000;
            //yCoords[i] = Math.pow(Math.random(), 2) * 1000;
        //}
//        var tree = new QuadTree(0,new Boundry(0,0,tiles.tileslist.get(0).size(),tiles.tileslist.get(0).size()));
//        BufferedImage image = null;
//        try {
//            image = QuadTreeVisualizer.drawQuadTree(tree);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        Graphics get = image.createGraphics();
//        for (bullet bullet : worldstate.bullets) {
//            tree.insert(new Node(bullet));
//            get.setColor(Color.RED);
//            get.drawOval((int)bullet.x*100,(int)bullet.y*100,1*100,1*100);
//        }
//        for (creature creature : worldstate.creatures) {
//            tree.insert(new Node(creature));
//            get.setColor(Color.BLACK);
//            get.drawOval((int)creature.x*100,(int)creature.y*100,10*100,10*100);
//        }
//        g.drawImage(image,0,0,500,500,null);

        var tree = new QuadTree(0,new Boundry(0,0,tiles.tileslist.get(0).size(),tiles.tileslist.get(0).size()));
        for (bullet bullet : worldstate.bullets) {
            tree.insert(new Node(bullet));
        }
        for (creature creature : worldstate.creatures) {
            tree.insert(new Node(creature));
        }
        BufferedImage image = null;
        try {
            image = QuadTreeVisualizer.drawQuadTree(tree);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Graphics get = image.createGraphics();
        for (bullet bullet : worldstate.bullets) {
            get.setColor(Color.BLACK);
            get.drawOval((int)bullet.x,(int)bullet.y,1,1);
        }
        for (creature creature : worldstate.creatures) {
            get.setColor(Color.BLACK);
            get.drawOval((int)creature.x,(int)creature.y,10,10);
        }
        g.drawImage(image,0,0,500,500,null);


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
