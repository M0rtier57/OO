package logica;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import logica.Kleur;
import logica.Punt;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author kristien.vanassche
 * @version 09/05/2022
 */
public class FiguurTest {
    Class<?> myClass;

    public FiguurTest() throws ClassNotFoundException {
        myClass = Class.forName("logica.Figuur");
    }

    @Test
    public void testFieldModifier() throws ClassNotFoundException {
        Field[] fields = myClass.getDeclaredFields();
        assertEquals(4, fields.length);
        
        for (Field f : fields) {
            assert ((f.getModifiers() & Modifier.PRIVATE) != 0);
        }
    }
    
    @Test
    public void testClassModifier() {
        assert((myClass.getModifiers() & Modifier.ABSTRACT) != 0);
    }

    @Test
    public void testConstructoren() throws ClassNotFoundException {
        int count = 0;
        for(Constructor constr : myClass.getDeclaredConstructors()) {
            if (constr.getParameterCount() == 0) {
                count++;
            }
            else if (constr.getParameterCount() == 3) {
                Class[] parameterTypes = constr.getParameterTypes();
                assertEquals(3, parameterTypes.length);
                assertEquals("logica.Kleur", parameterTypes[0].getTypeName());
                assertEquals("logica.Kleur", parameterTypes[1].getTypeName());
                assertEquals("int", parameterTypes[2].getTypeName());
                count++;
            }
        }
        assertEquals(2, count);
    }

    @Test
    public void testGetterSetterMethodSignature() throws NoSuchMethodException {
        Method m = myClass.getDeclaredMethod("getKleur");
        assertNotNull(m);
        assertTrue((m.getModifiers() & Modifier.PUBLIC) != 0);
        assertEquals(0, (m.getModifiers() & Modifier.ABSTRACT));
        assertEquals(0, m.getParameterCount());
        assertEquals(Kleur.class, m.getReturnType());
        
        m = myClass.getDeclaredMethod("getKleurRand");
        assertNotNull(m);
        assertTrue((m.getModifiers() & Modifier.PUBLIC) != 0);
        assertTrue((m.getModifiers() & Modifier.ABSTRACT) == 0);
        assertEquals(0, m.getParameterCount());
        assertEquals(Kleur.class, m.getReturnType());

        m = myClass.getDeclaredMethod("getDikteRand");
        assertNotNull(m);
        assertTrue((m.getModifiers() & Modifier.PUBLIC) != 0);
        assertEquals(0, (m.getModifiers() & Modifier.ABSTRACT));
        assertEquals(0, m.getParameterCount());
        assertEquals(Integer.TYPE, m.getReturnType());  
        
        m = myClass.getDeclaredMethod("getMiddelpunt");
        assertNotNull(m);
        assertTrue((m.getModifiers() & Modifier.PUBLIC) != 0);
        assertEquals(0, (m.getModifiers() & Modifier.ABSTRACT));
        assertEquals(0, m.getParameterCount());
        assertEquals(Punt.class, m.getReturnType());

        m = myClass.getDeclaredMethod("setMiddelpunt", Punt.class);
        assertNotNull(m);
        assertTrue((m.getModifiers() & Modifier.PUBLIC) != 0);
        assertEquals(0, (m.getModifiers() & Modifier.ABSTRACT));
        assertEquals(1, m.getParameterCount());
        assertEquals(void.class, m.getReturnType()); 
    }

    @Test
    public void testEqualsMethodSignature() throws ClassNotFoundException, NoSuchMethodException {
        Method m = myClass.getDeclaredMethod("equals", Class.forName("java.lang.Object"));
        assertTrue((m.getModifiers() & Modifier.PUBLIC) != 0);
        assertNotNull(m);
    }
    
    @Test
    public void testBerekenOppervlakteMethodSignature() throws NoSuchMethodException {
        Method m = myClass.getDeclaredMethod("berekenOppervlakte");
        assertNotNull(m);
        assertTrue((m.getModifiers() & Modifier.PUBLIC) != 0);
        assertTrue((m.getModifiers() & Modifier.ABSTRACT) != 0);
        assertEquals(0, m.getParameterCount());
        assertEquals(Double.TYPE, m.getReturnType());
    }

    @Test
    public void testBerekenOmtrekMethodSignature() throws NoSuchMethodException {
        Method m = myClass.getDeclaredMethod("berekenOmtrek");
        assertNotNull(m);
        assertTrue((m.getModifiers() & Modifier.PUBLIC) != 0);
        assertTrue((m.getModifiers() & Modifier.ABSTRACT) != 0);
        assertEquals(0, m.getParameterCount());
        assertEquals(Double.TYPE, m.getReturnType());
    }
}
