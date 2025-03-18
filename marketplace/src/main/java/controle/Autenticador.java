package controle;

import DataBase.DataAdmins;
import DataBase.DataClientes;
import DataBase.DataLojas;
import entities.Admin;
import entities.Cliente;
import entities.Loja;
import java.util.ArrayList;

public class Autenticador {
    DataAdmins dataAdmins;
    DataClientes dataClientes;
    DataLojas dataLojas;

    public Autenticador(Registrador registrador) {
        this.dataAdmins = registrador.getDataAdmins();
        this.dataClientes = registrador.getDataClientes();
        this.dataLojas = registrador.getDataLojas();
    }

    public boolean autenticarAdmin(String email, String senha) {
        ArrayList<Admin> admins = dataAdmins.getAdmins();
        for (Admin adm : admins) {
            if (adm.getEmail().equals(email) && adm.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }

    public boolean autenticarCliente(String cpf, String senha) {
        ArrayList<Cliente> clientes = dataClientes.getClientes();
        for (Cliente clt : clientes) {
            if (clt.getCPF().equals(cpf) && clt.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }

    public boolean autenticarLoja(String cnpj, String senha) {
        ArrayList<Loja> lojas = dataLojas.getLojas();
        for (Loja lj : lojas) {
            if (lj.getCNPJ().equals(cnpj) && lj.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }
}
