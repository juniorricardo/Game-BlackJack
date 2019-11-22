package juego.clase;

import java.util.ArrayList;
import java.util.Arrays;

public class Jugador {

	private final String nombre;
	private ArrayList<Carta> cartasMano;
	private int puntos;

	public Jugador(String enNombre) {
		this.nombre= enNombre;
		this.puntos = 0;
		this.cartasMano = new ArrayList<>();
	}
//	public void primeraMano(Carta[] primeraMano) {
//		this.cartasMano = new ArrayList<>(Arrays.asList(primeraMano));
//	}

//	public int sumarCartas() {
//		puntos = 0;
//		for (Carta unaCarta : cartasMano)
//			puntos += unaCarta.getPuntoCarta();
//		return puntos;
//	}

	public void pedirCarta(Carta enCarta) {
		cartasMano.add(enCarta);
		puntos += enCarta.getPuntoCarta();
	}

	public void mostrarCartas() {
		cartasMano.forEach(card -> System.out.print("["+card.getSimbolo() + card.getValor() + "] "));
	}

	public int getPuntos() {
		return this.puntos;
	}

	public ArrayList<Carta> getCartasMano() {
		return this.cartasMano;
	}

	public String getNombre() {
		return this.nombre;
	}
	
}
