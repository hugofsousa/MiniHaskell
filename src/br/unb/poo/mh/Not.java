package br.unb.poo.mh;

/**
 * Created by Hugo & Eduardo on 01/12/16.
 */

public class Not extends ExpressaoUnaria {
    public Not(Expressao exp){super(exp);}

    @Override
    public Valor avaliar() {
        ValorBooleano valor = (ValorBooleano) exp.avaliar();

        return new ValorBooleano(!valor.getValor());
    }

    @Override
    public Tipo tipo() {
        return (exp.tipo() == Tipo.Booleano) ? Tipo.Booleano : Tipo.Error;
    }

    @Override
    public void aceitar(Visitor v) {
        v.visitar(this);
    }
}