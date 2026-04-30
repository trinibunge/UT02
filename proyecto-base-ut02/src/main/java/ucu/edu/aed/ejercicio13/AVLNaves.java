package ucu.edu.aed.ejercicio13;


import ucu.edu.aed.tda.TDAArbolBinario;

import java.util.ArrayList;
import java.util.List;

/**
 * Se apoya en el inOrder() que ya provee TDAArbolBinario, delegando
 * la recursión al propio árbol
 */
public class AVLNaves {

    private TDAArbolBinario<Nave> avl;

    public AVLNaves(TDAArbolBinario<Nave> avl) {
        this.avl = avl;
    }

    public List<Integer> listarNavesExploradoras() {

        // arbol no vacío
        if (avl.esVacio()) {
            throw new RuntimeException("AVL vacío");
        }

        List<Integer> lista = new ArrayList<>();

        avl.inOrder(nave -> {
            if ("Explorador".equals(nave.getClase())) {
                lista.add(nave.getCodigo());
            }
        });

        return lista;
    }


    public double calcularCombustible() {

        // Precondición: árbol no vacío
        if (avl.esVacio()) {
            throw new RuntimeException("AVL vacío");
        }

        // Acumuladores: usamos un arreglo de un elemento para poder
        // modificarlos dentro del lambda (que exige variables finales)
        double[] suma = {0};
        int[]    cantidad = {0};

        // inOrder recorre todos los nodos; filtramos las exploradoras
        avl.inOrder(nave -> {
            if ("Explorador".equals(nave.getClase())) {
                suma[0]     += nave.getCombustible();
                cantidad[0] += 1;
            }
        });

        if (cantidad[0] == 0) {
            return 0;
        }

        return suma[0] / cantidad[0];
    }
}