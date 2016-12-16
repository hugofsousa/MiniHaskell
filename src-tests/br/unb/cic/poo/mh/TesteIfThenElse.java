package br.unb.cic.poo.mh;

import br.unb.poo.mh.*;
import org.junit.Test;

import org.junit.Assert;

public class TesteIfThenElse {
	
	@Test
	public void TesteUm(){
		ValorBooleano falso  = new ValorBooleano(false);
        ValorBooleano verdadeiro = new ValorBooleano(true);
        ValorInteiro um = new ValorInteiro(1);
        ValorInteiro dois = new ValorInteiro(2);
        
        ExpressaoDivisao div = new ExpressaoDivisao(dois, dois);
        
        Igual igual = new Igual(um, div);
		
		IfThenElse ite = new IfThenElse(igual, verdadeiro, falso);
		
		Assert.assertEquals(verdadeiro, ite.avaliar());
		Assert.assertEquals(ite.tipo(), Tipo.Booleano);

		Assert.assertEquals(verdadeiro, ite.avaliar());
		Assert.assertEquals(true, ite.checarTipo());

		TamanhoDasExpressoes tde = new TamanhoDasExpressoes();
        ite.aceitar(tde);
        Assert.assertEquals(tde.getTamanho(), 8);

		PrettyPrinter pp = new PrettyPrinter();
		pp.visitar(ite);
	}
}