package logica;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author kristien.vanassche
 * @version 24/04/2021
 */
class VakTest {
    private Class myClass;
    private Vak vak1, vak2, vak3;

    public VakTest() throws ClassNotFoundException {
        myClass = Class.forName("logica.Vak");
        vak1 = new Vak("Wiskunde", 3);
        vak2 = new Vak("Fysica", 4);
        vak3 = new Vak("Chemie");
    }

    @Test
    public void testConstructorNOK() {
        assertThrows(IllegalArgumentException.class, () -> new Vak((String)null, 2));
        assertThrows(IllegalArgumentException.class, () -> new Vak("", 3));
        assertThrows(IllegalArgumentException.class, () -> new Vak("Wiskunde", -2));
        Vak ok = new Vak("Wiskunde", 2);
    }

    @Test
    void testGetters() {
        assertEquals("Wiskunde", vak1.getNaam());
        assertEquals(3, vak1.getStp());
        assertEquals(0, vak1.getScore());

        assertEquals("Fysica", vak2.getNaam());
        assertEquals(4, vak2.getStp());
        assertEquals(0, vak2.getScore());

        assertEquals("Chemie", vak3.getNaam());
        assertEquals(0, vak3.getStp());
        assertEquals(0, vak3.getScore());
    }

    @Test
    void testSetters() {
        assertEquals(0, vak1.getScore());
        vak1.setScore(10);
        assertEquals(10, vak1.getScore());

        assertEquals(0, vak3.getStp());
        vak3.setStp(6);
        assertEquals(6, vak3.getStp());
    }

    @Test
    void testEquals() {
        assertNotEquals(vak1, vak2);
        assertEquals(new Vak("XXX", 3), new Vak("XXX", 6));

        for (Method f : myClass.getDeclaredMethods()) {
            if (f.getName().equals("equals")) {
                assertTrue((f.getModifiers() & Modifier.PUBLIC) != 0);
                assertEquals(1, f.getParameterCount());
                assertEquals("java.lang.Object", f.getParameterTypes()[0].getTypeName());
            }
        }
    }

    @Test
    void testToString() {
        assertEquals("Wiskunde (3stp)", vak1.toString().trim());
    }

    @Test
    public void testVelden() {
        int countFields = 0;
        int countPrivateFields = 0;
        int countPublicStaticFinal = 0;

        for (Field f : myClass.getDeclaredFields()) {
            countFields++;
            if ((f.getModifiers() & Modifier.PUBLIC) != 0 && (f.getModifiers() & Modifier.STATIC) != 0 && (f.getModifiers() & Modifier.FINAL) != 0) {
                countPublicStaticFinal++;
            }
            else if ((f.getModifiers() & Modifier.PRIVATE) != 0) {
                countPrivateFields++;
            }
        }
        System.out.println("-->> Je hebt " + countFields + " velden gedefinieerd, waarvan " + countPrivateFields + " private en " + countPublicStaticFinal + " publieke constanten.");
        assertEquals(3, countPrivateFields);
        assertEquals(1, countPublicStaticFinal);
    }

    @Test
    public void testMethoden() {
        int countMeth = myClass.getDeclaredMethods().length;

        int countMethPriv = 0;
        for (Method f : myClass.getDeclaredMethods()) {
            if ((f.getModifiers() & Modifier.PRIVATE) != 0) {
                countMethPriv++;
            }
        }
        System.out.println("-->> Je hebt " + countMeth + " methoden gedefinieerd, waarvan " + countMethPriv + " private.");
        assertTrue(countMeth >= 7);
        assertTrue(countMethPriv >= 0);
    }


    @Test
    public void testConstructor() {
        assertTrue(myClass.getDeclaredConstructors().length >= 2);

        for (Constructor constr : myClass.getDeclaredConstructors()) {
            Class[] parameterTypes = constr.getParameterTypes();
            switch(constr.getParameterCount()) {
                case 1:
                    assertEquals(1, parameterTypes.length);
                    assertEquals("java.lang.String", parameterTypes[0].getTypeName());
                    break;
                case 2:
                    assertEquals(2, parameterTypes.length);
                    assertEquals("java.lang.String", parameterTypes[0].getTypeName());
                    assertEquals("int", parameterTypes[1].getTypeName());
                    break;
                default:
                    break;
            }
        }
    }
}