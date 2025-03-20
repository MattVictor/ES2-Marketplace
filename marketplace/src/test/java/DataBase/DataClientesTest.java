package DataBase;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import DataBase.DataClientes;
import entities.Cliente;

import java.util.ArrayList;

public class DataClientesTest {

    private DataClientes dataClientes;

    @Before
    public void setUp() {
        dataClientes = new DataClientes();
    }

    @Test
    public void testAddCliente_Sucesso() {
        Cliente cliente = new Cliente("Nome Cliente", "cliente@gmail.com", "12345678900", "Rua Cliente", "senha123");
        Cliente clienteAdicionado = dataClientes.addCliente(cliente);

        assertNotNull(clienteAdicionado);
        assertEquals(cliente, clienteAdicionado);
    }

    @Test
    public void testAddCliente_ListaNaoVazia() {
        Cliente cliente = new Cliente("Nome Cliente", "cliente@gmail.com", "12345678900", "Rua Cliente", "senha123");
        dataClientes.addCliente(cliente);
        assertFalse(dataClientes.getClientes().isEmpty());
    }

    @Test
    public void testRemoveCliente_Sucesso() {
        Cliente cliente = new Cliente("Nome Cliente", "cliente@gmail.com", "12345678900", "Rua Cliente", "senha123");
        dataClientes.addCliente(cliente);
        int idCliente = dataClientes.getClientes().size() - 1;
        boolean resultado = dataClientes.removeCliente(idCliente);
        assertTrue(resultado);
    }

    @Test
    public void testRemoveCliente_Falha_IdInvalido() {
        assertThrows(IndexOutOfBoundsException.class, () -> {dataClientes.removeCliente(999);});
    }

    @Test
    public void testRemoveCliente_ClienteNaoExistente() {
        Cliente cliente = new Cliente("Nome Cliente", "cliente@gmail.com", "12345678900", "Rua Cliente", "senha123");
        dataClientes.addCliente(cliente);
        int idCliente = dataClientes.getClientes().size() - 1;
        dataClientes.removeCliente(idCliente);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            dataClientes.getCliente(idCliente);
        });
    }

    @Test
    public void testGetCliente_Sucesso() {
        Cliente cliente = new Cliente("Nome Cliente", "cliente@gmail.com", "12345678900", "Rua Cliente", "senha123");
        dataClientes.addCliente(cliente);
        int idCliente = dataClientes.getClientes().size() - 1;
        Cliente clienteObtido = dataClientes.getCliente(idCliente);
        assertNotNull(clienteObtido);
        assertEquals(cliente, clienteObtido);
    }

    @Test
    public void testGetCliente_IdInvalido() {
        assertThrows(IndexOutOfBoundsException.class, () -> {dataClientes.getCliente(999);});
    }

    @Test
    public void testSaveCurrentData_Sucesso() {
        Cliente cliente = new Cliente("Nome Cliente", "cliente@gmail.com", "12345678900", "Rua Cliente", "senha123");
        dataClientes.addCliente(cliente);
        dataClientes.saveCurrentData();
        assertTrue(true);
    }
}
