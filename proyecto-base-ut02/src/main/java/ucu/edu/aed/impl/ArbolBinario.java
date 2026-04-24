package ucu.edu.aed.impl;

import ucu.edu.aed.tda.TDAArbolBinario;
import ucu.edu.aed.tda.TDAElemento;

import java.util.function.Consumer;

public class ArbolBinario<T> implements TDAArbolBinario<T> {
    protected Nodo<T> raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    @Override
    public T buscar(Comparable<T> predicate) {
        if (raiz == null) return null;
        TDAElemento<T> encontrado = raiz.buscar(predicate);
        return (encontrado == null) ? null : encontrado.getDato();
    }

    @Override
    public TDAElemento<T> obtenerRaiz() {
        return raiz;
    }

    @Override
    public boolean eliminar(Comparable<T> criterioBusqueda) {
        if (raiz == null) return false;
        if (raiz.buscar(criterioBusqueda) == null) return false;
        TDAElemento<T> nuevaRaiz = raiz.eliminar(criterioBusqueda);
        raiz = (Nodo<T>) nuevaRaiz;
        return true;
    }

    @Override
    public boolean insertar(Comparable<T> dato) {
        if (raiz == null) {
            raiz = new Nodo<>((T) dato);
            return true;
        }
        return raiz.insertar(dato);
    }

    @Override
    public void inOrder(Consumer<T> consumidor) {
        if (raiz != null) {
            raiz.inOrder(elemento -> consumidor.accept(elemento.getDato()));
        }
    }

    @Override
    public void preOrder(Consumer<T> consumidor) {
        if (raiz != null) {
            raiz.preOrder(elemento -> consumidor.accept(elemento.getDato()));
        }
    }

    @Override
    public void postOrder(Consumer<T> consumidor) {
        if (raiz != null) {
            raiz.postOrder(elemento -> consumidor.accept(elemento.getDato()));
        }
    }

    @Override
    public boolean esVacio() {
        return raiz == null;
    }

    @Override
    public int cantidadNodos() {
        return (raiz == null) ? 0 : raiz.cantidadNodos();
    }

    @Override
    public int cantidadHojas() {
        return (raiz == null) ? 0 : raiz.cantidadHojas();
    }

    @Override
    public int cantidadNodosInternos() {
        return (raiz == null) ? 0 : raiz.cantidadNodosInternos();
    }
}