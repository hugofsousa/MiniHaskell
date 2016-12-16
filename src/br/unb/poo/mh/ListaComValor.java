package br.unb.poo.mh;

public class ListaComValor<T extends Valor> extends ValorLista<T> {

	public ListaComValor(T inicio) {
		super(inicio);
		ListaVazia<T> Resto = new ListaVazia<T>();
		this.setCauda(Resto);
	}

	@Override
	public Valor avaliar() {
		return this;
	}

	@Override
	public Tipo tipo() {
		return Tipo.ListaComValor;
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
		this.setCauda(this.getCauda().inserir(novoValor));
		
		return this;
	}

	@Override
	public ValorLista<T> remover() {
		// TODO
		return this;
	}	
	

}
