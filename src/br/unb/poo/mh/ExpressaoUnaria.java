package br.unb.poo.mh;

/**
 * Created by Eduardo & Hugo on 01/12/16.
 */

public abstract class ExpressaoUnaria implements Expressao {

    protected Expressao exp;

    public ExpressaoUnaria(Expressao exp) {
        this.exp = exp;
    }

}
