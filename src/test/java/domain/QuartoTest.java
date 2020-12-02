package test.java.domain;


import domain.Quarto;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class QuartoTest {
    @Test
    public void deveCriarQuartoValido(){
        Quarto quarto = new Quarto(1, "123", 22.45f, "SUITE", true, true);
        Assert.assertEquals(Integer.valueOf(1), quarto.getId());
        Assert.assertEquals("123", quarto.getNumero());
        Assert.assertEquals(22.45f, quarto.getValor(),0);
        Assert.assertEquals("SUITE", quarto.getTipo());
        Assert.assertTrue(quarto.isReservado());
        Assert.assertTrue(quarto.isLimpo());
    }
}
