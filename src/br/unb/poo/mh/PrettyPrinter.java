package br.unb.poo.mh;

public class PrettyPrinter implements Visitor{

	@Override
	public void visitar(ValorInteiro exp) {
		System.out.print(exp.getValor());
	}

	@Override
	public void visitar(ValorBooleano exp) {
		System.out.print(exp.getValor());
	}
	
	public void visitarEB(ExpressaoBinaria exp, String operador){
		System.out.print("(");
		exp.expEsquerda.aceitar(this);
		System.out.print(operador);
		exp.expDireita.aceitar(this);
		System.out.print(")");
	}

	public void visitarEU(ExpressaoUnaria exp){
		System.out.print("!(");
		exp.exp.aceitar(this);
		System.out.print(")");
	}

	@Override
	public void visitar(ExpressaoSoma exp) {
		visitarEB(exp, "+");
	}

	@Override
	public void visitar(ExpressaoMultiplicacao exp) {
		visitarEB(exp, "*");
	}

	@Override
	public void visitar(IfThenElse exp) {
		System.out.print("if( ");
		exp.condicao.aceitar(this);
		System.out.println(")");
		
		System.out.print("then ");
		exp.clausulaThen.aceitar(this);
		
		System.out.println("else " );
		exp.clausulaElse.aceitar(this);
	}

	@Override
	public void visitar(AplicacaoFuncao exp) {
		System.out.print(exp.nome);
		System.out.print("(");
		int i = 0;
		while(i < exp.parametros.size() - 1) {
			exp.parametros.get(i++).aceitar(this);
			System.out.print(",");
		}
		if(i == exp.parametros.size() - 1) {
			exp.parametros.get(i++).aceitar(this);
		}
		System.out.println(")");
	}

	@Override
	public void visitar(Identificador exp) {
		System.out.println(exp.id);
	}

	@Override
	public void visitar(ExpressaoDivisao exp) {
		visitarEB(exp, "/");
	}

	@Override
	public void visitar(ExpressaoSubtracao exp) {
		visitarEB(exp, "-");
	}

	@Override
	public void visitar(And exp) {
		visitarEB(exp, "&&");
	}

	@Override
	public void visitar(Or exp) {
		visitarEB(exp, "||");
	}

	@Override
	public void visitar(Igual exp) {
		visitarEB(exp, "==");
	}

	@Override
	public void visitar(MaiorQue exp) {
		visitarEB(exp, ">");
	}

	@Override
	public void visitar(MenorQue exp) {
		visitarEB(exp, "<");
	}

	@Override
	public void visitar(MenorOuIgual exp) {
		visitarEB(exp, "<=");
	}

	@Override
	public void visitar(MaiorOuIgual exp) {
		visitarEB(exp, ">=");
	}

	@Override
	public void visitar(Diferente exp) {
		visitarEB(exp, "/=");
	}

	@Override
	public void visitar(Not exp) {
		visitarEU(exp);
	}
	
	@Override
	public void visitar(ListaComValor<?> exp) {
		exp.getCabeca().aceitar(this);
		System.out.print(" ");
		exp.getCauda().aceitar(this);
	}
	
	@Override
	public void visitar(ListaVazia<?> exp) {
		System.out.print("");
	}

}
