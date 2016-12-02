package br.unb.poo.mh;

/**
 * @author Hugo & Eduardo
 */
public class Divisao extends ExpressaoBinariaInt {
	
	public Divisao(Expressao expEsquerda, Expressao expDireita) {
		super(expDireita, expEsquerda);
	}
	
	@Override
	public Valor avaliar() {
		ValorInteiro ve = (ValorInteiro)expEsquerda.avaliar();
		ValorInteiro vd = (ValorInteiro)expDireita.avaliar();
		
		if(ve.getValor() == 0){
			return new ValorInteiro(0);
		}
		
		return new ValorInteiro(ve.getValor() / vd.getValor());
	}

	@Override
	public Tipo tipo() {
		return (expEsquerda.tipo() == Tipo.Inteiro && expDireita.tipo() == Tipo.Inteiro) ? Tipo.Inteiro : Tipo.Error;
	}

	@Override
	public void aceitar(Visitor v) {
		v.visitar(this);
	}

}
