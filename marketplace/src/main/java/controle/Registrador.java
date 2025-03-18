package controle;

import DataBase.DataAdmins;
import DataBase.DataClientes;
import DataBase.DataLojas;
import entities.Cliente;
import entities.Loja;

public class Registrador {

    DataAdmins dataAdmins = new DataAdmins();
    DataClientes dataClientes = new DataClientes();
    DataLojas dataLojas  = new DataLojas();

    public void registrarCliente(String[] dados) {
        Cliente cliente = new Cliente(dados);

        dataClientes.addCliente(cliente);
    }

    public void registrarLoja(String[] dados) {
        Loja loja = new Loja(dados);

        dataLojas.addLoja(loja);
    }
}
