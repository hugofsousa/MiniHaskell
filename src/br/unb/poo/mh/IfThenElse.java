package br.unb.poo.mh;

public class IfThenElse implements Expressao {
	Expressao condicao;
	Expressao clausulaThen;
	Expressao clausulaElse;
	
	public IfThenElse(Expressao condicao, Expressao clausulaThen, Expressao clausulaElse) {
		this.condicao = condicao;
		this.clausulaThen = clausulaThen;
		this.clausulaElse = clausulaElse;
	} 
	
	public Valor avaliar() {
		ValorBooleano valor = (ValorBooleano)condicao.avaliar();
		if(valor.getValor()) {
			return clausulaThen.avaliar();
		}
		return 	clausulaElse.avaliar();
	}

	@Override
	public Tipo tipo() {
		Tipo cond = condicao.tipo();

		if(cond.equals(Tipo.Booleano)) {
			if(clausulaThen.tipo().equals(clausulaElse.tipo())) {
				return clausulaThen.tipo();
			}
		}
		return Tipo.Error;
	}

	@Override
	public boolean checarTipo() {
		return !tipo().equals(Tipo.Error);
	}

	@Override
	public void aceitar(Visitor v) {
		v.visitar(this);
	}
}
