package br.unb.cic.poo.mh;

import br.unb.poo.mh.*;
import org.junit.Assert;
import org.junit.Test;

public class TesteExpressaoOr {

    @Test
    public void TesteOrUm() {
        ValorBooleano falso  = new ValorBooleano(false);
        ValorBooleano verdadeiro = new ValorBooleano(true);

        Or or1 = new Or(falso, verdadeiro);
        Or or2 = new Or(falso, falso);
        Or or3 = new Or(verdadeiro,falso);
        Or or4 = new Or(verdadeiro, verdadeiro);

        ValorBooleano res1 = (ValorBooleano)or1.avaliar();
        ValorBooleano res2 = (ValorBooleano)or2.avaliar();
        ValorBooleano res3 = (ValorBooleano)or3.avaliar();
        ValorBooleano res4 = (ValorBooleano)or4.avaliar();

        Assert.assertEquals(Boolean.TRUE, res1.getValor());
        Assert.assertEquals(Boolean.FALSE, res2.getValor());
        Assert.assertEquals(Boolean.TRUE, res3.getValor());
        Assert.assertEquals(Boolean.TRUE, res4.getValor());
        
        Assert.assertEquals(or1.tipo(), Tipo.Booleano);
        
        TamanhoDasExpressoes tde = new TamanhoDasExpressoes();
        or1.aceitar(tde);
        Assert.assertEquals(tde.getTamanho(), 3);

        PrettyPrinter pp = new PrettyPrinter();
        pp.visitar(or1);
    }

    @Test
    public void TesteOrDois() {
        ValorBooleano falso  = new ValorBooleano(false);
        ValorBooleano verdadeiro = new ValorBooleano(true);

        Or or1 = new Or(verdadeiro,falso);
        Or or2 = new Or(verdadeiro,verdadeiro);
        Or or3 = new Or(or1, verdadeiro);
        Or or4 = new Or(or2, verdadeiro);
        
        Assert.assertEquals(or1.tipo(), Tipo.Booleano);

        ValorBooleano res1 = (ValorBooleano)or3.avaliar();
        ValorBooleano res2 = (ValorBooleano)or4.avaliar();

        Assert.assertEquals(Boolean.TRUE, res1.getValor());
        Assert.assertEquals(Boolean.TRUE, res2.getValor());
    }

}