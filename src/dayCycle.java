import java.awt.*;

public class dayCycle {
    double timeOfDay;
    boolean day;
    double dayCounter;
    int daySize = 60;
    double nanosecondsPerSecond = 1000000000;

    Color sunriseColor = new Color(255, 255, 224, 60);
    Color noonColor = new Color(255,255,224,0);
    Color sunsetColor = new Color(255, 107, 14, 75);
    Color nightColor = new Color(6,0,44, 110);


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
            double sunriseTimer = timeOfDay / noonStartTime;
            //y = (noonColor - duskColor)/durationOfSunrise * duskTimer + noonColor
            if ((int) ((noonColor.getAlpha() - sunriseColor.getAlpha())/durationOfSunrise * sunriseTimer + sunriseColor.getAlpha()) <= 0 || (int) ((noonColor.getAlpha() - sunriseColor.getAlpha())/durationOfSunrise * sunriseTimer + sunriseColor.getAlpha()) >= 255) {
                return noonColor;
            }
            return new Color(
                    (int) ((noonColor.getRed() - sunriseColor.getRed())/durationOfSunrise * sunriseTimer + sunriseColor.getRed()),
                    (int) ((noonColor.getGreen() - sunriseColor.getGreen())/durationOfSunrise * sunriseTimer + sunriseColor.getGreen()),
                    (int) ((noonColor.getBlue() - sunriseColor.getBlue())/durationOfSunrise * sunriseTimer + sunriseColor.getBlue()),
                    (int) ((noonColor.getAlpha() - sunriseColor.getAlpha())/durationOfSunrise * sunriseTimer + sunriseColor.getAlpha()));
        }
        if (timeOfDay <= sunsetStartTime) {
            double durationOfNoon = sunsetStartTime - noonStartTime;
            double noonTimer = (timeOfDay - noonStartTime) / (sunsetStartTime - noonStartTime);
            if (noonTimer > 0.99)
                noonTimer = 0.99;
            if ((int) ((sunsetColor.getRed() - noonColor.getRed())/durationOfNoon * noonTimer + noonColor.getRed()) >= 255 || (int) ((sunsetColor.getRed() - noonColor.getRed())/durationOfNoon * noonTimer + noonColor.getRed()) <= 0) {
                return sunsetColor;
            }
            return new Color(
                    (int) ((sunsetColor.getRed() - noonColor.getRed())/durationOfNoon * noonTimer + noonColor.getRed()),
                    (int) ((sunsetColor.getGreen() - noonColor.getGreen())/durationOfNoon * noonTimer + noonColor.getGreen()),
                    (int) ((sunsetColor.getBlue() - noonColor.getBlue())/durationOfNoon * noonTimer + noonColor.getBlue()),
                    (int) ((sunsetColor.getAlpha() - noonColor.getAlpha())/durationOfNoon * noonTimer + noonColor.getAlpha()));
        }
        if (timeOfDay <= nightStartTime) {
            double durationOfSunset = nightStartTime - sunsetStartTime;
            double sunsetTimer = (timeOfDay - sunsetStartTime) / (nightStartTime - sunsetStartTime);
            if (sunsetTimer > 0.99)
                sunsetTimer = 0.99;

            if ((int) ((nightColor.getRed() - sunsetColor.getRed())/durationOfSunset * sunsetTimer + sunsetColor.getRed()) >= 255 || (int) ((nightColor.getRed() - sunsetColor.getRed())/durationOfSunset * sunsetTimer + sunsetColor.getRed()) <= 0) {
                return nightColor;
            }


            return new Color(
                    (int) ((nightColor.getRed() - sunsetColor.getRed())/durationOfSunset * sunsetTimer + sunsetColor.getRed()),
                    (int) ((nightColor.getGreen() - sunsetColor.getGreen())/durationOfSunset * sunsetTimer + sunsetColor.getGreen()),
                    (int) ((nightColor.getBlue() - sunsetColor.getBlue())/durationOfSunset * sunsetTimer + sunsetColor.getBlue()),
                    (int) ((nightColor.getAlpha() - sunsetColor.getAlpha())/durationOfSunset * sunsetTimer + sunsetColor.getAlpha()));
        }
        if (timeOfDay <= endOfDay) {
            double durationOfNight = endOfDay - nightStartTime;
            double nightTimer = (timeOfDay - nightStartTime) / (endOfDay - nightStartTime);
            if (nightTimer > 0.99)
                nightTimer = 0.99;

            if ((int) ((sunriseColor.getRed() - nightColor.getRed())/durationOfNight * nightTimer + nightColor.getRed()) >= 255 || (int) ((sunriseColor.getRed() - nightColor.getRed())/durationOfNight * nightTimer + nightColor.getRed()) <= 0) {
                return sunriseColor;
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