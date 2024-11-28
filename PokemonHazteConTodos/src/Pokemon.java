public class Pokemon {

    private String nombre;
    private String tipo;
    private int nivel;
    private int aguante;

// Añada los constructores********************
public Pokemon(String nombre, String tipo){
    this.nombre = nombre;
    this.tipo = tipo;
    this.nivel = 1;
    this.aguante = (int) Math.round(nivel * 2.5);
}
public Pokemon(String nombre, String tipo, int nivel) {
    this.nombre = nombre;
    this.tipo = tipo;
    this.nivel = nivel;
    this.aguante = (int) Math.round(nivel * 2.5);
    }


// ******************************************

    public int getAguante() {
        return aguante;
    }

    public void setAguante(int aguante) {
        this.aguante = aguante;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int calcularPoder(Pokemon contrincante){
        int poder = 0;
        if (nivel == 1){
            poder = ((int)(Math.random()* 8) + 3);
        } else if (nivel == 2) {
            poder = ((int) (Math.random()* 15) + 6);
        } else if (nivel == 3) {
            poder = ((int)(Math.random()* 22) + 9);
        } else if (nivel == 4) {
            poder = ((int) (Math.random()* 29) + 12);
        }
        if (tipo.equals("Agua") && contrincante.getTipo().equals("Fuego")) {
            poder *= 2 * contrincante.getNivel();
        } else if (tipo.equals("Agua") && contrincante.getTipo().equals("Tierra")) {
            poder =- 2 * contrincante.getNivel();
        } else if (tipo.equals("Fuego") && contrincante.getTipo().equals("Agua")) {
            poder =- 2 * contrincante.getNivel();
        } else if (tipo.equals("Fuego") && contrincante.getTipo().equals("Tierra")) {
            poder *= 2 * contrincante.getNivel();
        } else if (tipo.equals("Tierra") && contrincante.getTipo().equals("Agua")) {
            poder *= 2 * contrincante.getNivel();
        } else if (tipo.equals("Tierra") && contrincante.getTipo().equals("Fuego")) {
            poder =- 2 * contrincante.getNivel();
        } return poder;

    }

    public void subirNivel(){
        this.nivel++;
        this.actualizarStats();
    }

    public void actualizarStats(){
        this.aguante = (int) Math.round(nivel * 2.5);
    }

    public void disminuirAguante(){
        this.aguante--;
    }

    public String toString(){
        return "Nombre: " + this.nombre +
                "\n tipo: " + this.tipo +
                "\n nivel: " + this.nivel +
                "\n aguante " + this.aguante;
    }

}
