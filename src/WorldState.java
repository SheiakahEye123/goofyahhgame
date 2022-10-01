import javax.swing.*;
import java.nio.file.Path;
import java.util.ArrayList;

public class WorldState {
    static int tileSize = 64;

    static double screenWidthTiles = 30;

    static double screenHeightTiles = 17;

    Listener Listener = new Listener();

    Player Player = new Player(Listener);

    Pathfinding pathfinding = new Pathfinding();

    tiles tiles = new tiles(Path.of("src/textures/map.txt"));

    tiles2 tiles2 = new tiles2(Path.of("src/textures/map2.txt"));

    dayCycle dayCycle = new dayCycle();

    shadows shadows = new shadows(dayCycle,tiles2);

    creature creature = new creature(tiles2,7,8,new ImageIcon("src/textures/guy.png").getImage());

    ArrayList<bullet> bullets = new ArrayList<>();
}
