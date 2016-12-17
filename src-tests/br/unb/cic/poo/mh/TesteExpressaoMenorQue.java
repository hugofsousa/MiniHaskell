package br.unb.cic.poo.mh;

import br.unb.poo.mh.*;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TesteExpressaoMenorQue {

    @Test
    public void TesteMenorSimples() {
        ValorInteiro int100  = new ValorInteiro(100);
        ValorInteiro int90 = new ValorInteiro(90);

        MenorQue menor = new MenorQue(int100, int90);

        ValorBooleano res = (ValorBooleano)menor.avaliar();

        Assert.assertEquals(false, res.getValor());
        Assert.assertEquals(menor.tipo(), Tipo.Booleano);
        
        TamanhoDasExpressoes tde = new TamanhoDasExpressoes();
        menor.aceitar(tde);
        Assert.assertEquals(tde.getTamanho(), 3);

        PrettyPrinter pp = new PrettyPrinter();
        pp.visitar(menor);
    }
}