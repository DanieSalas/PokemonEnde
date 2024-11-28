/**
 * Clase que representa un Pokémon con atributos como nombre, tipo, nivel y aguante.
 * Proporciona métodos para calcular poder, subir nivel, y actualizar estadísticas.
 */
public class Pokemon {

    /**
     * Nombre del Pokémon.
     */
    private String nombre;

    /**
     * Tipo del Pokémon (e.g., Agua, Fuego, Tierra).
     */
    private String tipo;

    /**
     * Nivel del Pokémon, usado para calcular su poder y estadísticas.
     */
    private int nivel;

    /**
     * Aguante del Pokémon, indica cuánto puede resistir en combate.
     */
    private int aguante;

    /**
     * Constructor que crea un Pokémon con un nivel inicial de 1.
     *
     * @param nombre el nombre del Pokémon.
     * @param tipo el tipo del Pokémon (e.g., Agua, Fuego, Tierra).
     */
    public Pokemon(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivel = 1;
        this.aguante = (int) Math.round(nivel * 2.5);
    }

    /**
     * Constructor que crea un Pokémon con un nivel especificado.
     *
     * @param nombre el nombre del Pokémon.
     * @param tipo el tipo del Pokémon (e.g., Agua, Fuego, Tierra).
     * @param nivel el nivel inicial del Pokémon.
     */
    public Pokemon(String nombre, String tipo, int nivel) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivel = nivel;
        this.aguante = (int) Math.round(nivel * 2.5);
    }

    /**
     * Obtiene el valor actual del aguante del Pokémon.
     *
     * @return el aguante del Pokémon.
     */
    public int getAguante() {
        return aguante;
    }

    /**
     * Establece un nuevo valor para el aguante del Pokémon.
     *
     * @param aguante el nuevo valor de aguante.
     */
    public void setAguante(int aguante) {
        this.aguante = aguante;
    }

    /**
     * Obtiene el nombre del Pokémon.
     *
     * @return el nombre del Pokémon.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el tipo del Pokémon.
     *
     * @return el tipo del Pokémon.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Obtiene el nivel actual del Pokémon.
     *
     * @return el nivel del Pokémon.
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * Establece un nuevo nivel para el Pokémon.
     *
     * @param nivel el nuevo nivel del Pokémon.
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    /**
     * Calcula el poder del Pokémon contra un contrincante.
     * El cálculo depende del nivel del Pokémon y la interacción de tipos.
     *
     * @param contrincante el Pokémon enemigo contra el que se evalúa el poder.
     * @return el poder calculado del Pokémon contra el contrincante.
     */
    public int calcularPoder(Pokemon contrincante) {
        int poder = 0;

        // Determinar poder base según el nivel
        if (nivel == 1) {
            poder = ((int) (Math.random() * 8) + 3);
        } else if (nivel == 2) {
            poder = ((int) (Math.random() * 15) + 6);
        } else if (nivel == 3) {
            poder = ((int) (Math.random() * 22) + 9);
        } else if (nivel == 4) {
            poder = ((int) (Math.random() * 29) + 12);
        }

        // Modificar poder según la interacción de tipos
        if (tipo.equals("Agua") && contrincante.getTipo().equals("Fuego")) {
            poder *= 2 * contrincante.getNivel();
        } else if (tipo.equals("Agua") && contrincante.getTipo().equals("Tierra")) {
            poder -= 2 * contrincante.getNivel();
        } else if (tipo.equals("Fuego") && contrincante.getTipo().equals("Agua")) {
            poder -= 2 * contrincante.getNivel();
        } else if (tipo.equals("Fuego") && contrincante.getTipo().equals("Tierra")) {
            poder *= 2 * contrincante.getNivel();
        } else if (tipo.equals("Tierra") && contrincante.getTipo().equals("Agua")) {
            poder *= 2 * contrincante.getNivel();
        } else if (tipo.equals("Tierra") && contrincante.getTipo().equals("Fuego")) {
            poder -= 2 * contrincante.getNivel();
        }

        return poder;
    }

    /**
     * Incrementa el nivel del Pokémon en uno y actualiza sus estadísticas.
     */
    public void subirNivel() {
        this.nivel++;
        this.actualizarStats();
    }

    /**
     * Actualiza las estadísticas del Pokémon, calculando su nuevo aguante basado en el nivel.
     */
    public void actualizarStats() {
        this.aguante = (int) Math.round(nivel * 2.5);
    }

    /**
     * Reduce el aguante del Pokémon en una unidad.
     */
    public void disminuirAguante() {
        this.aguante--;
    }

    /**
     * Devuelve una representación en cadena del Pokémon.
     *
     * @return una cadena que contiene el nombre, tipo, nivel y aguante del Pokémon.
     */
    @Override
    public String toString() {
        return "Nombre: " + this.nombre +
                "\n tipo: " + this.tipo +
                "\n nivel: " + this.nivel +
                "\n aguante " + this.aguante;
    }
}

