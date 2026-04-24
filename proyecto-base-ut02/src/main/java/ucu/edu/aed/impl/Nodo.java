package ucu.edu.aed.impl;

import ucu.edu.aed.tda.TDAElemento;
import java.util.function.Consumer;

public class Nodo<T> implements TDAElemento<T> {
    private T dato;
    private Nodo<T> hijoIzq;
    private Nodo<T> hijoDer;

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
            return (hijoIzq == null) ? null : hijoIzq.buscar(criterioBusqueda);
        } else {
            return (hijoDer == null) ? null : hijoDer.buscar(criterioBusqueda);
        }
    }

    /**
     * Quita este nodo y devuelve el subárbol que debe ocupar su lugar.
     * Estrategia: si tiene dos hijos, lo reemplaza por el MAYOR del subárbol izquierdo
     * (predecesor in-order) — copia su dato y elimina ese nodo del subárbol izquierdo.
     */
    @Override
    public TDAElemento<T> quitarElNodo() {
        if (this.hijoIzq == null) {
            return this.hijoDer;
        }
        if (this.hijoDer == null) {
            return this.hijoIzq;
        }
        // Tiene dos hijos: buscar el mayor del subárbol izquierdo
        Nodo<T> padre = this;
        Nodo<T> elHijo = this.hijoIzq;
        while (elHijo.hijoDer != null) {
            padre = elHijo;
            elHijo = elHijo.hijoDer;
        }
        // Copio el dato del predecesor a este nodo
        this.dato = elHijo.getDato();
        // Desengancho el predecesor: si nunca avanzó a la derecha, padre == this
        if (padre == this) {
            padre.hijoIzq = elHijo.hijoIzq;
        } else {
            padre.hijoDer = elHijo.hijoIzq;
        }
        return this;
    }

    @Override
    public TDAElemento<T> eliminar(Comparable<T> criterioBusqueda) {
        int criterio = criterioBusqueda.compareTo(this.dato);
        if (criterio < 0) {
            if (hijoIzq != null) {
                setHijoIzquierdo(hijoIzq.eliminar(criterioBusqueda));
            }
            return this;
        } else if (criterio > 0) {
            if (hijoDer != null) {
                setHijoDerecho(hijoDer.eliminar(criterioBusqueda));
            }
            return this;
        }
        return quitarElNodo();
    }

    @Override
    public boolean insertar(Comparable<T> nuevoDato) {
        int criterio = nuevoDato.compareTo(this.dato);
        if (criterio > 0) {
            if (hijoDer == null) {
                hijoDer = new Nodo<>((T) nuevoDato);
                return true;
            }
            return hijoDer.insertar(nuevoDato);
        } else if (criterio < 0) {
            if (hijoIzq == null) {
                hijoIzq = new Nodo<>((T) nuevoDato);
                return true;
            }
            return hijoIzq.insertar(nuevoDato);
        }
        return false; // duplicado
    }

    @Override
    public void inOrder(Consumer<TDAElemento<T>> consumidor) {
        if (hijoIzq != null) hijoIzq.inOrder(consumidor);
        consumidor.accept(this);
        if (hijoDer != null) hijoDer.inOrder(consumidor);
    }

    @Override
    public void preOrder(Consumer<TDAElemento<T>> consumidor) {
        consumidor.accept(this);
        if (hijoIzq != null) hijoIzq.preOrder(consumidor);
        if (hijoDer != null) hijoDer.preOrder(consumidor);
    }

    @Override
    public void postOrder(Consumer<TDAElemento<T>> consumidor) {
        if (hijoIzq != null) hijoIzq.postOrder(consumidor);
        if (hijoDer != null) hijoDer.postOrder(consumidor);
        consumidor.accept(this);
    }

    @Override
    public boolean esHoja() {
        return hijoIzq == null && hijoDer == null;
    }

    @Override
    public int cantidadHojas() {
        if (esHoja()) return 1;
        int c = 0;
        if (hijoIzq != null) c += hijoIzq.cantidadHojas();
        if (hijoDer != null) c += hijoDer.cantidadHojas();
        return c;
    }

    @Override
    public int cantidadNodosInternos() {
        int c = esHoja() ? 0 : 1;
        if (hijoIzq != null) c += hijoIzq.cantidadNodosInternos();
        if (hijoDer != null) c += hijoDer.cantidadNodosInternos();
        return c;
    }

    @Override
    public int cantidadNodos() {
        int c = 1;
        if (hijoIzq != null) c += hijoIzq.cantidadNodos();
        if (hijoDer != null) c += hijoDer.cantidadNodos();
        return c;
    }

    @Override
    public int altura() {
        int izq = (hijoIzq != null) ? hijoIzq.altura() : 0;
        int der = (hijoDer != null) ? hijoDer.altura() : 0;
        return 1 + Math.max(izq, der);
    }

    @Override
    public int obtenerNivel(Comparable<T> criterioBusqueda) {
        int criterio = criterioBusqueda.compareTo(this.dato);
        if (criterio == 0) return 0;
        if (criterio < 0 && hijoIzq != null) {
            int n = hijoIzq.obtenerNivel(criterioBusqueda);
            return (n == -1) ? -1 : 1 + n;
        }
        if (criterio > 0 && hijoDer != null) {
            int n = hijoDer.obtenerNivel(criterioBusqueda);
            return (n == -1) ? -1 : 1 + n;
        }
        return -1;
    }
}