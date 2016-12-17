package br.unb.cic.poo.mh;


import br.unb.poo.mh.*;
import org.junit.Assert;
import org.junit.Test;

public class TesteRefactoring {

    @Test
    public void testeRefactoringMatematica() {
        ValorInteiro v0 = new ValorInteiro(0);
        ValorInteiro v1 = new ValorInteiro(1);
        ValorInteiro v2 = new ValorInteiro(2);

        Expressao soma1 = new ExpressaoSoma(v1, v0);
        Expressao soma2 = new ExpressaoSoma(v0, v1);
        Refactoring Rsoma1 = new Refactoring();
        Refactoring Rsoma2 = new Refactoring();
        soma1.aceitar(Rsoma1);
        Assert.assertEquals(v1, Rsoma1.getResultado());
        soma2.aceitar(Rsoma2);
        Assert.assertEquals(v1, Rsoma2.getResultado());

        Expressao subtracao1 = new ExpressaoSubtracao(v1, v0);
        Expressao subtracao2 = new ExpressaoSubtracao(v2, v0);
        Refactoring Rsubtracao1 = new Refactoring();
        Refactoring Rsubtracao2 = new Refactoring();
        subtracao1.aceitar(Rsubtracao1);
        Assert.assertEquals(v1, Rsubtracao1.getResultado());
        subtracao2.aceitar(Rsubtracao2);
        Assert.assertEquals(v2, Rsubtracao2.getResultado());

        Expressao multiplicacao1 = new ExpressaoMultiplicacao(v2, v0);
        Expressao multiplicacao2 = new ExpressaoMultiplicacao(v2, v1);
        Expressao multiplicacao3 = new ExpressaoMultiplicacao(v1, v2);
        Expressao multiplicacao4 = new ExpressaoMultiplicacao(v0, v2);
        Refactoring Rmultiplicacao1 = new Refactoring();
        Refactoring Rmultiplicacao2 = new Refactoring();
        Refactoring Rmultiplicacao3 = new Refactoring();
        Refactoring Rmultiplicacao4 = new Refactoring();

        multiplicacao1.aceitar(Rmultiplicacao1);
        Assert.assertEquals(v0, Rmultiplicacao1.getResultado());
        multiplicacao2.aceitar(Rmultiplicacao2);
        Assert.assertEquals(v2, Rmultiplicacao2.getResultado());
        multiplicacao3.aceitar(Rmultiplicacao3);
        Assert.assertEquals(v2, Rmultiplicacao3.getResultado());
        multiplicacao4.aceitar(Rmultiplicacao4);
        Assert.assertEquals(v0, Rmultiplicacao4.getResultado());

        Refactoring Rdivisao1 = new Refactoring();
        Refactoring Rdivisao2 = new Refactoring();
        Expressao divisao1 = new ExpressaoDivisao(v0, v1);
        divisao1.aceitar(Rdivisao1);
        Assert.assertEquals(v0, Rdivisao1.getResultado());
        Expressao divisao2 = new ExpressaoDivisao(v2, v1);
        divisao2.aceitar(Rdivisao2);
        Assert.assertEquals(v2, Rdivisao2.getResultado());
    }

    @Test
    public void testeRefactoringAnd() {
        ValorBooleano f = new ValorBooleano(false);
        ValorBooleano v = new ValorBooleano(true);
        Expressao not1 = new Not(f);
        Expressao not2 = new Not(f);
        Expressao not3 = new Not(v);
        Expressao not4 = new Not(v);
        Expressao and1 = new And(not1, not2);
        Expressao and2 = new And(not3, not4);
        Expressao and3 = new And(not1, not3);
        Expressao and4 = new And(not3, not1);

        Refactoring R1 = new Refactoring();
        Refactoring R2 = new Refactoring();
        Refactoring R3 = new Refactoring();
        Refactoring R4 = new Refactoring();

        and1.aceitar(R1);
        Assert.assertEquals(v, R1.getResultado().avaliar());

        and2.aceitar(R2);
        Assert.assertEquals(f, R2.getResultado().avaliar());

        and3.aceitar(R3);
        Assert.assertEquals(f, R3.getResultado().avaliar());

        and4.aceitar(R4);
        Assert.assertEquals(f, R4.getResultado().avaliar());
    }

    @Test
    public void testeRefactoringOr() {
        ValorBooleano f = new ValorBooleano(false);
        ValorBooleano v = new ValorBooleano(true);
        Expressao not1 = new Not(f);
        Expressao not2 = new Not(f);
        Expressao not3 = new Not(v);
        Expressao not4 = new Not(v);
        Expressao or1 = new Or(not1, not2);
        Expressao or2 = new Or(not1, not3);
        Expressao or3 = new Or(not3, not1);
        Expressao or4 = new Or(not3, not4);

        Refactoring R1 = new Refactoring();
        Refactoring R2 = new Refactoring();
        Refactoring R3 = new Refactoring();
        Refactoring R4 = new Refactoring();

        or1.aceitar(R1);
        Assert.assertEquals(v, R1.getResultado().avaliar());

        or2.aceitar(R2);
        Assert.assertEquals(v, R2.getResultado().avaliar());

        or3.aceitar(R3);
        Assert.assertEquals(v, R1.getResultado().avaliar());

        or4.aceitar(R4);
        Assert.assertEquals(v, R1.getResultado().avaliar());
    }
}
