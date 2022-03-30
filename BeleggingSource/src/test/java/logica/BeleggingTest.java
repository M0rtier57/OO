package logica;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * rendement : BeleggingTest
 *
 * @author kristien.vanassche
 * @version 28/03/2022
 */
class BeleggingTest {
    private Belegging b1, b2, b3;
    private double[] rendementen = new double[]{35, -20, 10};
    Class<?> myClass;

    public BeleggingTest() throws ClassNotFoundException {
        myClass = Class.forName("logica.Belegging");
        b1 = new Belegging("AAA",7500, rendementen);
        b2 = new Belegging("BBB",7500, new double[] {30,8});
    }

    @Test
    public void testConstructorNOK() {
        assertThrows(IllegalArgumentException.class, () -> new Belegging(null, 0)); //ontbrekende data
        assertThrows(IllegalArgumentException.class, () -> new Belegging("", 0)); //ontbrekende data
        assertThrows(IllegalArgumentException.class, () -> new Belegging("test", -500)); //ongeldige data
    }

    @Test
    public void testGetter() {
        assertEquals(7500, b1.getInvesteringsbedrag());
    }

    @Test
    public void testGetWaarde() {
        assertEquals(8910, b1.getWaarde());
        assertEquals(10530, b2.getWaarde());
    }

    @Test
    public void testGetOpbrengst() {
        assertEquals(1410, b1.getOpbrengst());
        assertEquals(3030, b2.getOpbrengst());
    }

    @Test
    public void testSetJaarrendementen() {
        b3 = new Belegging("CCC", 7500);
        b3.setJaarrendementen(rendementen);
        assertEquals(b1.getOpbrengst(), b3.getOpbrengst());
    }

    @Test
    public void testSetJaarrendement() {
        Belegging b3 = new Belegging("CCC", 7500);
        for (int i = 0; i < rendementen.length; i++)
            b3.setJaarrendement(rendementen[i], i+1);
        assertEquals(b1.getOpbrengst(), b3.getOpbrengst());
    }

    @Test
    public void testSetJaarrendementNOK() {
        Belegging b3 = new Belegging("CCC", 7500);
        assertThrows(IllegalArgumentException.class, () -> b3.setJaarrendement(35, 0));
    }

    @Test
    public void testGetRekenkundigRendement() {
        assertEquals(25, b1.getRekenkundigRendement());
        assertEquals(38, b2.getRekenkundigRendement());
    }

    @Test
    public void testGetMeetkundigRendement() {
        assertEquals(18.8, b1.getMeetkundigRendement());
        assertEquals(3030.0/7500*100, b2.getMeetkundigRendement());
    }

    @Test
    public void testGetGemiddeldRendement() {
        assertEquals(18.8/3, b1.getGemiddeldRendement());
        assertEquals(3030.0/7500*100/2, b2.getGemiddeldRendement());
    }

    @Test
    public void testGetRendement() {
        assertEquals(25, b1.getRendement(Rendement.REKENKUNDIG));
        assertEquals(18.8, b1.getRendement(Rendement.MEETKUNDIG));
        assertEquals(18.8/3, b1.getRendement(Rendement.GEMIDDELD));
        assertThrows(IllegalArgumentException.class, () -> b1.getRendement(Rendement.GEANNUALISEERD));
        assertThrows(IllegalArgumentException.class, () -> b1.getRendement(Rendement.GEANNUALISEERD));
    }

    @Test
    public void testToString() {
        assertTrue(b1.toString().contains(b1.getNaam()));
        assertTrue(b1.toString().contains(b1.getMeetkundigRendement() + "%"));
        assertTrue(b1.toString().contains("" + b1.getJaarrendementen().length));
    }

    @Test
    public void testEquals() {
        assertFalse(b1.equals(b3));
        b3 = new Belegging("CCC", 7500);
        b3.setJaarrendementen(rendementen);
        assertTrue(b1.equals(b3));
    }

    @Test
    public void testEqualsBis() {
        Belegging xxx = new Belegging("XXX", 500, new double[]{1,2,3});
        Belegging yyy = new Belegging("YYY", 5000, new double[]{1,2,3});
        System.out.println(xxx + " - " + yyy);
        System.out.println("gemiddeld rendement xxx = " + xxx.getGemiddeldRendement());
        System.out.println("gemiddeld rendement yyy = " + yyy.getGemiddeldRendement());
        System.out.println(xxx.equals(yyy));

        yyy.setJaarrendement(4,4);
        System.out.println(xxx + " - " + yyy);
        System.out.println("gemiddeld rendement yyy = " + yyy.getGemiddeldRendement());
        System.out.println(xxx.equals(yyy));
    }

    @Test
    public void testFieldModifier() {
        System.out.println("test field modifier");

        Field[] fields = myClass.getDeclaredFields();
        assertEquals(3, fields.length);
        Stream.of(fields).forEach(f -> {assert ((f.getModifiers() & Modifier.PRIVATE) != 0);});
    }

    @Test
    public void testConstructorSignatures() {
        assertTrue(myClass.getDeclaredConstructors().length == 2);

        for (Constructor constr : myClass.getDeclaredConstructors()) {
                Class[] parameterTypes = constr.getParameterTypes();
                assertTrue(parameterTypes.length >= 2);
                assertEquals("java.lang.String", parameterTypes[0].getTypeName());
                assertEquals("int", parameterTypes[1].getTypeName());

                if (constr.getParameterCount() == 3) {
                    assertEquals("double[]", parameterTypes[2].getTypeName());
                }
        }
    }

    @Test
    public void testMethodSignatureEquals() throws ClassNotFoundException, NoSuchMethodException {
        Method m = myClass.getDeclaredMethod("equals", Class.forName("java.lang.Object"));
        assertEquals(1, m.getParameterCount());
        assertEquals(Boolean.TYPE, m.getReturnType());
        assertTrue((m.getModifiers() & Modifier.PUBLIC) != 0);
        assertNotNull(m);
    }

    @Test
    public void testMethodSignatureToString() throws ClassNotFoundException, NoSuchMethodException {
        Method m = myClass.getDeclaredMethod("toString");
        assertEquals(0, m.getParameterCount());
        assertEquals(Class.forName("java.lang.String"), m.getReturnType());
        assertTrue((m.getModifiers() & Modifier.PUBLIC) != 0);
        assertNotNull(m);
    }
}