package main;

import controle.Controlador;
import controle.Estados;
import static controle.Estados.SAIR;

public class Main {
    public static void main(String[] args) {

        Controlador controlador = new Controlador();
        Estados estado;

        do {
            estado = controlador.executarMenu();
        }
        while (estado != SAIR);
    }
}