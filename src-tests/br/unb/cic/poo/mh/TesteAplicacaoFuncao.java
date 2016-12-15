package br.unb.cic.poo.mh;

import java.util.ArrayList;
import java.util.List;

import br.unb.poo.mh.*;
import org.junit.Assert;
import org.junit.Test;

public class TesteAplicacaoFuncao {

	@Test
	public void testFuncaoAplicacaoBasica (){
		List<ArgumentoFormal> argumentos = new ArrayList<ArgumentoFormal>();
		ArgumentoFormal arg1 = new ArgumentoFormal("X", Tipo.Inteiro);
		argumentos.add(arg1);

		DeclaracaoFuncao funcao = new DeclaracaoFuncao("dobra", argumentos, new ExpressaoMultiplicacao(new Identificador("X"), new ValorInteiro(2)));
		Ambiente.instance().declaraFuncao(funcao);

		List<Expressao> valoresArgumentos = new ArrayList<Expressao>();
		valoresArgumentos.add(new ValorInteiro(4));

		AplicacaoFuncao expressao = new AplicacaoFuncao("dobra", valoresArgumentos);

		ValorInteiro resultado = (ValorInteiro) expressao.avaliar();

		Assert.assertEquals(new Integer(8), resultado.getValor());
	}

	@Test
	public void testAplicacaoComplexa(){
		List<ArgumentoFormal> argumentos = new ArrayList<ArgumentoFormal>();
		ArgumentoFormal arg1 = new ArgumentoFormal("X", Tipo.Inteiro);
		argumentos.add(arg1);

		Expressao condicao = new MenorOuIgual(new Identificador("X"), new ValorInteiro(2));
		Expressao then = new Identificador("X");
		Expressao clausulaElse = new ExpressaoMultiplicacao(new Identificador("X"), new ValorInteiro(2));

		DeclaracaoFuncao funcao = new DeclaracaoFuncao("MultiplicaAcimaDeDois", argumentos,
				new IfThenElse(condicao, then, clausulaElse));
		Ambiente.instance().declaraFuncao(funcao);

		List<Expressao> valoresArgumentos = new ArrayList<Expressao>();
		valoresArgumentos.add(new ValorInteiro(3));

		AplicacaoFuncao expressao = new AplicacaoFuncao("MultiplicaAcimaDeDois", valoresArgumentos);

		ValorInteiro resultado = (ValorInteiro) expressao.avaliar();
		Assert.assertEquals(new Integer(6), resultado.getValor());

		valoresArgumentos.remove(0);
		valoresArgumentos.add(new ValorInteiro(2));

		expressao = new AplicacaoFuncao("MultiplicaAcimaDeDois", valoresArgumentos);
		resultado = (ValorInteiro) expressao.avaliar();
		Assert.assertEquals(new Integer(2), resultado.getValor());

		valoresArgumentos.remove(0);
		valoresArgumentos.add(new ValorInteiro(1));

		expressao = new AplicacaoFuncao("MultiplicaAcimaDeDois", valoresArgumentos);
		resultado = (ValorInteiro) expressao.avaliar();
		Assert.assertEquals(new Integer(1), resultado.getValor());

	}

}