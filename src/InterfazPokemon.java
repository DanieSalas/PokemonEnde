import java.util.Scanner;

/**
 * Clase que representa la interfaz principal del juego Pokémon.
 */
public class InterfazPokemon {

    /**
     * Scanner utilizado para leer entradas del usuario.
     */
    private Scanner teclado;

    /**
     * Constructor de la clase InterfazPokemon.
     * Inicializa el objeto Scanner.
     */
    public InterfazPokemon() {
        teclado = new Scanner(System.in);
    }

    /**
     * Método principal que ejecuta el flujo del juego Pokémon.
     */
    public void Juego() {
        System.out.println("Bienvenido al Juego Pokémon");

        // Crear el Pokémon del jugador
        Pokemon jugadorPokemon = menuCreacionPokemonJugador();

        // Simular combates con rivales
        for (int i = 1; i <= 3; i++) {
            System.out.println("\n--- Combate contra rival " + i + " ---");

            // Obtener el siguiente Pokémon rival
            Pokemon rivalPokemon = siguientePokemonRival(i);

            // Ejecutar la partida
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

    /**
     * Ejecuta una partida entre el Pokémon del jugador y un Pokémon rival.
     *
     * @param pokemonJugador el Pokémon del jugador.
     * @param pokemonRival el Pokémon rival.
     * @return el Pokémon ganador de la partida.
     */
    private Pokemon Partida(Pokemon pokemonJugador, Pokemon pokemonRival) {
        Combate combate = new Combate(pokemonJugador, pokemonRival);
        Pokemon ganador = null;

        // Ejecutar rondas hasta que haya un ganador
        while (ganador == null) {
            ganador = combate.Ronda();
            System.out.println("Estado de los Pokémon:");
            System.out.println(pokemonJugador);
            System.out.println(pokemonRival);
        }

        return ganador;
    }

    /**
     * Muestra el menú para que el jugador cree su Pokémon inicial.
     *
     * @return el Pokémon creado por el jugador.
     */
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

    /**
     * Obtiene el Pokémon rival correspondiente al número del combate.
     *
     * @param numero el número del combate (1, 2 o 3).
     * @return el Pokémon rival correspondiente.
     */
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

    /**
     * Muestra un mensaje indicando que el jugador ha superado el juego.
     */
    private void mostrarJuegoSuperado() {
        System.out.println("++++++++++ ENHORABUENA +++++++++++");
        System.out.println("+++++ HAS SUPERADO EL JUEGO ++++++");
        System.out.println("++++ ERES UN MAESTRO POKEMON +++++");
    }

    /**
     * Muestra un mensaje indicando que el jugador ha perdido.
     */
    private void mostrarFinPartida() {
        System.out.println("++++++++++ LO SIENTO +++++++++++");
        System.out.println("+++++ HAS SIDO ELIMINADO ++++++");
        System.out.println("+++++ VUELVE A INTENTARLO +++++");
    }

    /**
     * Método principal para ejecutar el programa.
     *
     * @param args argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        InterfazPokemon interfaz = new InterfazPokemon();
        interfaz.Juego();
    }
}
