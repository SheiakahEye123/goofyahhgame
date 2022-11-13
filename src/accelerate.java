public class accelerate{
    double velx = 0;
    double vely = 0;
    double friction = 0.90;
    Listener listener;
    double accelerationx;
    double accelerationy;

    double jumpacceleration;
    double gravity = 0.0000005;
    public void accelerate(boolean w, boolean a, boolean s, boolean d, boolean sprint, double speed) {
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


        double elapsedTimeMultiplier = Panel.elapsedFrame / 0.0002;

        if (sprint) {
            velx += (accelerationx * 1.5) * speed * elapsedTimeMultiplier;
            vely += (accelerationy * 1.5) * speed * elapsedTimeMultiplier;
        }
        if (!sprint) {
            velx += (accelerationx) * speed * elapsedTimeMultiplier;
            vely += (accelerationy) * speed * elapsedTimeMultiplier;
        }

        velx *= friction;
        vely *= friction;
    }
}


