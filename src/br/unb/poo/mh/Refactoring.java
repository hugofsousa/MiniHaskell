package br.unb.poo.mh;

public class Refactoring implements Visitor{

    private Expressao resultado;

    public Expressao getResultado(){
        return resultado;
    }

    @Override
    public void visitar(ExpressaoSoma expressao) {
        resultado = expressao;

        if(expressao.expEsquerda instanceof ValorInteiro &&
                expressao.expDireita instanceof ValorInteiro){

            int expEsquerda = ((ValorInteiro)expressao.expEsquerda).getValor();
            int expDireita = ((ValorInteiro)expressao.expDireita).getValor();

            if(expDireita == 0){
                resultado = expressao.expEsquerda;
            }
            else if(expEsquerda == 0){
                resultado = expressao.expDireita;
            }
        }
    }

    @Override
    public void visitar(ExpressaoMultiplicacao expressao) {
        resultado = expressao;

        if(expressao.expEsquerda instanceof ValorInteiro &&
                expressao.expDireita instanceof ValorInteiro){

            int expEsquerda = ((ValorInteiro)expressao.expEsquerda).getValor();
            int expDireita = ((ValorInteiro)expressao.expDireita).getValor();

            if(expDireita == 1){
                resultado = expressao.expEsquerda;
            }
            else if(expDireita == 0){
                resultado = new ValorInteiro(0);
            }
            else if(expEsquerda == 0){
                resultado = new ValorInteiro(0);
            }
            else if(expEsquerda == 1){
                resultado = expressao.expDireita;
            }

        }
    }

    @Override
    public void visitar(ExpressaoDivisao expressao) {
        resultado = expressao;

        if(expressao.expEsquerda instanceof ValorInteiro &&
                expressao.expDireita instanceof ValorInteiro){

            int expDireita = ((ValorInteiro)expressao.expDireita).getValor();

            if(expDireita == 1){
                resultado = expressao.expEsquerda;
            }
        }
    }

    @Override
    public void visitar(IfThenElse expressao) {
        resultado = expressao;

        if(expressao.clausulaThen instanceof ValorBooleano &&
                expressao.clausulaElse instanceof ValorBooleano){

            boolean clausulaThen = ((ValorBooleano)expressao.clausulaThen).getValor();
            boolean clausulaElse = ((ValorBooleano)expressao.clausulaElse).getValor();

            if(clausulaThen && !clausulaElse){
                resultado = expressao.condicao;
            }
        }

    }

    @Override
    public void visitar(ExpressaoSubtracao expressao) {
        resultado = expressao;

        if(expressao.expEsquerda instanceof ValorInteiro &&
                expressao.expDireita instanceof ValorInteiro){

            int expDireita = ((ValorInteiro)expressao.expDireita).getValor();

            if(expDireita == 0){
                resultado = expressao.expEsquerda;
            }
        }
    }

    @Override
    public void visitar(And expressao) {
        resultado = expressao;

        if(expressao.expEsquerda instanceof ValorBooleano &&
                expressao.expDireita instanceof ValorBooleano){

            boolean expEsquerda = ((ValorBooleano)expressao.expEsquerda).getValor();
            boolean expDireita = ((ValorBooleano)expressao.expDireita).getValor();


            if(!expEsquerda && !expDireita){
                ValorBooleano deMorgan = (ValorBooleano)(new Or(expressao.expEsquerda, expressao.expDireita)).avaliar();
                resultado = new Not(deMorgan);
            }

        }
    }

    @Override
    public void visitar(Not expressao) {}

    @Override
    public void visitar(Or expressao) {
        resultado = expressao;

        if(expressao.expEsquerda instanceof ValorBooleano &&
                expressao.expDireita instanceof ValorBooleano){

            boolean expEsquerda = ((ValorBooleano)expressao.expEsquerda).getValor();
            boolean expDireita = ((ValorBooleano)expressao.expDireita).getValor();

            if(!expEsquerda && !expDireita){
                ValorBooleano deMorgan = (ValorBooleano)(new And(expressao.expEsquerda, expressao.expDireita)).avaliar();
                resultado = new Not(deMorgan);
            }

        }

    }

    @Override
    public void visitar(Diferente expressao) {}


    @Override
    public void visitar(MaiorQue expressao) {}

    @Override
    public void visitar(Identificador expressao) {}

    @Override
    public void visitar(Igual expressao) {}

    @Override
    public void visitar(MaiorOuIgual expressao) {}

    @Override
    public void visitar(MenorQue expressao) {}

    @Override
    public void visitar(MenorOuIgual expressao) {}

    @Override
    public void visitar(AplicacaoFuncao expressao) {}

    @Override
    public void visitar(ValorBooleano expressao) {}

    @Override
    public void visitar(ValorInteiro expressao) {}

//    @Override
//    public void visitar(ListaVazia<?> expressao) {}
//
//    @Override
//    public void visitar(ListaNaoVazia<?> expressao) {}
//
    @Override
    public void visitar(ListaComValor exp) {
    }

}
