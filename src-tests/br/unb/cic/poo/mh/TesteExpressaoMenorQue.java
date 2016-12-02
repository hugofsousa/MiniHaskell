package br.unb.cic.poo.mh;

import br.unb.poo.mh.MenorQue;
import br.unb.poo.mh.TamanhoDasExpressoes;
import br.unb.poo.mh.Tipo;
import br.unb.poo.mh.ValorBooleano;
import br.unb.poo.mh.ValorInteiro;
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
        Assert.assertEquals(menor.tipo(), Tipo.Inteiro);
        
        TamanhoDasExpressoes tde = new TamanhoDasExpressoes();
        menor.aceitar(tde);
        Assert.assertEquals(tde.getTamanho(), 3);
    }
}