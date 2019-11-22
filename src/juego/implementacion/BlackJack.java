package juego.implementacion;

import juego.clase.Carta;
import juego.clase.Jugador;
import juego.clase.Mazo;

import java.util.Scanner;

//Master
public class BlackJack {

    private Jugador[] jugadores;
    private Mazo mazoJuego;
    private final Scanner lector;
    private boolean finPartida;

    public BlackJack() {
        this.mazoJuego = new Mazo();
        this.mazoJuego.generarMazo();
        cargarPuntoCartas();

        finPartida = false;
        lector = new Scanner(System.in);
    }

    private void cargarPuntoCartas() {
        for (Carta unaCarta : mazoJuego.getMazo()) {
            switch (unaCarta.getValor()) {
                case "J":
                case "Q":
                case "K":
                    unaCarta.setPuntoCarta(10);
                    break;
                case "A":
                    unaCarta.setPuntoCarta(1);
                    break;
                default:
                    unaCarta.setPuntoCarta(Integer.valueOf(unaCarta.getValor()));
                    break;
            }
        }
    }

    public void cargarJugadores(String[] nombreJugadores) {
        this.jugadores = new Jugador[nombreJugadores.length];
        for (int instancia = 0; instancia < jugadores.length; instancia++)
            jugadores[instancia] = new Jugador(nombreJugadores[instancia]);
    }


    public void start() {
        while (!finPartida) {
            for (Jugador jugador : jugadores) {
                System.out.println(jugador.getNombre() + " esta jugando!");
                do {
                    if (jugador.getPuntos() == 0) {
                        jugador.pedirCarta(mazoJuego.repartir());
                        iniciarMovimientos(jugador);
                    } else
                        iniciarMovimientos(jugador);
                } while (repetirProceso());
            }
        }

        quienGano();

    }

    private void iniciarMovimientos(Jugador enJugador) {
        enJugador.pedirCarta(mazoJuego.repartir());
        enJugador.mostrarCartas();
        for (Carta carta : enJugador.getCartasMano()) {
            if (carta.getValor().equals("A")) {
                System.out.println("Usted tiene un AS, que valor desea darle? (1/11)");
                carta.setPuntoCarta(lector.nextInt());
            }
        }
        System.out.println("Tus puntos son: " + enJugador.getPuntos());
        if (enJugador.getPuntos() > 21) {
            System.out.println(enJugador.getNombre() + " has perdido, estos son tus puntos: " + enJugador.getPuntos());
        }
    }


    private void quienGano() {
        int ganador = 0;
        int minimo = 21;
        for (int i = 0; i < jugadores.length; i++) {
            if ((21 - jugadores[i].getPuntos() < minimo) && (jugadores[i].getPuntos() <= 21)) {
                ganador = i;
                minimo = 21 - jugadores[i].getPuntos();
            } else if (jugadores[i].getPuntos() > 21) {
                ganador = ganador + 1;
            }
        }
        System.out.println("Ganó el jugador: " + jugadores[ganador].getNombre());

    }

    private void validarAS(Jugador jugador) {
        for (Carta carta : jugador.getCartasMano()) {
            if (carta.getValor().equals("A")) {
                System.out.println("Usted tiene un AS, que valor desea darle? (1/11)");
                carta.setPuntoCarta(lector.nextInt());
            }
        }
    }

    private boolean repetirProceso() {
        System.out.println("Desea una carta mas? (s/n)");
        return lector.nextLine().equals("s");
    }

}
