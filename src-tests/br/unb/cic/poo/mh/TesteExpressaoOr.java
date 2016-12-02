package br.unb.cic.poo.mh;

import br.unb.poo.mh.Or;
import br.unb.poo.mh.ValorBooleano;
import org.junit.Assert;
import org.junit.Test;

public class TesteExpressaoOr {

    @Test
    public void TesteOrUm() {
        ValorBooleano falso  = new ValorBooleano(false);
        ValorBooleano verdadeiro = new ValorBooleano(true);

        Or and1 = new Or(falso, verdadeiro);
        Or and2 = new Or(falso, falso);
        Or and3 = new Or(verdadeiro,falso);
        Or and4 = new Or(verdadeiro, verdadeiro);

        ValorBooleano res1 = (ValorBooleano)and1.avaliar();
        ValorBooleano res2 = (ValorBooleano)and2.avaliar();
        ValorBooleano res3 = (ValorBooleano)and3.avaliar();
        ValorBooleano res4 = (ValorBooleano)and4.avaliar();

        Assert.assertEquals(new Boolean(true), res1.getValor());
        Assert.assertEquals(new Boolean(false), res2.getValor());
        Assert.assertEquals(new Boolean(true), res3.getValor());
        Assert.assertEquals(new Boolean(true), res4.getValor());
    }

    @Test
    public void TesteOrDois() {
        ValorBooleano falso  = new ValorBooleano(false);
        ValorBooleano verdadeiro = new ValorBooleano(true);

        Or and1 = new Or(verdadeiro,falso);
        Or and2 = new Or(verdadeiro,verdadeiro);
        Or and3 = new Or(and1, verdadeiro);
        Or and4 = new Or(and2, verdadeiro);

        ValorBooleano res1 = (ValorBooleano)and3.avaliar();
        ValorBooleano res2 = (ValorBooleano)and4.avaliar();

        Assert.assertEquals(new Boolean(true), res1.getValor());
        Assert.assertEquals(new Boolean(true), res2.getValor());
    }

}