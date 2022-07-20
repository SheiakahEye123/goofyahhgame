import java.awt.*;
import java.io.File;

public abstract class tile{
    boolean breakable;
    Image image;
    int tileHealth;
    boolean moveable;
    String blocktype;

    public String type() {
        return blocktype;
    }
}
