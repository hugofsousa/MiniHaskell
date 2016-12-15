package br.unb.cic.poo.mh;

import br.unb.poo.mh.And;
import br.unb.poo.mh.TamanhoDasExpressoes;
import br.unb.poo.mh.Tipo;
import br.unb.poo.mh.ValorBooleano;
import org.junit.Assert;
import org.junit.Test;

public class TesteAnd {
    @Test
    public void TesteAndUm() {
        ValorBooleano falso  = new ValorBooleano(false);
        ValorBooleano verdadeiro = new ValorBooleano(true);

        And and1 = new And(falso, verdadeiro);
        And and2 = new And(falso, falso);
        And and3 = new And(verdadeiro,falso);
        And and4 = new And(verdadeiro, verdadeiro);

        ValorBooleano res1 = (ValorBooleano)and1.avaliar();
        ValorBooleano res2 = (ValorBooleano)and2.avaliar();
        ValorBooleano res3 = (ValorBooleano)and3.avaliar();
        ValorBooleano res4 = (ValorBooleano)and4.avaliar();

        Assert.assertEquals(Boolean.FALSE, res1.getValor());
        Assert.assertEquals(Boolean.FALSE, res2.getValor());
        Assert.assertEquals(Boolean.FALSE, res3.getValor());
        Assert.assertEquals(Boolean.TRUE, res4.getValor());
        
        Assert.assertEquals(and1.tipo(), Tipo.Booleano);
        
        TamanhoDasExpressoes tde = new TamanhoDasExpressoes();
        and1.aceitar(tde);
        Assert.assertEquals(tde.getTamanho(), 3);
    }


    @Test
    public void TesteAndDois() {
        ValorBooleano falso  = new ValorBooleano(false);
        ValorBooleano verdadeiro = new ValorBooleano(true);

        And and1 = new And(verdadeiro,falso);
        And and2 = new And(verdadeiro,verdadeiro);
        And and3 = new And(and1, verdadeiro);
        And and4 = new And(and2, verdadeiro);

        ValorBooleano res1 = (ValorBooleano)and3.avaliar();
        ValorBooleano res2 = (ValorBooleano)and4.avaliar();

        Assert.assertEquals(Boolean.FALSE, res1.getValor());
        Assert.assertEquals(Boolean.TRUE, res2.getValor());
    }
}