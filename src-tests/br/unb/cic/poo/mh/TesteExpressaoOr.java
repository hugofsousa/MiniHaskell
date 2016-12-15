package br.unb.cic.poo.mh;

import br.unb.poo.mh.Or;
import br.unb.poo.mh.TamanhoDasExpressoes;
import br.unb.poo.mh.Tipo;
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

        Assert.assertEquals(Boolean.TRUE, res1.getValor());
        Assert.assertEquals(Boolean.FALSE, res2.getValor());
        Assert.assertEquals(Boolean.TRUE, res3.getValor());
        Assert.assertEquals(Boolean.TRUE, res4.getValor());
        
        Assert.assertEquals(and1.tipo(), Tipo.Booleano);
        
        TamanhoDasExpressoes tde = new TamanhoDasExpressoes();
        and1.aceitar(tde);
        Assert.assertEquals(tde.getTamanho(), 3);
    }

    @Test
    public void TesteOrDois() {
        ValorBooleano falso  = new ValorBooleano(false);
        ValorBooleano verdadeiro = new ValorBooleano(true);

        Or and1 = new Or(verdadeiro,falso);
        Or and2 = new Or(verdadeiro,verdadeiro);
        Or and3 = new Or(and1, verdadeiro);
        Or and4 = new Or(and2, verdadeiro);
        
        Assert.assertEquals(and1.tipo(), Tipo.Booleano);

        ValorBooleano res1 = (ValorBooleano)and3.avaliar();
        ValorBooleano res2 = (ValorBooleano)and4.avaliar();

        Assert.assertEquals(Boolean.TRUE, res1.getValor());
        Assert.assertEquals(Boolean.TRUE, res2.getValor());
    }

}