package br.unb.poo.mh;

/**
 * Interface com a declaracao dos metodos que 
 * "visitam" aplicando alguma operacao sobre 
 * os elementos sintaticos de uma linguagem 
 * de programacao. 
 * @author rbonifacio
 *
 */
public interface Visitor {
	public abstract void visitar(ValorInteiro exp);
	public abstract void visitar(ValorBooleano exp);
	public abstract void visitar(ExpressaoSoma exp);
	public abstract void visitar(ExpressaoSubtracao exp);
	public abstract void visitar(ExpressaoDivisao exp);
	public abstract void visitar(ExpressaoMultiplicacao exp);
	public abstract void visitar(IfThenElse exp);
	public abstract void visitar(AplicacaoFuncao exp);
	public abstract void visitar(Identificador exp);
	public abstract void visitar(And exp);
	public abstract void visitar(Or exp);
	public abstract void visitar(Not exp);
	public abstract void visitar(Igual exp);
	public abstract void visitar(MaiorQue exp);
	public abstract void visitar(MenorQue exp);
	public abstract void visitar(MenorOuIgual exp);
	public abstract void visitar(MaiorOuIgual exp);
	public abstract void visitar(Diferente exp);
	public abstract void visitar(ListaComValor<?> exp);
	public abstract void visitar(ListaVazia<?> exp);
}
