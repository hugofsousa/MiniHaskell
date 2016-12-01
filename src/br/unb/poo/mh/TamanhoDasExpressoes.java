package br.unb.poo.mh;

public class TamanhoDasExpressoes implements Visitor {

	private int tamanho = 0;
	public int getTamanho() {
		return tamanho;
	}
	
	public void visitarEB(ExpressaoBinaria exp){
		exp.expEsquerda.aceitar(this);
		 exp.expDireita.aceitar(this);
		 tamanho += 1;
	}

	public void visitarEU(ExpressaoUnaria exp){
		exp.exp.aceitar(this);
		tamanho += 1;
	}

	@Override
	public void visitar(ValorInteiro exp) {
		tamanho += 1;
	}

	@Override
	public void visitar(ValorBooleano exp) {
		tamanho += 1;
	}

	@Override
	public void visitar(ExpressaoSoma exp) {
		 visitarEB(exp);
	}

	@Override
	public void visitar(Multiplicacao exp) {
		visitarEB(exp);	
	}

	@Override
	public void visitar(IfThenElse exp) {
		exp.condicao.aceitar(this);
		exp.clausulaThen.aceitar(this);
		exp.clausulaElse.aceitar(this);
		tamanho += 1;
	}

	@Override
	public void visitar(AplicacaoFuncao exp) {
		exp.parametros.stream().forEach(p -> { p.aceitar(this); });
		tamanho += 1;
		
//		for(Expressao p: exp.parametros) {
//			p.aceitar(this);
//		}
	}

	@Override
	public void visitar(Identificador exp) {
		tamanho += 1;
	}

	@Override
	public void visitar(Divisao exp) {
		visitarEB(exp);	
	}

	@Override
	public void visitar(ExpressaoSubtracao exp) {
		visitarEB(exp);	
	}

	@Override
	public void visitar(And exp) {
		visitarEB(exp);
	}

	@Override
	public void visitar(Or exp) {
		visitarEB(exp);
	}

	@Override
	public void visitar(Igual exp) {
		visitarEB(exp);
	}
	
	@Override
	public void visitar(MaiorQue exp) {
		visitarEB(exp);
	}

	@Override
	public void visitar(Not exp) {
		visitarEU(exp);
	}

}
