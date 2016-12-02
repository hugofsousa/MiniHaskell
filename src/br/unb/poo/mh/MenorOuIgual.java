package br.unb.poo.mh;

import br.unb.poo.mh.*;

/**
 * 
 * @author Hugo & Eduardo
 *
 */
public class MenorOuIgual extends ExpressaoBinariaBool {

	public MenorOuIgual(Expressao expDireita, Expressao expEsquerda) {
		super(expDireita, expEsquerda);
	}

	@Override
	public Valor avaliar() {
		ValorInteiro vd = (ValorInteiro) expDireita.avaliar();
		ValorInteiro ve = (ValorInteiro) expEsquerda.avaliar();
		
		return new ValorBooleano(vd.getValor() <= ve.getValor());
	}

	@Override
	public Tipo tipo() {
		return (expDireita.tipo() == Tipo.Inteiro && expEsquerda.tipo() == Tipo.Inteiro) ? Tipo.Inteiro : Tipo.Error;
	}

	@Override
	public void aceitar(Visitor v) {
		v.visitar(this);
	}
	
}
