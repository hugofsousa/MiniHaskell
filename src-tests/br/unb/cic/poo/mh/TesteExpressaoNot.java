package br.unb.cic.poo.mh;


import br.unb.poo.mh.*;
import org.junit.Assert;
import org.junit.Test;

public class TesteExpressaoNot {
    @Test
    public void TesteNotUm() {
        ValorBooleano teste_false  = new ValorBooleano(false);
        ValorBooleano teste_true = new ValorBooleano(true);

        Not not1 = new Not(teste_true);
        Not not2 = new Not(teste_false);

        ValorBooleano res1 = (ValorBooleano)not1.avaliar();
        ValorBooleano res2 = (ValorBooleano)not2.avaliar();

        Assert.assertEquals(Boolean.FALSE, res1.getValor());
        Assert.assertEquals(Boolean.TRUE, res2.getValor());
        Assert.assertEquals(not1.tipo(), Tipo.Booleano);
        
        TamanhoDasExpressoes tde = new TamanhoDasExpressoes();
        not1.aceitar(tde);
        Assert.assertEquals(tde.getTamanho(), 2);

        PrettyPrinter pp = new PrettyPrinter();
        pp.visitar(not1);
    }


    @Test
    public void TesteNotDois() {
        ValorBooleano teste_true  = new ValorBooleano(true);	//new ValorBooleano(true);
        ValorBooleano teste_false = new ValorBooleano(false);	//new ValorBooleano(false);

        Or or1 = new Or(teste_true, teste_false);
        And and = new And(teste_true, teste_true);
        Or or2 = new Or(or1, and);
        Not not = new Not(or2);

        ValorBooleano res = (ValorBooleano) not.avaliar();

        Assert.assertEquals(teste_false, res);
    }

}
