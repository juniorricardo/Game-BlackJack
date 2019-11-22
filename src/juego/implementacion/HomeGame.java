package juego.implementacion;
public class HomeGame {

    public static void main(String[] args) {

        BlackJack juego = new BlackJack();

        juego.cargarJugadores(new String[]{"Leandro", "David"});
        juego.start();

        
    }

}
