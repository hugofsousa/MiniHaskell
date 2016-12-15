package br.unb.poo.mh;

public class MaiorQue extends ExpressaoBinaria {
	/**
	 * 
	 * @param expDireita -> MAIOR
	 * @param expEsquerda -> MENOR
	 */
	public MaiorQue(Expressao expEsquerda, Expressao expDireita) {
		super(expEsquerda, expDireita);
	}

	@Override
	public Valor avaliar() {
		ValorInteiro vd = (ValorInteiro) expDireita.avaliar();
		ValorInteiro ve = (ValorInteiro) expEsquerda.avaliar();
		
		return new ValorBooleano(ve.getValor() > vd.getValor());
	}

	@Override
	public Tipo tipo() {
		return (expDireita.tipo() == Tipo.Inteiro && expEsquerda.tipo() == Tipo.Inteiro) ? Tipo.Booleano : Tipo.Error;
	}

	@Override
	public void aceitar(Visitor v) {
		v.visitar(this);
	}

	public boolean checarTipo() {
		return tipo().equals(Tipo.Booleano);
	}
}
