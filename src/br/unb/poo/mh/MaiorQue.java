package br.unb.poo.mh;

public class MaiorQue extends ExpressaoBinariaBool {
	/**
	 * 
	 * @param expDireita -> MAIOR
	 * @param expEsquerda -> MENOR
	 */
	public MaiorQue(Expressao expDireita, Expressao expEsquerda) {
		super(expDireita, expEsquerda);
	}

	@Override
	public Valor avaliar() {
		ValorInteiro vMaior = (ValorInteiro) expDireita.avaliar();
		ValorInteiro vMenor = (ValorInteiro) expEsquerda.avaliar();
		
		return new ValorBooleano(vMaior.getValor() > vMenor.getValor());
	}

	@Override
	public Tipo tipo() {
		return (expDireita.tipo() == Tipo.Inteiro && expEsquerda.tipo() == Tipo.Inteiro) ? Tipo.Inteiro : Tipo.Error;
	}

	@Override
	public void aceitar(Visitor v) {
		v.visitar(this);
	}
}
