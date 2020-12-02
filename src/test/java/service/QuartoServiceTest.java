package service;

import dto.QuartoDTO;
import org.junit.Assert;

public class QuartoServiceTest {
    private HotelService quartoService;
    public void deveSalvarDoisQuartos() {
        QuartoDTO quartoparasalvar = new QuartoDTO();
        quartoparasalvar.setNumero("123");
        quartoparasalvar.setReservado(true);
        quartoparasalvar.setLimpo(true);
        quartoparasalvar.setId(12);
        quartoparasalvar.setValor(10.4f);
        quartoparasalvar.setTipo("suite");


        quartoparasalvar.setNumero("345");
        quartoparasalvar.setReservado(true);
        quartoparasalvar.setLimpo(false);
        quartoparasalvar.setId(13);
        quartoparasalvar.setValor(140.4f);
        quartoparasalvar.setTipo("simples");

        QuartoDTO quartoSalvo = quartoService.findById(12);

        Assert.assertEquals(12,(int) quartoSalvo.getId());
        Assert.assertEquals("123", quartoSalvo.getNumero());
        Assert.assertTrue(quartoSalvo.isReservado());
        Assert.assertTrue(quartoSalvo.isLimpo());
        Assert.assertEquals(10.45f, quartoSalvo.getValor(),0);
        Assert.assertEquals("suite",  quartoSalvo.getTipo());


    }
}
