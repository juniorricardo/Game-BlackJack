package juego.clase;

import static java.lang.Integer.parseInt;

public class Carta {

    private final String simbolo;
    private final String valor;
    private int puntoCarta;

    public Carta(String enSimbolo, String enValor) {
        this.simbolo = enSimbolo;
        this.valor = enValor;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public String getValor() {
        return valor;
    }

    public void setPuntoCarta(int enPunto) {
        this.puntoCarta = enPunto;
    }

    public int getPuntoCarta() { return this.puntoCarta; }
}
