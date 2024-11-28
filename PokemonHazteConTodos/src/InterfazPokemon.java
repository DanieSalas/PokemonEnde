import java.util.Scanner;

public class InterfazPokemon {

    private Scanner teclado;

    public InterfazPokemon() {
        teclado = new Scanner(System.in);
    }


    public void Juego() {
        System.out.println("Bienvenido al Juego Pokémon");


        Pokemon jugadorPokemon = menuCreacionPokemonJugador();


        for (int i = 1; i <= 3; i++) {
            System.out.println("\n--- Combate contra rival " + i + " ---");


            Pokemon rivalPokemon = siguientePokemonRival(i);


            Pokemon ganador = Partida(jugadorPokemon, rivalPokemon);


            if (ganador == jugadorPokemon) {
                jugadorPokemon.subirNivel();
                System.out.println("¡Has ganado esta partida! Tu Pokémon sube de nivel.");
            } else {
                mostrarFinPartida();
                return;
            }
        }

        mostrarJuegoSuperado();
    }


    private Pokemon Partida(Pokemon pokemonJugador, Pokemon pokemonRival) {
        Combate combate = new Combate(pokemonJugador, pokemonRival);
        Pokemon ganador = null;


        while (ganador == null) {
            ganador = combate.Ronda();
            System.out.println("Estado de los Pokémon:");
            System.out.println(pokemonJugador);
            System.out.println(pokemonRival);
        }


        return ganador;
    }


    private Pokemon menuCreacionPokemonJugador() {
        System.out.print("Introduce el nombre de tu Pokémon: ");
        String nombre = teclado.nextLine();

        String tipo;
        do {
            System.out.print("Introduce el tipo de tu Pokémon (agua, fuego, tierra): ");
            tipo = teclado.nextLine().toLowerCase();
        } while (!tipo.equals("agua") && !tipo.equals("fuego") && !tipo.equals("tierra"));


        int nivel = 1;


        return new Pokemon(nombre, tipo, nivel);
    }


    public Pokemon siguientePokemonRival(int numero) {
        Pokemon rival = null;

        switch (numero) {
            case 1:
                rival = new Pokemon("Caterpie", "tierra", 1);
                break;
            case 2:
                rival = new Pokemon("Bulbasaur", "agua", 2);
                break;
            case 3:
                rival = new Pokemon("Charmander", "fuego", 3);
                break;
        }

        return rival;
    }


    private void mostrarJuegoSuperado() {
        System.out.println("++++++++++ ENHORABUENA +++++++++++");
        System.out.println("+++++ HAS SUPERADO EL JUEGO ++++++");
        System.out.println("++++ ERES UN MAESTRO POKEMON +++++");
    }


    private void mostrarFinPartida() {
        System.out.println("++++++++++ LO SIENTO +++++++++++");
        System.out.println("+++++ HAS SIDO ELIMINADO ++++++");
        System.out.println("+++++ VUELVE A INTENTARLO +++++");
    }


    public static void main(String[] args) {
        InterfazPokemon interfaz = new InterfazPokemon();
        interfaz.Juego();
    }
}
