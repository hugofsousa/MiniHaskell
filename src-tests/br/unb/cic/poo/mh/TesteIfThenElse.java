package br.unb.cic.poo.mh;

import static org.junit.Assert.*;

import org.junit.Test;

import br.unb.poo.mh.Divisao;
import br.unb.poo.mh.IfThenElse;
import br.unb.poo.mh.Igual;
import br.unb.poo.mh.TamanhoDasExpressoes;
import br.unb.poo.mh.ValorBooleano;
import br.unb.poo.mh.ValorInteiro;
import org.junit.Assert;
import org.junit.Test;

public class TesteIfThenElse {
	
	@Test
	public void TesteUm(){
		ValorBooleano falso  = new ValorBooleano(false);
        ValorBooleano verdadeiro = new ValorBooleano(true);
        ValorInteiro um = new ValorInteiro(1);
        ValorInteiro dois = new ValorInteiro(2);
        
        Divisao div = new Divisao(dois, dois);
        
        Igual igual = new Igual(um, div);
		
		IfThenElse ite = new IfThenElse(igual, verdadeiro, falso);
		
		Assert.assertEquals(verdadeiro, ite.avaliar());
//		Assert.assertEquals(ite.tipo(), Tipo.Inteiro);
		
		TamanhoDasExpressoes tde = new TamanhoDasExpressoes();
        ite.aceitar(tde);
        Assert.assertEquals(tde.getTamanho(), 4);
	}
}