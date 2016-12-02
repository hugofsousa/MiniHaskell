package br.unb.cic.poo.mh;

import br.unb.poo.mh.Expressao;
import br.unb.poo.mh.ExpressaoSubtracao;
import br.unb.poo.mh.TamanhoDasExpressoes;
import br.unb.poo.mh.Tipo;
import br.unb.poo.mh.ValorInteiro;
import org.junit.Assert;
import org.junit.Test;

public class TesteExpressaoSubtracao {

    @Test
    public void testSubtracaoSimples() {
        ValorInteiro v20  = new ValorInteiro(20);
        ValorInteiro v10 = new ValorInteiro(10);

        ExpressaoSubtracao subtracao = new ExpressaoSubtracao(v20, v10);
        
        Assert.assertEquals(subtracao.tipo(), Tipo.Inteiro);

        ValorInteiro res = (ValorInteiro)subtracao.avaliar();

        Assert.assertEquals(new Integer(10), res.getValor());
        
        TamanhoDasExpressoes tde = new TamanhoDasExpressoes();
        v20.aceitar(tde);
        Assert.assertEquals(tde.getTamanho(), 3);
    }

    @Test
    public void testSubtracaoNegativa() {
        ValorInteiro v5  = new ValorInteiro(5);
        ValorInteiro v10 = new ValorInteiro(10);

        ExpressaoSubtracao subtracao = new ExpressaoSubtracao(v5, v10);
        Assert.assertEquals(subtracao.tipo(), Tipo.Inteiro);

        ValorInteiro res = (ValorInteiro)subtracao.avaliar();

        Assert.assertEquals(new Integer(-5), res.getValor());
    }

    @Test
    public void testSubtracaoComplexa() {
        ValorInteiro v5  = new ValorInteiro(5);
        ValorInteiro v10 = new ValorInteiro(10);
        ValorInteiro v20 = new ValorInteiro(20);

        ExpressaoSubtracao subtracao1 = new ExpressaoSubtracao(v5, v10);
        ExpressaoSubtracao subtracao2 = new ExpressaoSubtracao((ValorInteiro)subtracao1.avaliar(), v20);

        ValorInteiro res = (ValorInteiro)subtracao2.avaliar();

        Assert.assertEquals(new Integer(-25), res.getValor());
    }
}