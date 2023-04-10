import java.awt.Color;
import java.util.Random;

public class Helpers {

    private static Random random = new Random();

    // –––––– Randomness helpers –––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––
    // copied from emoji vacation lab

    /**
     * Convenience to return a random floating point number, min ≤ n < max.
     */
    public static double randomDouble(double min, double max) {
        return random.nextDouble() * (max - min) + min;
    }

    /**
     * Convenience to return a random integer, min ≤ n ≤ max.
     * Note that max is inclusive.
     */
    public static int randomInt(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    /**
     * Convenience to return true with the given percent change (0 = always false, 100 = always true).
     */
    public static boolean percentChance(double chance) {
        return random.nextDouble() * 100 < chance;
    }

    /**
     * Returns a slightly different color than the given one. Useful for making a bunch of items not
     * look entirely identical.
     */
    public static Color randomColorVariation(Color color, int amount) {
        return new Color(
            colorChannelVariation(color.getRed(), amount),
            colorChannelVariation(color.getGreen(), amount),
            colorChannelVariation(color.getBlue(), amount),
            color.getAlpha());
    }

    
    /**
     * Varies the given value randomly, pinned to [0...255].
     */
    public static int colorChannelVariation(int c, int amount) {
        return Math.min(255, Math.max(0, c + randomInt(-amount, amount)));
    }
    
}
