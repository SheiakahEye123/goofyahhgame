import java.awt.*;
import java.sql.SQLOutput;

public class dayCycle {
    double timeOfDay;
    boolean day;
    double dayCounter;
    int daySize = 60;
    double nanosecondsPerSecond = 1000000000;

    Color sunriseColor = new Color(247, 105, 73, 125);
    Color noonColor = new Color(247,105,73,0);
    Color sunsetColor = new Color(255, 107, 14, 150);
    Color nightColor = new Color(6,0,44, 220);


    double dayTime;
    long startTime = System.nanoTime();
    long endTime;

    long elapsedTime;
    public void dayCycle() {

    }

    public void Clock() {
        endTime = System.nanoTime();
        elapsedTime = Math.abs((endTime - startTime));

        dayCounter = (elapsedTime/nanosecondsPerSecond)/daySize;
    }
    public Color setSkyColor() {
        double timeOfDay = dayCounter%1;
        if (timeOfDay <= 0.0) {
            return sunriseColor;
        }

        double sunriseStartTime = 0;
        double noonStartTime = 0.25;
        double sunsetStartTime = 0.5;
        double nightStartTime = 0.75;
        double endOfDay = 1.0;

        if (timeOfDay <= noonStartTime) {
            double durationOfSunrise = noonStartTime - sunriseStartTime;
            double sunriseTimer = timeOfDay;
            if (sunriseTimer > 0.99) {
                sunriseTimer = 0.99;
            }

            //y = (noonColor - duskColor)/durationOfSunrise * duskTimer + noonColor
            return new Color(
                    (int) ((noonColor.getRed() - sunriseColor.getRed())/durationOfSunrise * sunriseTimer + sunriseColor.getRed()),
                    (int) ((noonColor.getGreen() - sunriseColor.getGreen())/durationOfSunrise * sunriseTimer + sunriseColor.getGreen()),
                    (int) ((noonColor.getBlue() - sunriseColor.getBlue())/durationOfSunrise * sunriseTimer + sunriseColor.getBlue()),
                    (int) ((noonColor.getAlpha() - sunriseColor.getAlpha())/durationOfSunrise * sunriseTimer + sunriseColor.getAlpha()));
        }
        if (timeOfDay <= sunsetStartTime) {
            double durationOfNoon = sunsetStartTime - noonStartTime;
            double noonTimer = (timeOfDay - noonStartTime);
            if (noonTimer > 0.99) {
                noonTimer = 0.99;
            }

            return new Color(
                    (int) ((sunsetColor.getRed() - noonColor.getRed())/durationOfNoon * noonTimer + noonColor.getRed()),
                    (int) ((sunsetColor.getGreen() - noonColor.getGreen())/durationOfNoon * noonTimer + noonColor.getGreen()),
                    (int) ((sunsetColor.getBlue() - noonColor.getBlue())/durationOfNoon * noonTimer + noonColor.getBlue()),
                    (int) ((sunsetColor.getAlpha() - noonColor.getAlpha())/durationOfNoon * noonTimer + noonColor.getAlpha()));
        }
        if (timeOfDay <= nightStartTime) {
            double durationOfSunset = nightStartTime - sunsetStartTime;
            double sunsetTime = (timeOfDay - sunsetStartTime);
            if (sunsetTime > 0.99) {
                sunsetTime = 0.99;
            }

            return new Color(
                    (int) ((nightColor.getRed() - sunsetColor.getRed())/durationOfSunset * sunsetTime + sunsetColor.getRed()),
                    (int) ((nightColor.getGreen() - sunsetColor.getGreen())/durationOfSunset * sunsetTime + sunsetColor.getGreen()),
                    (int) ((nightColor.getBlue() - sunsetColor.getBlue())/durationOfSunset * sunsetTime + sunsetColor.getBlue()),
                    (int) ((nightColor.getAlpha() - sunsetColor.getAlpha())/durationOfSunset * sunsetTime + sunsetColor.getAlpha()));
        }
        if (timeOfDay <= endOfDay) {
            double durationOfNight = endOfDay - nightStartTime;
            double nightTimer = (timeOfDay - nightStartTime);
            if (nightTimer > 0.99) {
                nightTimer = 0.99;
            }

            return new Color(
                    (int) ((sunriseColor.getRed() - nightColor.getRed())/durationOfNight * nightTimer + nightColor.getRed()),
                    (int) ((sunriseColor.getGreen() - nightColor.getGreen())/durationOfNight * nightTimer + nightColor.getGreen()),
                    (int) ((sunriseColor.getBlue() - nightColor.getBlue())/durationOfNight * nightTimer + nightColor.getBlue()),
                    (int) ((sunriseColor.getAlpha() - nightColor.getAlpha())/durationOfNight * nightTimer + nightColor.getAlpha()));
        }
        return null;
    }
}

//y = mx+b