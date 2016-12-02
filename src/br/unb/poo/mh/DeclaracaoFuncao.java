package br.unb.poo.mh;

import java.util.List;

public class DeclaracaoFuncao {

	private String nome;
	/*
	 * Na presenca de tipos, os argumentos formais 
	 * devem ser "anotados" com os respectivos tipos. 
	 * A verificacao de tipos da aplicacao de funcoes 
	 * deve checar se os argumentos atuais (que sao expressoes) 
	 * sao bem tipados em relacao aos argumentos formais. 
	 */
	private List<ArgumentoFormal> args;
	private Expressao corpo;
	
	public DeclaracaoFuncao(String nome, List<ArgumentoFormal> args, Expressao corpo) {
		this.nome = nome;
		this.args = args;
		this.corpo = corpo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<ArgumentoFormal> getArgs() {
		return args;
	}

	public Expressao getCorpo() {
		return corpo;
	}

}
