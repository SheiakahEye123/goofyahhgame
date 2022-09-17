import java.nio.file.Path;
import java.util.ArrayList;

public class pathfind {
    public static void main(String[] args) {
        var tiles2 = new tiles2(Path.of("src/textures/map2.txt")).tileslist;
        var grid = new ArrayList<ArrayList<Integer>>();
        var nodegrid = new ArrayList<ArrayList<String>>();
        int nodes = 0;
        int originx = 1;
        int originy = 1;
        int endx;
        int endy;

        for (int y = 0; y < tiles2.size(); y++) {
            var row = new ArrayList<Integer>();
            var noderow = new ArrayList<String>();
            for (int x = 0; x < tiles2.get(0).size(); x++) {
                if (tiles2.get(y).get(x) != null) {
                    row.add(-1);
                    noderow.add("#");
                }
                if (tiles2.get(y).get(x) == null) {
                    row.add(0);
                    noderow.add("*");
                    nodes++;
                }
            }
            grid.add(row);
        }

        for (int i = 0; i < grid.size(); i++) {
            System.out.println(grid.get(i));
        }

        grid.get(originy).set(originx, 0);
        nodegrid.get(originy).set(originx, "o");


        for (int d = 1; nodes > 0
    }
}
