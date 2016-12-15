package br.unb.cic.poo.mh;

import br.unb.poo.mh.MaiorOuIgual;
import br.unb.poo.mh.TamanhoDasExpressoes;
import br.unb.poo.mh.Tipo;
import br.unb.poo.mh.ValorBooleano;
import br.unb.poo.mh.ValorInteiro;
import org.junit.Assert;
import org.junit.Test;

public class TesteExpressaoMaiorOuIgual {

    @Test
    public void TesteMaiorOuIgualSimples() {
        ValorInteiro int100  = new ValorInteiro(100);
        ValorInteiro int90 = new ValorInteiro(90);

        MaiorOuIgual menor = new MaiorOuIgual(int90, int100);

        ValorBooleano res = (ValorBooleano)menor.avaliar();

        Assert.assertEquals(false, res.getValor());
        
        Assert.assertEquals(menor.tipo(), Tipo.Booleano);
        
        TamanhoDasExpressoes tde = new TamanhoDasExpressoes();
        menor.aceitar(tde);
        Assert.assertEquals(tde.getTamanho(), 3);
    }

    @Test
    public void TesteMaiorOuIgualLimite() {
        ValorInteiro int100  = new ValorInteiro(100);

        MaiorOuIgual menor = new MaiorOuIgual(int100, int100);

        ValorBooleano res = (ValorBooleano)menor.avaliar();

        Assert.assertEquals(true, res.getValor());
        Assert.assertEquals(menor.tipo(), Tipo.Booleano);
    }
}
