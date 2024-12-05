
import org.factoriaf5.CalculadoraIMC;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraIMCTest {

    @Test
    public void testCalcularIMC() {
        assertEquals(22.86, CalculadoraIMC.calcularIMC(70, 1.75), 0.01);
        assertEquals(19.53, CalculadoraIMC.calcularIMC(50, 1.60), 0.01);
        assertEquals(27.78, CalculadoraIMC.calcularIMC(90, 1.80), 0.01);
    }

    @Test
    public void testClasificarIMC() {
        assertEquals("Bajo peso", CalculadoraIMC.clasificarIMC(18.0));
        assertEquals("Peso normal", CalculadoraIMC.clasificarIMC(22.0));
        assertEquals("Sobrepeso", CalculadoraIMC.clasificarIMC(27.0));
        assertEquals("Obesidad", CalculadoraIMC.clasificarIMC(32.0));

    }

    @Test
    public void testEstaturaInvalida() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            CalculadoraIMC.calcularIMC(70, 0);
        });
        assertEquals("La estatura debe ser mayor que cero", exception.getMessage());
    }

    @Test
    public void testPesoInvalido() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            CalculadoraIMC.calcularIMC(0, 1.75);
        });
        assertEquals("El peso debe ser mayor que cero", exception.getMessage());
    }
}
