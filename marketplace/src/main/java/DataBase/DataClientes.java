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

    public boolean removeCliente(int id) {
        if (id < 0 || id >= clientes.size()) {
            throw new IndexOutOfBoundsException("Cliente com ID inválido");
        }
        clientes.remove(id);
        saveCurrentData();
        return true;
    }

    public void saveCurrentData(){
        data.writeData(clientes.toArray());
    }
}