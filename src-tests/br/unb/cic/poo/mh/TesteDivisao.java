package br.unb.cic.poo.mh;

import br.unb.poo.mh.*;
import org.junit.Assert;
import org.junit.Test;


public class TesteDivisao {

    ValorInteiro v5 = new ValorInteiro(5);
    ValorInteiro v10 = new ValorInteiro(10);
    ValorInteiro v100 = new ValorInteiro(100);

    @Test
    public void TesteDivisaoUm() {
        ExpressaoDivisao div = new ExpressaoDivisao(v10, v5);
        Assert.assertEquals(new ValorInteiro(2), div.avaliar());
        
        Assert.assertEquals(div.tipo(), Tipo.Inteiro);
        
        TamanhoDasExpressoes tde = new TamanhoDasExpressoes();
        div.aceitar(tde);
        Assert.assertEquals(tde.getTamanho(), 3);

        PrettyPrinter pp = new PrettyPrinter();
        pp.visitar(div);
    }

    @Test
    public void TesteDivisaoDois() {
        ExpressaoDivisao expressaoDivisao1 = new ExpressaoDivisao(v100, v10);
        ExpressaoDivisao expressaoDivisao2 = new ExpressaoDivisao(expressaoDivisao1, v5);

        ValorInteiro res = (ValorInteiro) expressaoDivisao2.avaliar();

        Assert.assertEquals(new Integer(2), res.getValor());
    }

}