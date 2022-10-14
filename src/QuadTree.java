import java.util.ArrayList;
import java.util.List;


class Node {
    int x,y;
    Object obj;
    public void Node(Object obj_) {
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

    QuadTree(int level, Boundry boundry,     ArrayList<creature> creatures_,ArrayList<bullet> bullets_) {
        this.level = level;
        this.boundry = boundry;
        creatures = creatures_;
        bullets = bullets_;
    }

    void split() {
        int xOffset = this.boundry.getxMin()
                + (this.boundry.getxMax() - this.boundry.getxMin()) / 2;
        int yOffset = this.boundry.getyMin()
                + (this.boundry.getyMax() - this.boundry.getyMin()) / 2;

        northWest = new QuadTree(this.level + 1, new Boundry(
                this.boundry.getxMin(), this.boundry.getyMin(), xOffset,
                yOffset), creatures, bullets);
        northEast = new QuadTree(this.level + 1, new Boundry(xOffset,
                this.boundry.getyMin(), xOffset, yOffset), creatures, bullets);
        southWest = new QuadTree(this.level + 1, new Boundry(
                this.boundry.getxMin(), xOffset, xOffset,
                this.boundry.getyMax()), creatures, bullets);
        southEast = new QuadTree(this.level + 1, new Boundry(xOffset, yOffset,
                this.boundry.getxMax(), this.boundry.getyMax()), creatures, bullets);

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