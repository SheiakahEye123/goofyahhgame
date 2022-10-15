import javax.swing.*;
import java.awt.*;
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



    ArrayList<creature> creatures = new ArrayList<creature>();

    ArrayList<bullet> bullets = new ArrayList<>();

    public static Point getMouseLocation(){
        int x = MouseInfo.getPointerInfo().getLocation().x - main.screen.getLocation().x;
        int y = MouseInfo.getPointerInfo().getLocation().y - main.screen.getLocation().y;
        return new Point(x,y);
    }
}
