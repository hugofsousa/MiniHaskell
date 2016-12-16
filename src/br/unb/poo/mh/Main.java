package br.unb.poo.mh;

import java.util.Scanner;

public class Main {

    public static void main(String args[]){
        String entrada = "";
        Interpretador interpretador = new Interpretador();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Para sair, escreva 'quit'");


        System.out.print("> ");
        entrada = scanner.nextLine();

        while(!entrada.equals("quit") && !entrada.equals("Quit")){
            try{
                try{
                    String operacao;
                    operacao = interpretador.traducao(entrada);
                    System.out.println("RESULTADO = " + operacao);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
            catch(RuntimeException re){
                RuntimeException erro = new RuntimeException("Erro de Sintaxe");
                System.out.println(erro.getMessage());
            }
            System.out.print("> ");
            entrada = scanner.nextLine();
        }

        scanner.close();
    }

}
