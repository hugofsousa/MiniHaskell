package br.unb.poo.mh;

/**
 * 
 * @author Hugo & Eduardo
 *
 */
public class And extends ExpressaoBinaria {
	
	public And(Expressao expEsquerda, Expressao expDireita){
		super(expEsquerda, expDireita);
	}

	@Override
	public Valor avaliar() {
		ValorBooleano ve = (ValorBooleano) expEsquerda.avaliar();
		ValorBooleano vd = (ValorBooleano) expDireita.avaliar();
		
		return new ValorBooleano(ve.getValor() && vd.getValor());
	}

	@Override
	public Tipo tipo() {
		return (expEsquerda.tipo() == Tipo.Booleano && expDireita.tipo() == Tipo.Booleano) ? Tipo.Booleano : Tipo.Error;
	}

	@Override
	public void aceitar(Visitor v) {
		v.visitar(this);
	}

	public boolean checarTipo() {
		return tipo().equals(Tipo.Booleano);
	}

}
