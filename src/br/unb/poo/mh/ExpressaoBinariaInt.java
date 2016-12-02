package br.unb.poo.mh;

import br.unb.poo.mh.*;

public abstract class ExpressaoBinariaInt extends ExpressaoBinaria {

    public ExpressaoBinariaInt(Expressao expDireita, Expressao expEsquerda) {
        super(expDireita, expEsquerda);
    }

    @Override
    public Tipo tipo() {
        Tipo t1 = expDireita.tipo();
        Tipo t2 = expEsquerda.tipo();

        if(t1.equals(Tipo.Inteiro) && t2.equals(Tipo.Inteiro)) {
            return Tipo.Inteiro;
        }
        return Tipo.Error;
    }

    @Override
    public boolean checarTipo() {
        return tipo().equals(Tipo.Inteiro);
    }

}