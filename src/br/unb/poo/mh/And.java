package br.unb.poo.mh;

/**
 * 
 * @author Hugo
 *
 */
public class And extends ExpressaoBooleana {
	
	public And(Expressao expDireita, Expressao expEsquerda){
		super(expDireita, expEsquerda);
	}

	@Override
	public Valor avaliar() {
		ValorBooleano valorEsquerda = (ValorBooleano) expEsquerda.avaliar();
		ValorBooleano valorDireita = (ValorBooleano) expDireita.avaliar();
		
		return new ValorBooleano(valorEsquerda.getValor() && valorDireita.getValor());
	}

	@Override
	public Tipo tipo() {
		return (expEsquerda.tipo() == Tipo.Booleano && expDireita.tipo() == Tipo.Booleano) ? Tipo.Booleano : Tipo.Error;
	}

	@Override
	public void aceitar(Visitor v) {
		v.visitar(this);
	}

}
