import java.util.ArrayList;
import java.util.List;

public class Util {
    public static <T> Boolean inBounds(double x, double y, ArrayList<ArrayList<T>> list) {
        return x >= 0 && y >= 0 && y < list.size() && x < list.get(0).size();
    }
}
