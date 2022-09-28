public class accelerate extends Collision{
    double velx = 0;
    double vely = 0;
    double width = 64;
    double length = 64;
    double friction = 0.90;
    Listener listener;
    double accelerationx;
    double accelerationy;

    double jumpacceleration;
    double veljump;
    double gravity = 0.0000005;
    public void accelerate(boolean w, boolean a, boolean s, boolean d, boolean jump, double speed) {
        accelerationx = 0;
        accelerationy = 0;


        if (w) {
            accelerationy = -1;
        }
        if (s) {
            accelerationy = 1;
        }
        if (d) {
            accelerationx = 1;
        }
        if (a) {
            accelerationx = -1;
        }
        if (jump && width <= 64 && length <= 64) {
            veljump = 3;
            if (Panel.elapsedFrame != 0) {
                gravity = 0.0000005 * (0.002 / (Panel.elapsedFrame / 10000.0));
            }
            listener.jump = false;
        }


        double elapsedTimeMultiplier = Panel.elapsedFrame / 0.0002;

        if ((int) veljump != 0) {
            velx += (accelerationx * 1.5) * speed * elapsedTimeMultiplier;
            vely += (accelerationy * 1.5) * speed * elapsedTimeMultiplier;
        }
        if ((int) veljump == 0) {
            velx += (accelerationx) * speed * elapsedTimeMultiplier;
            vely += (accelerationy) * speed * elapsedTimeMultiplier;
        }


        if (width >= 65 && length >= 65) {
            veljump -= gravity;
        }
        if (Panel.elapsedFrame != 0) {
            width += veljump;
            length += veljump;
        }

        if (veljump < -1.4 && (int) width <= 65 && (int) length <= 65) {
            gravity = 0;
            width = 64;
            length = 64;
            listener.jump = false;
        }


        velx *= friction;
        vely *= friction;
    }
}


