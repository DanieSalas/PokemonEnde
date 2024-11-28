/**
 * Clase principal para iniciar la aplicación Pokémon.
 * Encargada de crear la interfaz del juego y ejecutar el flujo principal.
 */
public class AppPokemon {

    /**
     * Método principal de la aplicación.
     * Inicializa la interfaz del juego Pokémon y comienza el juego.
     *
     * @param args argumentos de la línea de comandos (no utilizados en este programa).
     */
    public static void main(String[] args) {
        // Crear una instancia de la interfaz del juego
        InterfazPokemon juegoPokemon = new InterfazPokemon();

        // Iniciar el flujo del juego
        juegoPokemon.Juego();
    }
}
