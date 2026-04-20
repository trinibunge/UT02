package ucu.edu.aed.impl;
import ucu.edu.aed.tda.TDAElemento;
import java.util.function.Consumer;

public class Nodo<T> implements TDAElemento<T> {
        private T dato;
        private Nodo<T> hijoIzq;
        private Nodo<T> hijoDer;
    // Constructor
    public Nodo(T dato) {
        this.dato = dato;
        this.hijoIzq = null;
        this.hijoDer = null;
    }
    @Override
    public void setHijoIzquierdo(TDAElemento<T> hijoIzquierdo) {
        this.hijoIzq = (Nodo<T>) hijoIzquierdo;
    }

    @Override
    public void setHijoDerecho(TDAElemento<T> hijoDerecho) {
        this.hijoDer = (Nodo<T>) hijoDerecho;

    }

    @Override
    public TDAElemento<T> getHijoIzquierdo() {
        return this.hijoIzq;
    }

    @Override
    public TDAElemento<T> getHijoDerecho() {
        return this.hijoDer;
    }

    @Override
    public void setDato(T dato) {
        this.dato = dato;
    }

    @Override
    public T getDato() {
        return this.dato;
    }

    @Override
    public TDAElemento<T> buscar(Comparable<T> criterioBusqueda) {
        int criterio = criterioBusqueda.compareTo(this.dato);
        if (criterio == 0) {
            return this;
        }
        if (criterio < 0) {
            if (hijoIzq == null) {
                return null;
            } else {
                return hijoIzq.buscar(criterioBusqueda);
            }
        } else {
            if (hijoDer == null) {
                return null;
            } else {
                return hijoDer.buscar(criterioBusqueda);
            }
        }
    }
    @Override
    public TDAElemento<T> eliminar(Comparable<T> criterioBusqueda) {
        return null;
    }

    @Override
    public boolean insertar(Comparable<T> nuevoDato) {
        int criterio = nuevoDato.compareTo(this.dato);
        if (criterio > 0){
            if (getHijoDerecho()==null){
                Nodo<T> nuevoNodo = new Nodo<T>(dato);
                setHijoDerecho(nuevoNodo);
                return true;
            }else {
                getHijoDerecho().insertar(nuevoDato);
            }
        } else if (criterio < 0) {
            if(getHijoIzquierdo() == null){
                Nodo<T> nuevoNodo = new Nodo<T>(dato);
                setHijoIzquierdo(nuevoNodo);
                return true;
            }else{
                getHijoIzquierdo().insertar(nuevoDato);
            }
        }
        return false;
    }

    @Override
    public void inOrder(Consumer<TDAElemento<T>> consumidor) {

    }

    @Override
    public void preOrder(Consumer<TDAElemento<T>> consumidor) {

    }

    @Override
    public void postOrder(Consumer<TDAElemento<T>> consumidor) {

    }

    @Override
    public boolean esHoja() {
        return(hijoIzq == null && hijoDer == null);
    }

    @Override
    public int cantidadHojas() {
    }

    @Override
    public int cantidadNodosInternos() {
        return 0;
    }

    @Override
    public int cantidadNodos() {
        return 0;
    }

    @Override
    public int altura() {
        return 0;
    }

    @Override
    public int obtenerNivel(Comparable<T> criterioBusqueda) {
        return 0;
    }
}

