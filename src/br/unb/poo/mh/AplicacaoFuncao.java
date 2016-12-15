package br.unb.poo.mh;

import java.util.ArrayList;
import java.util.List;

/**
 * Corresponde a uma expressao do tipo 
 * aplicacao de funcao. 
 * 
 * @author rbonifacio
 */
public class AplicacaoFuncao implements Expressao {
	
	String nome;
	List<Expressao> parametros;

	public AplicacaoFuncao(){
		parametros = new ArrayList<Expressao>();
	}

	public AplicacaoFuncao(String nome, List<Expressao> parametros) {
		this.nome = nome;
		this.parametros = parametros;
	}

	@Override
	public Valor avaliar() {
		DeclaracaoFuncao dec = Ambiente.instance().
				getDeclaracaoFuncao(nome, parametros.size());

		Ambiente.instance().empilha();

		for(int i = 0; i < dec.getArgs().size(); i++) {
			ArgumentoFormal arg = dec.getArgs().get(i);
			Expressao pmt = parametros.get(i);

			Ambiente.instance().associaExpressao(arg.getId(), pmt);
		}
		Valor res = dec.getCorpo().avaliar();
		Ambiente.instance().desempilha();

		return res;
	}

	@Override
	public Tipo tipo() {
		DeclaracaoFuncao funcao = Ambiente.instance().getDeclaracaoFuncao(nome, parametros.size());
		ArgumentoFormal argumento;

		for (Expressao e : parametros){
			//Pega o argumento correspondente a ordem da lista de parametros
			argumento = funcao.getArgs().get(parametros.indexOf(e));

			//Se o tipo da expressao nao for igual ao do argumento declarado
			if(!e.tipo().equals(argumento.getTipo())){
				System.out.println("Erro! Argumento " + argumento.getId() + " esperava tipo "
						+ argumento.getTipo() + " mas eh tipo " + e.tipo());
				return Tipo.Error;
			}
		}

		return Tipo.Funcao;
	}

	@Override
	public boolean checarTipo() {
		return tipo().equals(Tipo.Funcao);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Expressao> getParametros() {
		return parametros;
	}

	public void setParametro (Expressao parametro){
		this.parametros.add(parametro);
	}

	public void resetParametro(Expressao parametro){
		this.parametros.set(0, parametro);
	}

	@Override
	public void aceitar(Visitor v) {
		v.visitar(this);
		
	}
	
	
	

}
