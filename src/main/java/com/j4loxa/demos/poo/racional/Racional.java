package com.j4loxa.demos.poo.racional;

public class Racional {
    private int numerador;
    private int denominador;

    public Racional() {
    }

    public Racional(int numerador, int denominador) {
        int mcd = mcd(numerador, denominador);
        this.numerador = numerador / mcd;
        setDenominador(denominador / mcd);
    }

    public boolean esMenorQue(Racional otro) {
        return numerador * otro.getDenominador() < otro.getNumerador() * denominador;
    }

    public Racional obtenerMayor(Racional otro) {
        if (this.esMenorQue(otro)) {
            return otro;
        } else {
            return this;
        }
    }

    public Racional sumar(Racional otro) {
        return new Racional(numerador * otro.getDenominador() + otro.getNumerador() * denominador,
                denominador * otro.getDenominador());
    }

    private Racional negar() {
        return new Racional(-1 * numerador, denominador);
    }

    public Racional restar(Racional otro) {
        return sumar(otro.negar());
    }

    private int mcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return mcd(b, a % b);
        }
    }

    @Override
    public String toString() {
        return numerador + "/" + denominador;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        Racional otro = (Racional) obj;

        return numerador * otro.getDenominador() == denominador * otro.getNumerador();
    }

    public int compareTo(Racional otro) {
        if (this.equals(otro)) {
            return 0;
        }

        if (this.esMenorQue(otro)) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.numerador;
        hash = 29 * hash + this.denominador;
        return hash;
    }

    /**
     * @return the numerador
     */
    public int getNumerador() {
        return numerador;
    }

    /**
     * @param numerador the numerador to set
     */
    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    /**
     * @return the denominador
     */
    public int getDenominador() {
        return denominador;
    }

    /**
     * @param denominador the denominador to set
     */
    public final void setDenominador(int denominador) {
        if (denominador != 0) {
            this.denominador = denominador;
        } else {
            throw new IllegalArgumentException("El denominador no puede ser 0");
        }
    }
}
