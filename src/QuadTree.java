import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


class Node {
    int x,y;
    Object obj;
    public Node(Object obj_) {
        obj = obj_;
    }
    public int getX() {
        if (obj instanceof bullet) {
            return (int) ((bullet)obj).x;
        }
        if (obj instanceof creature) {
            return (int) ((creature)obj).x;
        }
        throw new RuntimeException("not");
    }
    public int getY() {
        if (obj instanceof bullet) {
            return (int) ((bullet) obj).y;
        }
        if (obj instanceof creature) {
            return (int) ((creature) obj).y;
        }
        throw new RuntimeException("not");
    }
}

/*
 *  			N
 *  		W		E
 *  			S
 */

class Boundry {
    public int getxMin() {
        return xMin;
    }

    public int getyMin() {
        return yMin;
    }

    public int getxMax() {
        return xMax;
    }

    public int getyMax() {
        return yMax;
    }

    public Boundry(int xMin, int yMin, int xMax, int yMax) {
        super();
        /*
         *  Storing two diagonal points
         */
        this.xMin = xMin;
        this.yMin = yMin;
        this.xMax = xMax;
        this.yMax = yMax;
    }

    public boolean inRange(int x, int y) {
        return (x >= this.getxMin() && x <= this.getxMax()
                && y >= this.getyMin() && y <= this.getyMax());
    }

    int xMin, yMin, xMax, yMax;

}

public class QuadTree {
    final int MAX_CAPACITY = 4;
    int level = 0;

    ArrayList<Node> nodes = new ArrayList<Node>();

    ArrayList<creature> creatures;
    ArrayList<bullet> bullets;
    QuadTree northWest = null;
    QuadTree northEast = null;
    QuadTree southWest = null;
    QuadTree southEast = null;
    Boundry boundry;

    QuadTree(int level, Boundry boundry) {
        this.level = level;
        this.boundry = boundry;
    }

    public static void main(String[] args) throws IOException {
        Double[] xCoords = new Double[1000];
        Double[] yCoords = new Double[1000];
        for (int i = 0; i < 1000; i++) {
            xCoords[i] = Math.random() * 1000;
            yCoords[i] = Math.random() * 1000;
        }
        var tree = new QuadTree(0,new Boundry(0,0,1000,1000));
        for (int i = 0; i < 1000; i++) {
            tree.insert(new Node(new bullet(xCoords[i],yCoords[i],0,0,false,"",0,0)));
        }
        QuadTreeVisualizer.drawQuadTree(tree, "goofyahhgame/src/img.png");
    }

    void split() {
        int xOffset = this.boundry.getxMin()
                + (this.boundry.getxMax() - this.boundry.getxMin()) / 2;
        int yOffset = this.boundry.getyMin()
                + (this.boundry.getyMax() - this.boundry.getyMin()) / 2;

        northWest = new QuadTree(this.level + 1, new Boundry(
                this.boundry.getxMin(), this.boundry.getyMin(), xOffset,
                yOffset));
        northEast = new QuadTree(this.level + 1, new Boundry(xOffset,
                this.boundry.getyMin(), xOffset, yOffset));
        southWest = new QuadTree(this.level + 1, new Boundry(
                this.boundry.getxMin(), xOffset, xOffset,
                this.boundry.getyMax()));
        southEast = new QuadTree(this.level + 1, new Boundry(xOffset, yOffset,
                this.boundry.getxMax(), this.boundry.getyMax()));

    }

    void insert(Node node) {
        if (!this.boundry.inRange(node.getX(), node.getY())) {
            return;
        }
        if (nodes.size() < MAX_CAPACITY) {
            nodes.add(node);
            return;
        }
        // Exceeded the capacity so split it in FOUR
        if (northWest == null) {
            split();
        }

        // Check coordinates belongs to which partition
        if (this.northWest.boundry.inRange(node.getX(), node.getY()))
            this.northWest.insert(node);
        else if (this.northEast.boundry.inRange(node.getX(), node.getY()))
            this.northEast.insert(node);
        else if (this.southWest.boundry.inRange(node.getX(), node.getY()))
            this.southWest.insert(node);
        else if (this.southEast.boundry.inRange(node.getX(), node.getY()))
            this.southEast.insert(node);
        else
            System.out.printf("ERROR : Unhandled partition %d %d", node.getX(), node.getY());
    }
}

 class QuadTreeVisualizer
{
    public static <V> void drawQuadTree(QuadTree tree, String file)
            throws IOException
    {

        Rectangle rect = new Rectangle(tree.boundry.getxMin(), tree.boundry.getyMin(), tree.boundry.getxMax() - tree.boundry.getxMin(), tree.boundry.getyMax() - tree.boundry.getyMin());

        int s = 5;
        int w = s*(int)rect.getWidth();
        int h = s*(int)rect.getHeight();


        BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);

        Set<Rectangle> inserted = drawSector(tree, image, w, h, s, 0);

        Graphics2D graphics = image.createGraphics();
        /*graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, w, h);*/

        graphics.setColor(Color.BLUE);
        graphics.drawLine(w/2, 0, w/2, h);
        graphics.drawLine(0, h/2, w, h/2);

        for (Rectangle valueRect : inserted) {
            //System.out.println(valueRect);
            graphics.setColor(Color.RED);
            graphics.drawRect((int) (h/2 - s*rect.getX()), (int) (h/2 - s*rect.getY()),
                    s*(int)valueRect.getWidth(), s*(int)valueRect.getHeight());

            /*graphics.drawString(valueRect.tl.toString(),
                w/2 + s*(valueRect.tl.x - 7), h/2 - s*(valueRect.tl.y - 1));
            graphics.drawString(valueRect.tr.toString(),
                w/2 + s*(valueRect.tr.x + 1), h/2 - s*(valueRect.tr.y - 1));

            graphics.drawString(valueRect.bl.toString(),
                w/2 + s*(valueRect.bl.x - 7), h/2 - s*(valueRect.bl.y - 1));
            graphics.drawString(valueRect.br.toString(),
                w/2 + s*(valueRect.br.x + 1), h/2 - s*(valueRect.br.y - 1));*/
        }

        graphics.dispose();

        ImageIO.write(image, "png", new File(file));
        System.out.println("s");
    }

    public static <V> Set<Rectangle> drawSector(QuadTree node, BufferedImage image, int w, int h, int s, int d)
    {
        if (node == null) {
            return new HashSet<Rectangle>();
        }
        Set<Rectangle> result = new HashSet<Rectangle>();

        Graphics2D graphics = image.createGraphics();

        Rectangle rect = new Rectangle(node.boundry.getxMin(), node.boundry.getyMin(), node.boundry.getxMax() - node.boundry.getxMin(), node.boundry.getyMax() - node.boundry.getyMin());
        graphics.setColor(new Color(255,255,255));
        graphics.fillRect((int) (w/2 + s*rect.getX()), (int) (h/2 - s*rect.getY()),
                s*(int)rect.getWidth(), s*(int)rect.getHeight());

        graphics.setColor(new Color(d*20,d*20,d*20));
        graphics.drawRect((int) (w/2 + s*rect.getX()), (int) (h/2 - s*rect.getY()),
                s*(int)rect.getWidth(), s*(int)rect.getHeight());

        Rectangle valueRect = new Rectangle(node.boundry.getxMin(), node.boundry.getyMin(), node.boundry.getxMax() - node.boundry.getxMin(), node.boundry.getyMax() - node.boundry.getyMin());
        if (valueRect != null) {
            result.add(valueRect);
        }

        graphics.dispose();

        if (node.northWest != null) {
            result.addAll(drawSector(node.northWest, image, w, h, s, d+1));
            result.addAll(drawSector(node.northEast, image, w, h, s, d+1));
            result.addAll(drawSector(node.southWest, image, w, h, s, d+1));
            result.addAll(drawSector(node.southEast, image, w, h, s, d+1));
        }
        System.out.println(node.level);
        return result;
    }
}