package logica;
import java.util.Random;

public class WPS {
    private String pincode;
    private String test;

    public WPS() {

        int[] randomcode = new int[8];
        int checksum;

        for (int i = 0; i < 7; i++) {
            Random rand = new Random();
            randomcode[i] = rand.nextInt(9);
        }

        checksum = randomcode[0] + randomcode[2] + randomcode[4] + randomcode[6];
        checksum = checksum * 3;
        checksum = checksum + randomcode[1] + randomcode[3] + randomcode[5];
        checksum = checksum % 10;
        checksum = 10 - checksum;

        randomcode[7] = checksum;
        this.pincode = "" + randomcode[0];
        for (int j = 1; j < randomcode.length; j++) {
            this.pincode = this.pincode + randomcode[j];
        }

    }
    public WPS(String code) {
        this.pincode = code;
    }

    public WPS(WPS WPS) {
        this.pincode = WPS.pincode;
    }

    public String getPincode() {
        return this.pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String toString() {
        return pincode;
    }

}

