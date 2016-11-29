package br.unb.poo.mh;

/**
 * 
 * @author Hugo
 *
 */
public abstract class ExpressaoBooleana implements Expressao {
	Expressao expDireita;
	Expressao expEsquerda;
	
	public ExpressaoBooleana(Expressao expDireita, Expressao expEsquerda){
		this.expDireita = expDireita;
		this.expEsquerda = expEsquerda;
	}
}
