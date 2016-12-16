package br.unb.cic.poo.mh;

import br.unb.poo.mh.*;
import org.junit.Assert;
import org.junit.Test;

public class TesteExpressaoMenorOuIgual {

    @Test
    public void TesteMenorOuIgualSimples() {
        ValorInteiro int100  = new ValorInteiro(100);
        ValorInteiro int90 = new ValorInteiro(90);

        MenorOuIgual menor = new MenorOuIgual(int90, int100);

        ValorBooleano res = (ValorBooleano)menor.avaliar();

        Assert.assertEquals(true, res.getValor());
        Assert.assertEquals(menor.tipo(), Tipo.Booleano);
        
        TamanhoDasExpressoes tde = new TamanhoDasExpressoes();
        menor.aceitar(tde);
        Assert.assertEquals(tde.getTamanho(), 3);

        PrettyPrinter pp = new PrettyPrinter();
        pp.visitar(menor);
    }

    @Test
    public void TesteMenorOuIgualLimite() {
        ValorInteiro int100  = new ValorInteiro(100);

        MenorOuIgual menor = new MenorOuIgual(int100, int100);

        ValorBooleano res = (ValorBooleano)menor.avaliar();

        Assert.assertEquals(true, res.getValor());
        Assert.assertEquals(menor.tipo(), Tipo.Booleano);
    }
}