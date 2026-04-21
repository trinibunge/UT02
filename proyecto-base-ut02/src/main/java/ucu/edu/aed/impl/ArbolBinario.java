package ucu.edu.aed.impl;

import ucu.edu.aed.tda.TDAArbolBinario;
import ucu.edu.aed.tda.TDAElemento;

import java.awt.geom.QuadCurve2D;
import java.util.NoSuchElementException;
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
        if (raiz == null) {
            return null;
        }
        else{
            return (TDAElemento<TDAElemento>) raiz;
        }
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
            raiz = new Nodo<T>((T) dato);
            return true;
        }
    }

    @Override
    public void inOrder(Consumer<TDAElemento> consumidor) {
        if (raiz != null) {
            raiz.inOrder(elemento ->consumidor.accept(elemento));
        }else{
            throw new NoSuchElementException();
        }
    }

    @Override
    public void preOrder(Consumer<TDAElemento> consumidor) {
        if (raiz != null) {
            raiz.preOrder(elemento ->consumidor.accept(elemento));
        } else{
            throw new NoSuchElementException();
        }

    }

    @Override
    public void postOrder(Consumer<TDAElemento> consumidor) {
        if (raiz != null) {
            raiz.postOrder(elemento ->consumidor.accept(elemento));
        }  else{
            throw new NoSuchElementException();
        }

    }

    @Override
    public boolean esVacio() {
        return raiz == null;
    }

    @Override
    public int cantidadNodos() {
        if (raiz == null) {
            return 0;
        } else{
            return raiz.cantidadNodos();
        }
    }

    @Override
    public int cantidadHojas() {
       if (raiz != null) {
           return raiz.cantidadHojas();
       }else{
           return 0;
       }
    }

    @Override
    public int cantidadNodosInternos() {
        if (raiz != null) {
            return raiz.cantidadNodosInternos();
        }
        else{
            return 0;
        }
    }
}
