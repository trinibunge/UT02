package ucu.edu.aed.impl;

import ucu.edu.aed.tda.TDAArbolBinario;
import ucu.edu.aed.tda.TDAElemento;

import java.util.function.Consumer;

public class ArbolBinario<T> implements TDAArbolBinario<TDAElemento> {
    protected Nodo<T> raiz;

    public ArbolBinario() {
        raiz = null;
    }

    @Override
    public TDAElemento buscar(Comparable clave) {
        if (raiz != null) {
            return raiz.buscar(clave);
        }
        return null;
    }

    @Override
    public ucu.edu.aed.tda.TDAElemento<TDAElemento> obtenerRaiz() {
        return null;
    }

    @Override
    public boolean eliminar(Comparable<TDAElemento> criterioBusqueda) {
        return false;
    }

    @Override
    public boolean insertar(Comparable<TDAElemento> dato) {
        if (raiz != null) {
            return raiz.insertar((Comparable<T>) dato);
        }
        else{
            return false;
        }
    }

    @Override
    public void inOrder(Consumer<TDAElemento> consumidor) {

    }

    @Override
    public void preOrder(Consumer<TDAElemento> consumidor) {

    }

    @Override
    public void postOrder(Consumer<TDAElemento> consumidor) {

    }

    @Override
    public boolean esVacio() {
        return false;
    }

    @Override
    public int cantidadNodos() {
        return 0;
    }

    @Override
    public int cantidadHojas() {
        return 0;
    }

    @Override
    public int cantidadNodosInternos() {
        return 0;
    }
}
