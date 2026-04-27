package ucu.edu.aed.ejercicio12;
import ucu.edu.aed.impl.ArbolBinario;

import java.util.LinkedList;

public class Grimorio {
    private ArbolBinario<Hechizo> arbol;

    public Grimorio() {
        this.arbol = new ArbolBinario<>();
    }

    /**
     * agrega hechizos a un grimorio
     *
     */
    public void agregarHechizos(int id, String nombre) {
        arbol.insertar(new Hechizo(id, nombre));
    }

    /**
     * Lista los ids de todos los hechizos del grimorio de un mago
     * @return los ids del grimorio ordenados en preorden
     */
    public String idsHechizos() {
        LinkedList<String> ids = new LinkedList<>();
        arbol.preOrder(hechizo -> ids.add(String.valueOf(hechizo.getId())));
        return String.join(", ", ids);
    }

    /**
     * Los hechizos prohibidos son aquellos cuyo ID es impar, el metodo
     * filtra a esos hechizos recorriendo el arbol 'preorden' y los añade a una lista
     * @return Lista con hechizos cuyo id es impar ordenados en preOrden
     */
    public LinkedList<Integer> hechizosProhibidos() {
        LinkedList<Integer> prohibidos = new LinkedList<>();
        arbol.preOrder(hechizo -> {if (hechizo.getId() % 2 != 0) prohibidos.add(hechizo.getId());});
        return prohibidos;
    }

    /**
     * El cantico es el conjunto de nombres de los hechizos prohibidos de un mago,
     * la función de cantico() es justamente esa, generar el cantico de un mago
     * @return nombres de los hechizos prohibidos del grimorio de un mago separados por "-"
     * recorriendo los hechizos inOrden.
     */
    public String cantico(){
        LinkedList<String> nombres = new LinkedList<>();
        arbol.inOrder(hechizo ->{if (hechizo.getId() % 2 != 0) nombres.add(hechizo.getNombre());});
        return String.join(" - ",nombres);

    }
}
