package br.unb.cic.poo.mh;

import org.junit.Test;

import br.unb.poo.mh.ListaComValor;
import br.unb.poo.mh.ListaVazia;
import br.unb.poo.mh.PrettyPrinter;
import br.unb.poo.mh.ValorInteiro;

public class TesteLista {
	@Test
	public void TesteListaComValor1(){
		ListaVazia lv = new ListaVazia();
		ListaComValor lista1 = new ListaComValor(new ValorInteiro(1), lv);
		ListaComValor lista2 = new ListaComValor(new ValorInteiro(2), lista1);
		ListaComValor lista3 = new ListaComValor(new ValorInteiro(3), lista2);
		ListaComValor listaGeral = new ListaComValor(new ValorInteiro(4), lista3);
		
		PrettyPrinter pp = new PrettyPrinter();
		listaGeral.aceitar(pp);
	}
}
