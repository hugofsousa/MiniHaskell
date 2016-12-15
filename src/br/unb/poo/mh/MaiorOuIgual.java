package br.unb.poo.mh;

/**
 * 
 * @author Hugo & Eduardo
 *
 */
public class MaiorOuIgual extends ExpressaoBinaria {

	public MaiorOuIgual(Expressao expEsquerda, Expressao expDireita) {
		super(expEsquerda, expDireita);
	}

	@Override
	public Valor avaliar() {
		ValorInteiro ve = (ValorInteiro) expEsquerda.avaliar();
		ValorInteiro vd = (ValorInteiro) expDireita.avaliar();

		return new ValorBooleano(ve.getValor() >= vd.getValor());
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
