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
                Nodo<T> nuevoNodo = new Nodo<T>((T) nuevoDato);
                setHijoDerecho(nuevoNodo);
                return true;
            } else {
                return getHijoDerecho().insertar(nuevoDato);
            }
        } else if (criterio < 0) {
            if(getHijoIzquierdo() == null){
                Nodo<T> nuevoNodo = new Nodo<T>((T) nuevoDato);
                setHijoIzquierdo(nuevoNodo);
                return true;
            } else {
                return getHijoIzquierdo().insertar(nuevoDato);
            }
        }
        return false;
    }

    @Override
    public void inOrder(Consumer<TDAElemento<T>> consumidor) {
        if(hijoIzq!=null){
            hijoIzq.inOrder(consumidor);
        }
        consumidor.accept(this);
        if(hijoDer!=null){
            hijoDer.inOrder(consumidor);
        }

    }

    @Override
    public void preOrder(Consumer<TDAElemento<T>> consumidor) {
        consumidor.accept(this);
        if(hijoIzq!=null){
            hijoIzq.preOrder(consumidor);
        }
        if(hijoDer!=null){
            hijoDer.preOrder(consumidor);
        }

    }

    @Override
    public void postOrder(Consumer<TDAElemento<T>> consumidor) {
        if(hijoIzq!=null){
            hijoIzq.postOrder(consumidor);
        }
        if(hijoDer!=null){
            hijoDer.postOrder(consumidor);
        }
        consumidor.accept(this);

    }

    @Override
    public boolean esHoja() {
        return(hijoIzq == null && hijoDer == null);
    }

    @Override
    public int cantidadHojas() {
       int contador = 0;
       if (hijoIzq==null && hijoDer == null){
           contador++;
       }else {
           if (hijoIzq != null) {
               contador += hijoIzq.cantidadHojas();
           }
           if (hijoDer != null) {
               contador += hijoDer.cantidadHojas();
           }
       }
       return contador;
    }

    @Override
    public int cantidadNodosInternos() {
        int contador = 0;

        if (hijoIzq != null || hijoDer != null) {
            contador = 1;
        }
        if (hijoIzq!=null){
            contador += hijoIzq.cantidadNodosInternos();
        }
        if (hijoDer !=null){
            contador += hijoDer.cantidadNodosInternos();
        }
        return contador;
    }

    @Override
    public int cantidadNodos() {
        int contador = 1;
        if (hijoIzq!=null){
            contador += hijoIzq.cantidadNodos();
        }
        if (hijoDer !=null){
            contador += hijoDer.cantidadNodos();
        }
        return contador;
    }

    @Override
    public int altura() {
        if (hijoIzq != null && hijoDer != null) {
            return 0;
        }
        int alturaIzq = (hijoIzq != null) ? hijoIzq.altura() : -1;
        int alturaDer = hijoDer != null ? hijoDer.altura() : -1;
        return Math.max(alturaIzq, alturaDer);
    }

    @Override
    public int obtenerNivel(Comparable<T> criterioBusqueda) {
        int criterio = criterioBusqueda.compareTo(this.dato);
        if (criterio == 0) {
            return 0;
        }
        if (criterio < 0) {
            if (hijoIzq != null) {
                return 1 + hijoIzq.obtenerNivel(criterioBusqueda);
            }
        }
        if (criterio > 0) {
            if (hijoDer != null) {
                return 1 + hijoDer.obtenerNivel(criterioBusqueda);
            }
        }
        return -1;
    }
    }

