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

    public void registrarAdmin(String[] dados) {
        Admin admin = new Admin(dados);
        dataAdmins.addAdmin(admin);
        System.out.println("Administrador registrado com sucesso.\n");
    }

    public void registrarCliente(String[] dados) {
        Cliente cliente = new Cliente(dados);
        dataClientes.addCliente(cliente);
        System.out.println("Cliente registrado com sucesso.\n");
    }

    public void registrarLoja(String[] dados) {
        Loja loja = new Loja(dados);
        dataLojas.addLoja(loja);
        System.out.println("Loja registrada com sucesso.\n");
    }

    public void deletarAdmin(String[] dados) {
        int id = extrairIDadmin(dados[0],dados[1]);
        dataAdmins.removeAdmin(id);
        System.out.println("Administrador deletado com sucesso.\n");
    }

    public void deletarCliente(String[] dados) {
        int id = extrairIDcliente(dados[0],dados[1]);
        dataClientes.removeCliente(id);
        System.out.println("Cliente deletado com sucesso.\n");
    }

    public void deletarLoja(String[] dados) {
        int id = extrairIDloja(dados[0],dados[1]);
        dataLojas.removeLoja(id);
        System.out.println("Loja deletado com sucesso.\n");
    }

    private int extrairIDadmin(String email, String senha) {

        ArrayList<Admin> admins = dataAdmins.getAdmins();
        for (int i = 0; i < admins.size(); i++) {
            Admin admin = admins.get(i);
            if (admin.getEmail().equals(email) && admin.getSenha().equals(senha)) {
                return i;
            }
        }
        return -1;
    }

    private int extrairIDcliente(String cpf, String senha) {

        ArrayList<Cliente> clientes = dataClientes.getClientes();
        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            if (cliente.getCPF().equals(cpf) && cliente.getSenha().equals(senha)) {
                return i;
            }
        }
        return -1;
    }

    private int extrairIDloja(String cnpj, String senha) {
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
