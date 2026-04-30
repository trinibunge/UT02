package ucu.edu.aed.ejercicio13;


public class Nave implements Comparable<Nave> {

    private int codigo;
    private String clase;
    private double combustible;

    public Nave(int codigo, String clase, double combustible) {
        this.codigo = codigo;
        this.clase = clase;
        this.combustible = combustible;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getClase() {
        return clase;
    }

    public double getCombustible() {
        return combustible;
    }

    // El AVL ordena por código (clave natural)
    @Override
    public int compareTo(Nave otra) {
        return Integer.compare(this.codigo, otra.codigo);
    }

}