package br.unb.poo.mh;

public abstract class ValorLista<T extends Valor> extends Valor{
	private T cabeca;
	private ValorLista <T> cauda;
	
	public ValorLista(T head) {
		this.cabeca = head;
		this.cauda = null;
	}
	
	public T getCabeca() {
		return cabeca;
	}

	public void setInicio(T inicio) {
		this.cabeca = inicio;
	}

	public ValorLista<T> getCauda() {
		return cauda;
	}

	public void setCauda(ValorLista<T> cauda) {
		this.cauda = cauda;
	}

	public abstract ValorLista<T> inserir(T novoValor);
	
	public abstract ValorLista<T> remover();
	
	public ValorInteiro tamanho(){
		int tamanho = 0;
		ValorLista<?> auxiliar = this;
		
		while(!(auxiliar.tipo().equals(Tipo.ListaVazia))){
			tamanho++;
			auxiliar = ((ListaComValor<?>)auxiliar).getCauda();
		}
		
		return new ValorInteiro(tamanho);
	}
	
	public ValorLista<?> buscaPosicao(ValorInteiro posicao){
		int pos = posicao.getValor();
		ValorLista<?> atual = this;
		
		for(int i=0; i<pos && atual.tipo()!=Tipo.ListaVazia; i++){
			if(i>pos){
				return null;
			}
			
			atual = atual.getCauda();
		}
		if(atual.tipo() == Tipo.ListaVazia){
			return null;
		}
		return atual;
	}
	
}