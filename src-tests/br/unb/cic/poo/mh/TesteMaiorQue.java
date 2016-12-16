package br.unb.cic.poo.mh;

import br.unb.poo.mh.*;
import org.junit.Assert;
import org.junit.Test;

public class TesteMaiorQue {
    @Test
    public void TesteMaiorUm() {
        ValorInteiro int100  = new ValorInteiro(100);
        ValorInteiro int90 = new ValorInteiro(90);
        ValorInteiro int190 = new ValorInteiro(190);

        MaiorQue maior1 = new MaiorQue(int100, int90);
        MaiorQue maior = new MaiorQue(int100, int190);

        ValorBooleano res = (ValorBooleano)maior1.avaliar();
        ValorBooleano res2 = (ValorBooleano)maior.avaliar();

        Assert.assertEquals(true, res.getValor());
        Assert.assertEquals(false, res2.getValor());
        Assert.assertEquals(maior1.tipo(), Tipo.Booleano);
        
        TamanhoDasExpressoes tde = new TamanhoDasExpressoes();
        maior1.aceitar(tde);
        Assert.assertEquals(tde.getTamanho(), 3);

        PrettyPrinter pp = new PrettyPrinter();
        pp.visitar(maior1);
    }
}