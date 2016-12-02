package br.unb.poo.mh;

public class Identificador implements Expressao {
	String id;

	public Identificador(String id) {
		this.id = id;
	}

	@Override
	public Tipo tipo() {
		Expressao exp = Ambiente.instance().getExpressao(id);
		if(exp != null) {
			return exp.tipo();
		}
		throw new RuntimeException("Variaval: " + id + " nao declarada");
	}

	@Override
	public boolean checarTipo() {
		Expressao exp = Ambiente.instance().getExpressao(id);
		if(exp != null) {
			return exp.checarTipo();
		}
		throw new RuntimeException("Variaval: " + id + " nao declarada");
	}

	@Override
	public Valor avaliar() {
		Expressao exp = Ambiente.instance().getExpressao(id);
		if(exp != null) {
			return exp.avaliar();
		}
		throw new RuntimeException("Variaval: " + id + " nao declarada");
	}

	@Override
	public void aceitar(Visitor v) {
		v.visitar(this);
	}
}
