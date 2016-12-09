package br.unb.poo.mh;

import java.util.ArrayList;

public class ListaVazia extends Lista {

	@Override
	public Valor avaliar() {
		return new ValorLista(new ArrayList<ValorInteiro>());
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
		
	}

}
