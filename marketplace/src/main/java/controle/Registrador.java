package controle;

import DataBase.DataAdmins;
import DataBase.DataClientes;
import DataBase.DataLojas;
import entities.Admin;
import entities.Cliente;
import entities.Loja;
import java.util.ArrayList;

public class Registrador {

    DataAdmins dataAdmins = new DataAdmins();
    DataClientes dataClientes = new DataClientes();
    DataLojas dataLojas  = new DataLojas();

    public Admin registrarAdmin(String[] dados) {
        Admin admin = new Admin(dados);
        dataAdmins.addAdmin(admin);
        System.out.println("Administrador registrado com sucesso.\n");

        return admin;
    }

    public Cliente registrarCliente(String[] dados) {
        Cliente cliente = new Cliente(dados);
        dataClientes.addCliente(cliente);
        System.out.println("Cliente registrado com sucesso.\n");

        return cliente;
    }

    public Loja registrarLoja(String[] dados) {
        Loja loja = new Loja(dados);
        dataLojas.addLoja(loja);
        System.out.println("Loja registrada com sucesso.\n");

        return loja;
    }

    public boolean deletarAdmin(String[] dados) {
        int id = extrairIDadmin(dados[1],dados[4]);
        boolean result = false;
        if (id != -1) {
            result = dataAdmins.removeAdmin(id);
        }
        if (result) {
            System.out.println("Administrador deletado com sucesso.\n");
            return result;
        }
        System.out.println("Administrador nao deletado com sucesso.\n");
        return false;
    }

    public boolean deletarCliente(String[] dados) {
        int id = extrairIDcliente(dados[2],dados[4]);
        boolean result = false;
        if (id != -1) {
            result = dataClientes.removeCliente(id);
        }
        if (result) {
            System.out.println("Cliente deletado com sucesso.\n");
            return result;
        }
        System.out.println("Cliente nao deletado com sucesso.\n");
        return false;
    }

    public boolean deletarLoja(String[] dados) {
        int id = extrairIDloja(dados[2],dados[4]);
        boolean result = false;
        if (id != -1) {
            result = dataLojas.removeLoja(id);
        }
        if (result) {
            System.out.println("Loja deletado com sucesso.\n");
            return result;
        }
        System.out.println("Loja nao deletado com sucesso.\n");
        return false;
    }

    protected int extrairIDadmin(String email, String senha) {

        ArrayList<Admin> admins = dataAdmins.getAdmins();
        for (int i = 0; i < admins.size(); i++) {
            Admin admin = admins.get(i);
            if (admin.getEmail().equals(email) && admin.getSenha().equals(senha)) {
                System.out.println("ID extraido com sucesso.\n");
                return i;
            }
        }
        System.out.println("ID nao encontrado com sucesso.\n");
        return -1;
    }

    protected int extrairIDcliente(String cpf, String senha) {

        ArrayList<Cliente> clientes = dataClientes.getClientes();
        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            if (cliente.getCPF().equals(cpf) && cliente.getSenha().equals(senha)) {
                return i;
            }
        }
        return -1;
    }

    protected int extrairIDloja(String cnpj, String senha) {
        ArrayList<Loja> lojas = dataLojas.getLojas();
        for (int i = 0; i < lojas.size(); i++) {
            Loja loja = lojas.get(i);
            if (loja.getCNPJ().equals(cnpj) && loja.getSenha().equals(senha)) {
                return i;
            }
        }
        return -1;
    }
}
