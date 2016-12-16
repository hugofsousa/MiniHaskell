package br.unb.poo.mh;

import java.util.List;
import java.util.Stack;

public class Interpretador {

    public enum Token {
        AND, NOT, OR, DIVISAO, MULTIPLICACAO, SOMA, SUBTRACAO, IFTHENELSE, STRING, BOOLEANO, INTEIRO,
        MAIOR, MENOR, MAIORIGUAL, MENORIGUAL, DIFERENTE, IGUAL
    }

    private boolean completaExp = false;
    private Token tokenArmazenado;

    private Token operador(String exp){
        switch(exp){
            case "and": return Token.AND;
            case "not": return Token.NOT;
            case "or": return Token.OR;
            case "/": return Token.DIVISAO;
            case "*": return Token.MULTIPLICACAO;
            case "+": return Token.SOMA;
            case "-": return Token.SUBTRACAO;
            case "if": return Token.IFTHENELSE;
            case ">": return Token.MAIOR;
            case ">=": return Token.MAIORIGUAL;
            case "<": return Token.MENOR;
            case "<=": return Token.MENORIGUAL;
            case "!=": return Token.DIFERENTE;
            case "==": return Token.IGUAL;
            default:
                //Se diferente dos operadores acima, é int ou bool. Se também não for int ou bool, retorna String.
                try{
                    Integer.parseInt(exp);
                    return Token.INTEIRO;
                }
                catch(Exception i){
                    try{
                        Boolean.parseBoolean(exp);
                        return Token.BOOLEANO;
                    }
                    catch(Exception b){
                        return Token.STRING;
                    }
                }
        }
    }

    //Avalia expressões por meio dos tokens. String indica Erro.
    private Expressao avalia(Expressao e1, Expressao e2, Token t){
        switch(t){
            case SOMA: return new ExpressaoSoma(e1, e2);
            case SUBTRACAO: return new ExpressaoSubtracao(e1, e2);
            case MULTIPLICACAO: return new ExpressaoMultiplicacao(e1, e2);
            case DIVISAO: return new ExpressaoDivisao(e1, e2);
            case NOT: return new Not(e1);
            case AND: return new And(e1, e2);
            case OR: return new Or(e1, e2);
            case MAIOR: return new MaiorQue(e1, e2);
            case MENOR: return new MenorQue(e1, e2);
            case MAIORIGUAL: return new MaiorOuIgual(e1, e2);
            case MENORIGUAL: return new MenorOuIgual(e1, e2);
            case IGUAL: return new Igual(e1, e2);
            case DIFERENTE: return new Diferente(e1, e2);
            default: throw new RuntimeException();
        }
    }

    private boolean ehLogica(Token t){
        return (t == Token.AND || t == Token.OR || t == Token.NOT);
    }

    private boolean ehMatematica(Token t){
        return (t == Token.SOMA || t == Token.MULTIPLICACAO ||
                t == Token.DIVISAO || t == Token.SUBTRACAO);
    }

    private boolean ehRelacional(Token t){
        return (t == Token.DIFERENTE || t == Token.IGUAL || t == Token.MAIOR
                || t == Token.MAIORIGUAL || t == Token.MENOR || t == Token.MENORIGUAL);
    }


    public String traducao(String expressaoString){
        Stack<Expressao> stack = new Stack<>();
        Parser p = new Parser();

        //Chama o Parser para dividir a String passada. Ex: "1 + 1" vira ["1", "+", "1"].
        List<String> expressoes = p.parse(expressaoString);

        //Percorre a lista gerada acima "tokenizando" e empilhando os elementos.
        for(String elemento : expressoes){
            Token t = operador(elemento);

            if(t == Token.INTEIRO){
                stack.push(new ValorInteiro(Integer.parseInt(elemento)));
            }

            if(t == Token.BOOLEANO){
                stack.push(new ValorBooleano(Boolean.parseBoolean(elemento)));
            }

            if(!completaExp && (ehMatematica(t) || ehLogica(t) || ehRelacional(t))){
                tokenArmazenado = t;
                //Necessidade de avaliar segunda expressao
                completaExp = true;
            }

            else if(completaExp){
                Expressao e1 = stack.pop();
                Expressao e2;
                Expressao resultado;

                if(tokenArmazenado != Token.NOT){
                    e2 = stack.pop();
                    resultado = avalia(e2, e1, tokenArmazenado);
                } else{
                    resultado = avalia(e1, null, tokenArmazenado);
                }

                stack.push(resultado);
                completaExp = false;
            }
        }
        completaExp = false;

        if(stack.peek().tipo() == Tipo.Booleano){ //checa se o tipo da resposta é booleano
            Boolean bool = ((ValorParametrizado<Boolean>)stack.pop().avaliar()).getValor();
            return bool.toString();
        }
        else if(stack.peek().tipo() == Tipo.Inteiro){ //checa se o tipo da resposta é inteiro
            Integer inteiro = ((ValorParametrizado<Integer>)stack.pop().avaliar()).getValor();
            return inteiro.toString();
        }
        else{
            return "Erro de tipagem!";
        }
    }
}
