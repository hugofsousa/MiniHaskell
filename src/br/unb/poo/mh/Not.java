package br.unb.poo.mh;

public class Not extends ExpressaoUnaria {
    public Not(Expressao exp){super(exp);}

    @Override
    public Valor avaliar() {
        ValorBooleano valor = (ValorBooleano) exp.avaliar();

        return new ValorBooleano(!valor.getValor());
    }

    @Override
    public boolean checarTipo() {
        return tipo().equals(Tipo.Booleano);
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