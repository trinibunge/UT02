package ucu.edu.aed.ejercicio12.app;

import ucu.edu.aed.ejercicio12.Grimorio;

public class main {
    public static void main(String[] args) {
        Grimorio grimorioAldric = new Grimorio();
        grimorioAldric.agregarHechizos(32, "Fireball");
        grimorioAldric.agregarHechizos(17, "Ice Lance");
        grimorioAldric.agregarHechizos(58, "Thunder");
        grimorioAldric.agregarHechizos(9, "Invisibility");
        grimorioAldric.agregarHechizos(31, "Levitate");
        grimorioAldric.agregarHechizos(73, "Summon");
        grimorioAldric.agregarHechizos(25, "Heal");
        grimorioAldric.agregarHechizos(50, "Teleport");
        grimorioAldric.agregarHechizos(65, "Shield");
        grimorioAldric.agregarHechizos(88, "Curse");

        System.out.println("\n¡Bienvenidos al Grimorio del Archimago Aldric!\n");
        System.out.println("\nIds de todos los hechizos en preOrden: " + grimorioAldric.idsHechizos());
        System.out.println("\nIds de los Hechizos Prohibidos en preOrden: " + grimorioAldric.hechizosProhibidos());
        System.out.println("\nEl cantico secreto de Aldric es: " +  grimorioAldric.cantico());



    }
}
