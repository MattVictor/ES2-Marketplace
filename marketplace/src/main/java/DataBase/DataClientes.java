package DataBase;

import entities.Cliente;

import java.util.ArrayList;

public class DataClientes {
    DataBaseManager data;
    ArrayList<Cliente> clientes;

    public DataClientes() {
        data = new DataBaseManager("clientes", Cliente.class);
        clientes = new ArrayList<>();
        Object[] obj = data.parseData();

        for (int i = 0; i < obj.length; i++) {
            if (obj[i] instanceof Cliente) {
                clientes.add((Cliente) obj[i]);
            }
        }
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public Cliente getCliente(int id) {
        return clientes.get(id);
    }

    public Cliente addCliente(Cliente cliente) {
        clientes.add(cliente);
        saveCurrentData();

        return cliente;
    }

    public Cliente removeCliente(int id) {
        clientes.remove(id);
        saveCurrentData();

        return getCliente(id);
    }

    public void saveCurrentData(){
        data.writeData(clientes.toArray());
    }
}