package logica;

/**
 * rendement : Helper
 *
 * @author kristien.vanassche
 * @version 27/03/2022
 */
public class Helper {
    public static double afronden(double bedrag, int digits) {
        return Math.round(bedrag * Math.pow(10, digits)) / Math.pow(10, digits);
    }
}
