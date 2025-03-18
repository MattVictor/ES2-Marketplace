package controle;

import DataBase.DataAdmins;
import DataBase.DataClientes;
import DataBase.DataLojas;
import entities.Admin;
import entities.Cliente;
import entities.Loja;
import java.util.ArrayList;

public class AcessarDados {

    DataAdmins dataAdmins = new DataAdmins();
    DataClientes dataClientes = new DataClientes();
    DataLojas dataLojas = new DataLojas();

    public void listarClientes() {
        ArrayList<Cliente> clientes = dataClientes.getClientes();

        System.out.println("Clientes registrados:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente.getNome() + ", "+ cliente.getCPF());
        }
        System.out.println();
    }
    public void listarAdmins() {
        ArrayList<Admin> admins = dataAdmins.getAdmins();

        System.out.println("Administradores registrados:");
        for (Admin admin : admins) {
            System.out.println(admin.getNome() + ", "+ admin.getCPF());
        }
        System.out.println();
    }
    public void listarLojas() {
        ArrayList<Loja> lojas = dataLojas.getLojas();

        System.out.println("Lojas registradas:");
        for (Loja loja : lojas) {
            System.out.println(loja.getNome() + ", " + loja.getCNPJ());
        }
        System.out.println();
    }
}
