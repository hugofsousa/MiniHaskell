package br.unb.poo.mh;

public class TamanhoDasExpressoes implements Visitor {

	private int tamanho = 0;

	public int getTamanho() {
		return tamanho;
	}
	
	public void visitarEB(ExpressaoBinaria exp){
		exp.expEsquerda.aceitar(this);
		exp.expDireita.aceitar(this);
		tamanho ++;
	}

	public void visitarEU(ExpressaoUnaria exp){
		tamanho ++;
		exp.exp.aceitar(this);
	}

	public void zera_cont(){
		tamanho = 0;
	}

	@Override
	public void visitar(ValorInteiro exp) {
		tamanho ++;
	}

	@Override
	public void visitar(ValorBooleano exp) {
		tamanho ++;
	}

	@Override
	public void visitar(ExpressaoSoma exp) {
		 visitarEB(exp);
	}

	@Override
	public void visitar(ExpressaoMultiplicacao exp) {
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
		tamanho += 1;
		exp.parametros.forEach(p -> {
			p.aceitar(this);
		});

//		for(Expressao p: exp.parametros) {
//			p.aceitar(this);
//		}
	}

	@Override
	public void visitar(Identificador exp) {
		tamanho ++;
	}

	@Override
	public void visitar(ExpressaoDivisao exp) {
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
	public void visitar(MenorQue exp) {
		visitarEB(exp);
	}

	@Override
	public void visitar(MenorOuIgual exp) {
		visitarEB(exp);
	}

	@Override
	public void visitar(MaiorOuIgual exp) {
		visitarEB(exp);
	}

	@Override
	public void visitar(Diferente exp) {
		visitarEB(exp);
	}

	@Override
	public void visitar(Not exp) {
		visitarEU(exp);
	}
	
	@Override
	public void visitar(ListaComValor<?> exp) {
		
	}
	
	@Override
	public void visitar(ListaVazia<?> exp) {
		
	}
}
