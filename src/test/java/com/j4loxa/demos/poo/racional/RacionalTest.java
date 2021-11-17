package com.j4loxa.demos.poo.racional;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RacionalTest {
    public RacionalTest() {
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorTest(){
        Racional r = new Racional(3, 0);
    }

    @Test
    public void toStringTest(){
        Racional r = new Racional(1, 2);

        assertEquals("1/2 es el racional: ", r.toString(), "1/2");
    }

    @Test
    public void sumartTest() {
        Racional r = new Racional(1, 8);
        Racional r2 = new Racional(7, 8);
        Racional esperado = new Racional(1, 1);

        assertEquals("1/8 + 7/8 debería ser 1/1", r.sumar(r2), esperado);
    }
}
