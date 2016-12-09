package br.unb.poo.mh;

import java.util.ArrayList;
import java.util.List;

public class ListaComValor extends Lista {
	ValorParametrizado<?> cabeca;
	Lista calda;
	
	public ListaComValor(ValorParametrizado<?> cabeca, Lista calda){
		this.cabeca = cabeca;
		this.calda = calda;
	}
	
	@Override
	public Valor avaliar() {
		List<ValorInteiro> lista = new ArrayList<>();
		lista.add((ValorInteiro) cabeca.avaliar());
		for(ValorInteiro vi : ((ValorLista) calda.avaliar()).getValor()){
			lista.add((ValorInteiro) vi.avaliar());
		}
		
		ValorLista valorLista = new ValorLista(lista);
		
		return valorLista;
	}

	@Override
	public Tipo tipo() {
		return null;
	}

	@Override
	public boolean checarTipo() {
		return false;
	}

	@Override
	public void aceitar(Visitor v) {
		v.visitar(this);
	}

}
