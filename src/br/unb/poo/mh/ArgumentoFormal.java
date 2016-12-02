package br.unb.poo.mh;

import br.unb.poo.mh.Tipo;

public class ArgumentoFormal {
    private String id;
    private Tipo tipo;

    public ArgumentoFormal(String id, Tipo tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }
    public Tipo getTipo() {
        return tipo;
    }
}
