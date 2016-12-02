package br.unb.cic.poo.mh;

import br.unb.poo.mh.Divisao;
import br.unb.poo.mh.ValorInteiro;
import org.junit.Assert;
import org.junit.Test;


public class TesteDivisao {

    @Test
    public void TesteDivisaoUm() {
        ValorInteiro v10 = new ValorInteiro(10);
        ValorInteiro v5 = new ValorInteiro(5);
        Divisao div = new Divisao(v10, v5);
        Assert.assertEquals(new ValorInteiro(2), div.avaliar());
    }

    @Test
    public void TesteDivisaoDois() {
        ValorInteiro v100  = new ValorInteiro(100);
        ValorInteiro v10 = new ValorInteiro(10);
        ValorInteiro v5  = new ValorInteiro(5);

        Divisao divisao1 = new Divisao(v100, v10);
        Divisao divisao2 = new Divisao(divisao1, v5);

        ValorInteiro res = (ValorInteiro)divisao2.avaliar();

        Assert.assertEquals(new Integer(2), res.getValor());
    }



}