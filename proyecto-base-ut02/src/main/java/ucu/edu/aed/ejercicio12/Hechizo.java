package ucu.edu.aed.ejercicio12;

public class Hechizo implements Comparable<Hechizo> {
    private int id;
    private String nombre;

    /**
     * Genero hechizo para agregar al cantico.
     * @param id
     * @param nombre
     */
    public Hechizo(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    /**
     * Getter del id del hechizo y el nombre
     */
    public int getId() { return id; }
    public String getNombre() { return nombre; }

    /**
     * necesario para comparar genericos, en este caso hechizos por su ID
     * @param otro the object to be compared.
     * @return id mayor
     */
    @Override
    public int compareTo(Hechizo otro) {
        return Integer.compare(this.id, otro.id);
    }

    /**
     * Retorna una representación en texto del hechizo con su ID y nombre
     *
     */
    @Override
    public String toString() { return id + " - " + nombre; }
}