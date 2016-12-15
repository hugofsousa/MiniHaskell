package br.unb.poo.mh;

public abstract class ExpressaoBinaria implements Expressao {
	protected Expressao expDireita;
	protected Expressao expEsquerda; 
	
	public ExpressaoBinaria(Expressao expEsquerda, Expressao expDireita) {
		this.expDireita = expDireita;
		this.expEsquerda = expEsquerda;
	}
	
}
