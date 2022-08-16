public class accelerate {
    double velx = 0;
    double vely = 0;
    double width = 64;
    double length = 64;
    double speed = 0.00000000000015;
    double friction = 0.90;
    Listener listener;
    double accelerationx;
    double accelerationy;

    double jumpacceleration;
    double veljump;
    double gravity = 0.0000005;
    long startFPS;
    long endFPS;
    long elapsedFrame;
    public void accelerate() {
        accelerationx = 0;
        accelerationy = 0;


        if (listener.w) {
            accelerationy = -1;
        }
        if (listener.s) {
            accelerationy = 1;
        }
        if (listener.d) {
            accelerationx = 1;
        }
        if (listener.a) {
            accelerationx = -1;
        }
        if (listener.jump && width <= 64 && length <= 64) {
            veljump = 3;
            if (elapsedFrame != 0) {
                gravity = 0.0000005 * (0.002 / (elapsedFrame / 10000.0));
            }
            listener.jump = false;
        }


        double elapsedTimeMultiplier = elapsedFrame / 0.0002;

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
        if (elapsedFrame != 0) {
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

