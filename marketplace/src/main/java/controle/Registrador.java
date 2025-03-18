package controle;

import DataBase.DataAdmins;
import DataBase.DataClientes;
import DataBase.DataLojas;
import entities.Admin;
import entities.Cliente;
import entities.Loja;

public class Registrador {
    DataAdmins dataAdmins = new DataAdmins();
    DataClientes dataClientes = new DataClientes();
    DataLojas dataLojas  = new DataLojas();

    public Admin registrarAdmin(String[] dados) {
        Admin admin = new Admin(dados);

        dataAdmins.addAdmin(admin);

        return admin;
    };

    public Cliente registrarCliente(String[] dados) {
        Cliente cliente = new Cliente(dados);

        dataClientes.addCliente(cliente);

        return cliente;
    }

    public Loja registrarLoja(String[] dados) {
        Loja loja = new Loja(dados);

        dataLojas.addLoja(loja);

        return loja;
    }

    // Getters and Setters

    public DataAdmins getDataAdmins() {
        return dataAdmins;
    }

    public void setDataAdmins(DataAdmins dataAdmins) {
        this.dataAdmins = dataAdmins;
    }

    public DataClientes getDataClientes() {
        return dataClientes;
    }

    public void setDataClientes(DataClientes dataClientes) {
        this.dataClientes = dataClientes;
    }

    public DataLojas getDataLojas() {
        return dataLojas;
    }

    public void setDataLojas(DataLojas dataLojas) {
        this.dataLojas = dataLojas;
    }

}
