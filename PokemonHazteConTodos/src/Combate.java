public class Combate {

    Pokemon pokemonJugador;
    Pokemon pokemonRival;

    public Combate(Pokemon pokemonJugador, Pokemon pokemonRival){
        this.pokemonJugador = pokemonJugador;
        this.pokemonRival = pokemonRival;
    }


    public Pokemon Ronda(){
        int poderJugador = pokemonJugador.calcularPoder(pokemonRival);
        int poderRival = pokemonRival.calcularPoder(pokemonJugador);

        System.out.println("Poder del " + pokemonJugador.getNombre() + ": " + poderJugador);
        System.out.println("Poder del " + pokemonRival.getNombre() + ": " + poderRival);


        if (poderJugador == poderRival) {
            System.out.println("Empate");
        }
        if (poderJugador > poderRival) {
            pokemonRival.disminuirAguante();
            return pokemonJugador;
        } else {
            pokemonJugador.disminuirAguante();
            return pokemonRival;
        }
    }

    public Pokemon Ganador(){

        if (pokemonJugador.getAguante() > 0 && pokemonRival.getAguante() <= 0) {
            return pokemonJugador;
        } else if (pokemonRival.getAguante() > 0 && pokemonJugador.getAguante() <= 0) {
            return pokemonRival;
        }

        return null;
    }
    public static void main(String[] args) {

        Pokemon pikachu = new Pokemon("Pikachu", "Fuego");
        Pokemon bulbasaur = new Pokemon("Bulbasaur", "Agua", 2);


        Combate combate = new Combate(pikachu, bulbasaur);


        while (combate.Ganador() == null) {
            System.out.println("Comienza una nueva ronda...");
            Pokemon ganadorRonda = combate.Ronda();
            if (ganadorRonda != null) {
                System.out.println("El ganador de esta ronda es: " + ganadorRonda.getNombre());
            } else {
                System.out.println("¡Empate en esta ronda!");
            }


            System.out.println(pikachu);
            System.out.println(bulbasaur);
        }


        Pokemon ganador = combate.Ganador();
        if (ganador != null) {
            System.out.println("El ganador del combate es: " + ganador.getNombre());
        }
    }


}
