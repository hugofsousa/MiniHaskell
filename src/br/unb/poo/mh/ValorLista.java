package br.unb.poo.mh;

import java.util.List;

public class ValorLista extends ValorParametrizado<List<ValorInteiro>>{

	public ValorLista(List<ValorInteiro> valor) {
		super(valor);
	}

	@Override
	public Tipo tipo() {
		return Tipo.Lista;
	}

	@Override
	public void aceitar(Visitor v) {
		
	}

}
