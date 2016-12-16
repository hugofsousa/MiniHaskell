package br.unb.cic.poo.mh;

import org.junit.Test;

import br.unb.poo.mh.ListaComValor;
import br.unb.poo.mh.PrettyPrinter;
import br.unb.poo.mh.ValorInteiro;

public class TesteLista {
	@Test
	public void TesteListaComValor1(){
		ListaComValor<ValorInteiro> lcv = new ListaComValor<>(new ValorInteiro(1));
		lcv = (ListaComValor<ValorInteiro>) lcv.inserir(new ValorInteiro(2));
		lcv = (ListaComValor<ValorInteiro>) lcv.inserir(new ValorInteiro(3));
		lcv = (ListaComValor<ValorInteiro>) lcv.inserir(new ValorInteiro(4));
		
		PrettyPrinter pp = new PrettyPrinter();
		pp.visitar(lcv);
	}
}
