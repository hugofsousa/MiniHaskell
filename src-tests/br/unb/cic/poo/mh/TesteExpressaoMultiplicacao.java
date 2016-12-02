package br.unb.cic.poo.mh;

import org.junit.Assert;
import org.junit.Test;

import br.unb.poo.mh.Expressao;
import br.unb.poo.mh.ExpressaoSoma;
import br.unb.poo.mh.Multiplicacao;
import br.unb.poo.mh.TamanhoDasExpressoes;
import br.unb.poo.mh.Tipo;
import br.unb.poo.mh.ValorInteiro;

public class TesteExpressaoMultiplicacao {

	@Test
	public void testeExpressaoOk() {
		ValorInteiro v10 = new ValorInteiro(10);
		ValorInteiro v5 = new ValorInteiro(5);
		Expressao m = new Multiplicacao(v10, new ExpressaoSoma(v10, v5));
		
		Assert.assertEquals(new ValorInteiro(150), m.avaliar());
		Assert.assertEquals(m.tipo(), Tipo.Inteiro);
		
		TamanhoDasExpressoes tde = new TamanhoDasExpressoes();
        m.aceitar(tde);
        Assert.assertEquals(tde.getTamanho(), 3);
	}

}
