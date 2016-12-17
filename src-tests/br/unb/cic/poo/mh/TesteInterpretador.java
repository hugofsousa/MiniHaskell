package br.unb.cic.poo.mh;

import br.unb.poo.mh.Interpretador;
import org.junit.Assert;
import org.junit.Test;

public class TesteInterpretador {

    @Test
    public void testeSimples(){
        Interpretador interpreter = new Interpretador();

        Assert.assertEquals("false", interpreter.traducao("false and false"));
        Assert.assertEquals("true", interpreter.traducao("true or false"));
        Assert.assertEquals("true", interpreter.traducao("not false"));
        Assert.assertEquals("false", interpreter.traducao("true && false"));
        Assert.assertEquals("false", interpreter.traducao("false || false"));
        Assert.assertEquals("false", interpreter.traducao("not true"));
        Assert.assertEquals("false", interpreter.traducao("2 > 11"));
        Assert.assertEquals("true", interpreter.traducao("2 >= 1"));
        Assert.assertEquals("false", interpreter.traducao("2 == 1"));
        Assert.assertEquals("true", interpreter.traducao("2 != 1"));
        Assert.assertEquals("false", interpreter.traducao("2 < 1"));
        Assert.assertEquals("true", interpreter.traducao("1 <= 1"));
        Assert.assertEquals("10", interpreter.traducao("9 + 1"));
        Assert.assertEquals("2", interpreter.traducao("1 * 2"));
        Assert.assertEquals("7", interpreter.traducao("14 / 2"));
        Assert.assertEquals("8", interpreter.traducao("13 - 5"));
    }




}
