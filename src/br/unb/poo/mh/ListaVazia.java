package br.unb.poo.mh;

public class ListaVazia<T extends Valor> extends ValorLista<T> {

	public ListaVazia() {
		super(null);
	}

	@Override
	public Valor avaliar() {
			ListaVazia<T> vA = this;
			Valor Resultado = vA.getCabeca();
			return Resultado;
	}

	@Override
	public Tipo tipo() {
		return Tipo.ListaVazia;
	}

	@Override
	public boolean checarTipo() {
		return true;
	}

	@Override
	public void aceitar(Visitor visitor) {
		visitor.visitar(this);
	}

	@Override
	public ValorLista<T> inserir(T novoValor) {
		return new ListaComValor<T>(novoValor);
	}

	@Override
	public ValorLista<T> remover() {
		return null;
	}	
		
}
