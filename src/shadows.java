import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class shadows {
    ArrayList<ArrayList<shadow>> shadows = new ArrayList<ArrayList<shadow>>();
    ArrayList<ray> rays = new ArrayList<ray>();

    double rayOffset = 1;
    dayCycle dayCycle;

    tiles tiles;

    tiles2 tiles2;

    int npoints;

    double smallnumber = -0.005;
    ArrayList<Integer> xpoints = new ArrayList<Integer>();
    ArrayList<Integer> ypoints = new ArrayList<Integer>();

    public shadows(dayCycle dayCycle_,tiles2 tiles2_) {
        tiles2 = tiles2_;
        dayCycle = dayCycle_;
        xpoints.add(0);
        xpoints.add(1920);
        ypoints.add(1080);
        ypoints.add(0);
    }

    public ArrayList<ray> rayCast(double startx, double starty, ArrayList<ArrayList<tile>> tiless, Graphics g) {
        npoints = 0;
        var sunRays = new ArrayList<ray>();


        /*for (int y = 0; y < tiless.size(); y++) {
            for (int x = 0; x < tiless.get(y).size(); x++) {
                if (tiless.get(y).get(x) != null) {
                    var ray1 = new ray(startx, starty, x - smallnumber, y - smallnumber, 0);
                    var ray2 = new ray(startx, starty, x + 1 + smallnumber, y - smallnumber, 0);
                    var ray3 = new ray(startx, starty, x + 1 + smallnumber, y + 1 + smallnumber, 0);
                    var ray4 = new ray(startx, starty, x - smallnumber, y + 1 + smallnumber, 0);
                    rays.add(ray1);
                    rays.add(ray2);
                    rays.add(ray3);
                    rays.add(ray4);
                }
            }
        }*/

        // Send 360 rays in each direction
        for(double angle = 0; angle < 360; angle += 1) {
            rays.add(new ray(startx, starty, startx + Math.cos(Math.toRadians(angle)), starty + Math.sin(Math.toRadians(angle)), 0));
        }
//        var ray1 = new ray(startx,starty,0,0,0);
//        ray1.angle = Math.atan2((ray1.endy - ray1.starty), (ray1.endx - ray1.startx));;
//        var ray2 = new ray(startx,starty,tiless.get(0).size(),0,0);
//        ray2.angle = Math.atan2((ray2.endy - ray2.starty), (ray2.endx - ray2.startx));;
//        var ray3 = new ray(startx,starty,tiless.get(0).size(),tiless.size(),0);
//        ray3.angle = Math.atan2((ray3.endy - ray3.starty), (ray3.endx - ray3.startx));;
//        var ray4 = new ray(startx,starty,0,tiless.size(),0);
//        ray4.angle = Math.atan2((ray4.endy - ray4.starty), (ray4.endx - ray4.startx));;
//        var ray5 = ray1;
//
//        rays.add(ray1);
//        rays.add(ray4);
//        rays.add(ray3);
//        rays.add(ray2);
//        rays.add(ray5);

        for (ray ray : rays) {
            double angle = Math.atan2((ray.endy - ray.starty), (ray.endx - ray.startx));
            ray.angle = angle;
            for (double length = 0; length <= 20; length += 0.01) {
                double rise = length * Math.sin(angle);
                double run = length * Math.cos(angle);
                if ((run + startx) < 0) {
                    ray.endx = run + startx;
                    ray.endy = rise + starty;
                    break;
                }
                if ((run + startx) > tiless.get(0).size() - 1) {
                    ray.endx = run + startx;
                    ray.endy = rise + starty;
                    break;
                }
                if ((rise + starty) < 0) {
                    ray.endy = rise + starty;
                    ray.endx = run + startx;
                    break;
                }
                if ((rise + starty) > tiless.size() - 1) {
                    ray.endy = rise + starty;
                    ray.endx = run + startx;
                    break;
                }
                if (tiless.get((int) (rise + starty)).get((int) (run + startx)) != null) {
                    //ray = null;
                    ray.length = length;
                    ray.endx = run + startx;
                    ray.endy = rise + starty;
                    break;
                }
            }
            if (ray != null) {
                //npoints++;
                // g.drawLine((int) ((ray.startx - startx) * WorldState.tileSize + 960), (int) ((ray.starty - starty) * 64 + 540), (int) ((ray.endx - startx) * 64 + 960), (int) ((ray.endy - starty) * 64 + 540));
                //g.drawLine((int) ((ray.startx - startx) * tilesize + (960 * dayTime)), (int) ((ray.starty - starty) * tilesize + (540 * dayTime)), (int) ((ray.endx - startx) * tilesize + 960), (int) ((ray.endy - starty) * tilesize + 540));
            }
        }

//        rays.add(ray1);
//        rays.add(ray4);
//        rays.add(ray3);
//        rays.add(ray2);
//        rays.add(ray5);

        for (ray ray : rays) {
            // g.drawLine((int) ((ray.startx - startx) * WorldState.tileSize + 960), (int) ((ray.starty - starty) * 64 + 540), (int) ((ray.endx - startx) * 64 + 960), (int) ((ray.endy - starty) * 64 + 540));
        }


        Collections.sort(rays,
                (ray one, ray two) -> {
                    if (one.angle < two.angle) {
                        return -1;
                    }
                    if (one.angle > two.angle) {
                        return 1;
                    }
                    return 0;
                });
        return rays;
    }

    public void rayClear() {
        rays.clear();
        xpoints.clear();
        ypoints.clear();
        npoints = 0;
    }



}

