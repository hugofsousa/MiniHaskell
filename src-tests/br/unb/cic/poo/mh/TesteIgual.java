package br.unb.cic.poo.mh;

import br.unb.poo.mh.Igual;
import br.unb.poo.mh.Tipo;
import br.unb.poo.mh.ValorBooleano;
import br.unb.poo.mh.ValorInteiro;
import org.junit.Assert;
import org.junit.Test;

public class TesteIgual {

    @Test
    public void TesteIgual() {
        ValorInteiro int100  = new ValorInteiro(100);
        ValorInteiro int90 = new ValorInteiro(90);
        ValorInteiro intcem = new ValorInteiro(100);

        Igual diferente = new Igual(int100, int90);
        Igual igual = new Igual(int100, intcem);

        ValorBooleano res1 = (ValorBooleano)diferente.avaliar();
        ValorBooleano res2 = (ValorBooleano)igual.avaliar();

        Assert.assertEquals(false, res1.getValor());
        Assert.assertEquals(true, res2.getValor());
        Assert.assertEquals(diferente.tipo(), Tipo.Inteiro);
    }

}