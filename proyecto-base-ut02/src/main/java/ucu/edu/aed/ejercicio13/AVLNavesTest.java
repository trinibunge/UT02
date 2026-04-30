package ucu.edu.aed.ejercicio13;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ucu.edu.aed.impl.ArbolBinario;
import ucu.edu.aed.tda.TDAArbolBinario;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AVLNavesTest {

    private AVLNaves avlNaves;
    private TDAArbolBinario<Nave> avl; // reemplazá por tu implementación concreta

    @BeforeEach
    void setUp() {
        avl = new ArbolBinario<>();
        avlNaves = new AVLNaves(avl);
    }

    @Test
    void listarNavesExploradorasArbolVacioLanzaError() {
        assertThrows(RuntimeException.class, () -> avlNaves.listarNavesExploradoras());
    }

    @Test
    void listarNavesExploradorasSinExploradoresRetornaListaVacia() {
        avl.insertar(new Nave(10, "Combate",    100));
        avl.insertar(new Nave(20, "Transporte", 200));

        List<Integer> resultado = avlNaves.listarNavesExploradoras();

        assertTrue(resultado.isEmpty());
    }

    @Test
    void listarNavesExploradorasUnSoloExploradorRetornaUnCodigo() {
        avl.insertar(new Nave(10, "Explorador", 100));

        List<Integer> resultado = avlNaves.listarNavesExploradoras();

        assertEquals(1, resultado.size());
        assertEquals(10, resultado.get(0));
    }

    @Test
    void listarNavesExploradorasVariosExploradoresRetornaOrdenAscendente() {
        avl.insertar(new Nave(30, "Explorador", 300));
        avl.insertar(new Nave(10, "Explorador", 100));
        avl.insertar(new Nave(20, "Combate",    200));
        avl.insertar(new Nave(40, "Explorador", 400));

        List<Integer> resultado = avlNaves.listarNavesExploradoras();

        assertEquals(List.of(10, 30, 40), resultado);

    }


    @Test
    void calcularCombustibleArbolVacioLanzaError() {
        assertThrows(RuntimeException.class, () -> avlNaves.calcularCombustible());
    }

    @Test
    void calcularCombustibleSinExploradoresRetornaCero() {
        avl.insertar(new Nave(10, "Combate",    100));
        avl.insertar(new Nave(20, "Transporte", 200));

        assertEquals(0, avlNaves.calcularCombustible());
    }

    @Test
    void calcularCombustibleUnSoloExploradorRetornaSuCombustible() {
        avl.insertar(new Nave(10, "Explorador", 100));
        avl.insertar(new Nave(20, "Combate",    200));

        assertEquals(100, avlNaves.calcularCombustible());
    }

    @Test
    void calcularCombustibleVariosExploradoresRetornaPromedioCorrecto() {
        // exploradores con combustible 100, 200, 300 → promedio = 200
        avl.insertar(new Nave(10, "Explorador", 100));
        avl.insertar(new Nave(20, "Combate",    999));
        avl.insertar(new Nave(30, "Explorador", 200));
        avl.insertar(new Nave(40, "Explorador", 300));

        assertEquals(200.0, avlNaves.calcularCombustible(), 0.001);
    }

    @Test
    void calcularCombustibleTodosExploradoresRetornaPromedioCorrecto() {
        avl.insertar(new Nave(10, "Explorador", 50));
        avl.insertar(new Nave(20, "Explorador", 150));

        // (50 + 150) / 2 = 100
        assertEquals(100.0, avlNaves.calcularCombustible(), 0.001);
    }
}
