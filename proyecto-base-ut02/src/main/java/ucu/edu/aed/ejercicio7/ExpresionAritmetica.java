package ucu.edu.aed.ejercicio7;

import ucu.edu.aed.impl.ArbolBinario;
import ucu.edu.aed.tda.TDAArbolBinario;
import ucu.edu.aed.tda.TDAElemento;

import java.util.function.Consumer;

public class ExpresionAritmetica{

    private TDAElemento<String> raiz;

    public void sustituir(String operando,int valor){
        if (raiz != null){
           raiz.sustituir(operando,valor);
        }
    }

    public int evaluar(){
        if (raiz!=null){
           return raiz.evaluar();
        }
        return 0;
    }
}
