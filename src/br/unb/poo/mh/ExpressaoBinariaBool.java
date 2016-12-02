package br.unb.poo.mh;

import br.unb.poo.mh.Expressao;
import br.unb.poo.mh.ExpressaoBinaria;
import br.unb.poo.mh.Tipo;

public abstract class ExpressaoBinariaBool extends ExpressaoBinaria{

    public ExpressaoBinariaBool(Expressao expDireita, Expressao expEsquerda) {
        super(expDireita, expEsquerda);
    }

    @Override
    public Tipo tipo() {
        Tipo t1 = expDireita.tipo();
        Tipo t2 = expEsquerda.tipo();

        if(t1.equals(Tipo.Booleano) && t2.equals(Tipo.Booleano)) {
            return Tipo.Booleano;
        }
        return Tipo.Error;
    }

    @Override
    public boolean checarTipo() {
        return tipo().equals(Tipo.Booleano);
    }

}
