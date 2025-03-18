package main;

import controle.Controlador;
import controle.Estados;
import entities.*;
import DataBase.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Controlador controlador = new Controlador();
        Estados estado;

        do {
            estado = controlador.executarMenu();
        } while (estado != Estados.SAIR);

        /*DataClientes data = new DataClientes();

        ArrayList<Cliente> clientes = data.getClientes();

        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }*/

//        data.removeCliente(0);
//
//        for (Cliente cliente : clientes) {
//            System.out.println(cliente);
//        }
    }
}