package logica;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author kristien.vanassche
 * @version 15/02/2020
 */
public class WPSTest {
    @Test
    public void testDatavelden() throws ClassNotFoundException {
        Class<?> c = Class.forName("logica.WPS");
        assertEquals(1, c.getDeclaredFields().length);
        assertTrue((c.getDeclaredFields()[0].getModifiers() & Modifier.PRIVATE) != 0);
    }

    @Test
    public void testExtraPrivateMethoden() throws ClassNotFoundException {
        Class<?> c = Class.forName("logica.WPS");
        int numPrivateMethods = 0;
        Method[] methods = c.getDeclaredMethods();
        for (Method m : methods) {
            if ((m.getModifiers() & Modifier.PRIVATE) != 0) {
                numPrivateMethods += 1;
            }
        }
        assertTrue(numPrivateMethods > 0);
    }

    @Test
    public void testDefaultConstructor() {
        WPS instance = new WPS();
        String code = instance.getPincode();
        assertEquals(8, code.length());
        assertTrue(code.matches("\\d+"));  //match an integer number
    }

    @Test
    public void testNietDefaultDefaultConstructorValid() {
        String pincode = "10101018";
        WPS wps1 = new WPS(pincode);
        WPS wps2 = new WPS();
        wps2.setPincode(pincode);
        assertEquals(pincode, wps1.getPincode());
        assertEquals(wps1.getPincode(), wps2.getPincode());
    }

    @Test
    public void testDefaultNietDefaultConstructor() {
        String code;
        WPS instance1, instance2;
        for (int i = 0; i < 10; i++) {
            instance1 = new WPS();
            code = instance1.getPincode();
            assertTrue(code.length() == 8 && code.matches("\\d+"));
            instance2 = new WPS(code);
            assertEquals(code, instance2.getPincode());
        }
    }

    @Test
    public void testDefaultConstructorDifferentResults() {
        String code;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            code = new WPS().getPincode();
            if (!list.contains(code)) list.add(code);
        }
        assertTrue(list.size() > 1);
    }

    @Test
    public void testCopyConstructor() {
        String code = "12345670";
        WPS instance1 = new WPS(code);
        WPS instance2 = new WPS(instance1);
        assertEquals(code, instance2.getPincode());
    }

    @Test
    public void testSetPincodeValid() {
        WPS instance = new WPS();
        String[] codes = {"10101018", "01010107", "00000000", "00000017", "00000109", "06755683"};
        for (String codeIn : codes) {
            instance.setPincode(codeIn);
            assertEquals(codeIn, instance.getPincode());
        }
    }

    @Test
    public void testSetPincodeNotValid() {
        WPS instance = new WPS();
        String[] codes = new String[]{"39635290", "12345678"};
        for (String codeIn : codes) {
            Throwable thrown = assertThrows(IllegalArgumentException.class, () -> instance.setPincode(codeIn));
            assertEquals("ongeldige code", thrown.getMessage());
        }
    }

    @Test
    public void testNotValidOngeldigAantalTekens() {
        String pincode = "123456";
        String msg = "ongeldig aantal tekens";
        Throwable thrown;
        thrown = assertThrows(IllegalArgumentException.class, () -> new WPS(pincode));
        assertEquals(msg, thrown.getMessage());
        thrown = assertThrows(IllegalArgumentException.class, () -> new WPS().setPincode(pincode));
        assertEquals(msg, thrown.getMessage());
    }

    @Test
    public void testNotValidOngeldigeTekens() {
        String pincode = "hallo123";
        String msg = "ongeldige tekenreeks";
        Throwable thrown;
        thrown = assertThrows(IllegalArgumentException.class, () -> new WPS(pincode));
        assertEquals(msg, thrown.getMessage());
        thrown = assertThrows(IllegalArgumentException.class, () -> new WPS().setPincode(pincode));
        assertEquals(msg, thrown.getMessage());
    }

    @Test
    public void testToString() {
        WPS instance1 = new WPS();
        String code1 = "" + instance1;
        WPS instance2 = new WPS(code1);
        String code2 = "" + instance1;
        assertEquals(code1, code2);
        assertTrue((""+instance1).contains(code1));
        assertTrue((""+instance2).contains(code1));
    }

    @Test
    public void testEquals() {
        String code = "12345670";
        WPS instance1 = new WPS(code);
        WPS instance2 = new WPS(code);
        assertEquals(instance1, instance2);

        ArrayList<WPS> lijst = new ArrayList<>();
        for (int i = 0; i  < 10; i++) {
            lijst.add(instance1);
            assertEquals(i + 1, lijst.size());
        }
        assertEquals(10, lijst.size());
        for (int i = 0; i  < 10; i++) {
            assertTrue(lijst.remove(instance2));
            assertEquals(10 - i - 1, lijst.size());
        }
        assertEquals(0, lijst.size());
    }
}
