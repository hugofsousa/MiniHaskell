package br.unb.cic.poo.mh;

import br.unb.poo.mh.*;
import org.junit.Assert;
import org.junit.Test;

public class TesteExpressaoDiferente {

    @Test
    public void TesteDiferenteUm() {
        ValorInteiro int100  = new ValorInteiro(100);
        ValorInteiro int90 = new ValorInteiro(90);
        ValorInteiro intcem = new ValorInteiro(100);

        Diferente diferente = new Diferente(int100, int90);
        Diferente igual = new Diferente(int100, intcem);

        ValorBooleano res1 = (ValorBooleano)diferente.avaliar();
        ValorBooleano res2 = (ValorBooleano)igual.avaliar();

        Assert.assertEquals(true, res1.getValor());
        Assert.assertEquals(false, res2.getValor());
        Assert.assertEquals(diferente.tipo(), Tipo.Booleano);
    }

    @Test
    public void testeIgualInteiro(){


        ValorInteiro v5 = new ValorInteiro(5);
        ValorInteiro v10 = new ValorInteiro(10);

        Expressao igual1 = new Diferente(v5, v10);
        Expressao igual2 = new Diferente(v5, v5);

        Assert.assertEquals(new ValorBooleano(true), igual1.avaliar());
        Assert.assertEquals(new ValorBooleano(false), igual2.avaliar());
    }

}
