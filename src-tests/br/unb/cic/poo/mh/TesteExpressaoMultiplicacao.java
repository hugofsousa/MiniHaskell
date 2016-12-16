package br.unb.cic.poo.mh;

import br.unb.poo.mh.*;
import org.junit.Assert;
import org.junit.Test;

public class TesteExpressaoMultiplicacao {

	@Test
	public void testeExpressaoOk() {
		ValorInteiro v10 = new ValorInteiro(10);
		ValorInteiro v5 = new ValorInteiro(5);
		ExpressaoMultiplicacao m = new ExpressaoMultiplicacao(v10, new ExpressaoSoma(v10, v5));

		Assert.assertEquals(new ValorInteiro(150), m.avaliar());
		Assert.assertEquals(m.tipo(), Tipo.Inteiro);

		Expressao tam = new ExpressaoMultiplicacao(v10, v5);
		TamanhoDasExpressoes tde = new TamanhoDasExpressoes();
        tam.aceitar(tde);
        Assert.assertEquals(tde.getTamanho(), 3);

		PrettyPrinter pp = new PrettyPrinter();
		pp.visitar(m);
	}

}
