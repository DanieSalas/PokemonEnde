/**
 * Clase que representa un combate entre dos Pokémon.
 */
public class Combate {

    /**
     * Pokémon del jugador.
     */
    Pokemon pokemonJugador;

    /**
     * Pokémon del rival.
     */
    Pokemon pokemonRival;

    /**
     * Constructor de la clase Combate.
     *
     * @param pokemonJugador el Pokémon del jugador.
     * @param pokemonRival el Pokémon del rival.
     */
    public Combate(Pokemon pokemonJugador, Pokemon pokemonRival) {
        this.pokemonJugador = pokemonJugador;
        this.pokemonRival = pokemonRival;
    }

    /**
     * Ejecuta una ronda del combate y determina el ganador de la misma.
     *
     * @return el Pokémon ganador de la ronda, o {@code null} si hay empate.
     */
    public Pokemon Ronda() {
        int poderJugador = pokemonJugador.calcularPoder(pokemonRival);
        int poderRival = pokemonRival.calcularPoder(pokemonJugador);

        System.out.println("Poder del " + pokemonJugador.getNombre() + ": " + poderJugador);
        System.out.println("Poder del " + pokemonRival.getNombre() + ": " + poderRival);

        // Determinar el resultado de la ronda
        if (poderJugador == poderRival) {
            System.out.println("Empate");
            return null; // Empate
        }
        if (poderJugador > poderRival) {
            pokemonRival.disminuirAguante();
            return pokemonJugador;
        } else {
            pokemonJugador.disminuirAguante();
            return pokemonRival;
        }
    }

    /**
     * Determina el ganador del combate basado en el estado actual de los Pokémon.
     *
     * @return el Pokémon ganador del combate, o {@code null} si no hay un ganador todavía.
     */
    public Pokemon Ganador() {
        if (pokemonJugador.getAguante() > 0 && pokemonRival.getAguante() <= 0) {
            return pokemonJugador;
        } else if (pokemonRival.getAguante() > 0 && pokemonJugador.getAguante() <= 0) {
            return pokemonRival;
        }
        return null; // El combate aún no tiene ganador
    }

    /**
     * Método principal para probar la clase Combate.
     *
     * @param args argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        // Crear Pokémon para el combate
        Pokemon pikachu = new Pokemon("Pikachu", "Fuego");
        Pokemon bulbasaur = new Pokemon("Bulbasaur", "Agua", 2);

        // Crear un nuevo combate
        Combate combate = new Combate(pikachu, bulbasaur);

        // Ciclo para ejecutar rondas hasta que haya un ganador
        while (combate.Ganador() == null) {
            System.out.println("Comienza una nueva ronda...");
            Pokemon ganadorRonda = combate.Ronda();
            if (ganadorRonda != null) {
                System.out.println("El ganador de esta ronda es: " + ganadorRonda.getNombre());
            } else {
                System.out.println("¡Empate en esta ronda!");
            }

            // Mostrar el estado de los Pokémon
            System.out.println(pikachu);
            System.out.println(bulbasaur);
        }

        // Anunciar el ganador del combate
        Pokemon ganador = combate.Ganador();
        if (ganador != null) {
            System.out.println("El ganador del combate es: " + ganador.getNombre());
        }
    }
}

