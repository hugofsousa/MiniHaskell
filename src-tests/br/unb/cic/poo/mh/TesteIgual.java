package br.unb.cic.poo.mh;

import br.unb.poo.mh.*;
import org.junit.Assert;
import org.junit.Test;

public class TesteIgual {

    @Test
    public void TesteIgualUm() {
        ValorInteiro int100  = new ValorInteiro(100);
        ValorInteiro int90 = new ValorInteiro(90);
        ValorInteiro intcem = new ValorInteiro(100);

        Igual diferente = new Igual(int100, int90);
        Igual igual = new Igual(int100, intcem);

        ValorBooleano res1 = (ValorBooleano)diferente.avaliar();
        ValorBooleano res2 = (ValorBooleano)igual.avaliar();

        Assert.assertEquals(false, res1.getValor());
        Assert.assertEquals(true, res2.getValor());
        Assert.assertEquals(diferente.tipo(), Tipo.Booleano);

        PrettyPrinter pp = new PrettyPrinter();
        pp.visitar(igual);
    }

    @Test
    public void testeIgualInteiro(){


        ValorInteiro v5 = new ValorInteiro(5);
        ValorInteiro v10 = new ValorInteiro(10);

        Expressao igual1 = new Igual(v5, v10);
        Expressao igual2 = new Igual(v5, v5);

        Assert.assertEquals(new ValorBooleano(false), igual1.avaliar());
        Assert.assertEquals(new ValorBooleano(true), igual2.avaliar());

        TamanhoDasExpressoes tde = new TamanhoDasExpressoes();
        igual1.aceitar(tde);
        Assert.assertEquals(tde.getTamanho(), 3);
    }

}