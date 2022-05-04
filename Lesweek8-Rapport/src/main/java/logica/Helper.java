package logica;

public class Helper {
    public static double afronden(double getal, int afronding) {
        if (afronding < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, afronding);
        getal = getal * factor;
        long tmp = Math.round(getal);
        return (double) tmp / factor;
    }

}
