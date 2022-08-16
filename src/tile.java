import java.awt.*;
import java.io.File;

public abstract class tile{
    public Color color;
    boolean breakable;
    Image image;
    int tileHealth;
    boolean moveable;
    String blocktype;
    double x = 0;
    double y = 0;

    public String type() {
        return blocktype;
    }
}
