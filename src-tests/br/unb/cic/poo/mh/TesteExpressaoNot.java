package br.unb.cic.poo.mh;

import br.unb.poo.mh.And;
import br.unb.poo.mh.Not;
import br.unb.poo.mh.Or;
import br.unb.poo.mh.ValorBooleano;
import org.junit.Assert;
import org.junit.Test;

public class TesteExpressaoNot {
    @Test
    public void testNOTSimples() {
        ValorBooleano falso  = new ValorBooleano(false);
        ValorBooleano verdadeiro = new ValorBooleano(true);

        Not not1 = new Not(verdadeiro);
        Not not2 = new Not(falso);

        ValorBooleano res1 = (ValorBooleano)not1.avaliar();
        ValorBooleano res2 = (ValorBooleano)not2.avaliar();

        Assert.assertEquals(new Boolean(false), res1.getValor());
        Assert.assertEquals(new Boolean(true), res2.getValor());
    }


    @Test
    public void testNOTComplexa() {
        ValorBooleano vTrue  = new ValorBooleano(true);	//new ValorBooleano(true);
        ValorBooleano vFalse = new ValorBooleano(false);	//new ValorBooleano(false);

        Or or1 = new Or(vTrue, vFalse);
        And and = new And(vTrue, vTrue);
        Or or2 = new Or(or1, and);
        Not not = new Not(or2);

        ValorBooleano res = (ValorBooleano) not.avaliar();

        Assert.assertEquals(vFalse, res);
    }

}
