package juego.clase;

import java.util.ArrayList;
import java.util.Collections;

public class Mazo {

    private final ArrayList<Carta> mazo;
    private String[] simbolos;
    private String[] valores;

    public Mazo() {
        this.mazo = new ArrayList<>(52);
    }

    public void generarMazo() {
        this.simbolos = new String[]{"♥ ", "♦ ", "♣ ", "♠ "};
        this.valores = new String[]{"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        for (String simbolo : simbolos) {
            for (String valor : valores)
                this.mazo.add(new Carta(simbolo, valor));
        }
        Collections.shuffle(mazo);
    }

    public void mostraMazo() {
        mazo.forEach(card -> System.out.print("[" + card.getSimbolo() + card.getValor() + "] "));
    }

    public Carta repartir() {
        return this.mazo.remove(this.mazo.size() - 1);
    }
    public ArrayList<Carta> getMazo(){
        return this.mazo;
    }
}
