package controle;

import entities.Admin;
import entities.Cliente;
import entities.Loja;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegistradorTest {

    static Registrador registrador;

    @Before
    public void setUp() {
        registrador = new Registrador();

        // Dados de exemplo para os testes com a nova ordem
        String[] admin = {"adminTest", "admin@gmail.com", "12345678900", "rua tal", "senha123"};
        String[] cliente = {"clienteTest", "cliente@gmail.com", "12345678900", "Rua das ruas", "senha123"};
        String[] loja = {"lojaTest", "teste@gmail.com", "12345678000195", "Rua das lojas amarelas", "senha123"};

        // Registrar os objetos
        registrador.registrarAdmin(admin);
        registrador.registrarCliente(cliente);
        registrador.registrarLoja(loja);
    }

    @Test
    public void registrarAdmin_Sucesso() {
        String[] dadosAdmin = {"adminTeste", "admin2@gmail.com", "12345678901", "Rua Nova", "senha456"};
        Admin admin = registrador.registrarAdmin(dadosAdmin);

        assertNotNull(admin);
        assertEquals(dadosAdmin, admin.getDados());
    }

    @Test
    public void registrarCliente_Sucesso() {
        String[] dadosCliente = {"clienteTeste", "cliente2@gmail.com", "12345678901", "Rua do cliente", "senha456"};
        Cliente cliente = registrador.registrarCliente(dadosCliente);

        assertNotNull(cliente);
        assertEquals(dadosCliente, cliente.getDados());
    }

    @Test
    public void registrarLoja_Sucesso() {
        String[] dadosLoja = {"lojaTeste", "loja2@gmail.com", "12345678000196", "Rua das lojas verdes", "senha456"};
        Loja loja = registrador.registrarLoja(dadosLoja);

        assertNotNull(loja);
        assertEquals(dadosLoja, loja.getDados());
    }

    @Test
    public void deletarAdmin_Sucesso() {
        String[] dadosAdmin = {"adminTest", "admin@gmail.com", "12345678900", "rua tal", "senha123"};

        // Deletar o admin
        boolean deletedAdmin = registrador.deletarAdmin(dadosAdmin);

        // Verificar se o admin foi realmente deletado
        assertTrue(deletedAdmin);
    }

    @Test
    public void deletarAdmin_Inexistente() {
        String[] dadosAdmin = {"adminInexistente", "admin@example.com", "99999999999", "Rua desconhecida", "senhaErrada"};

        boolean adminDeletado = registrador.deletarAdmin(dadosAdmin);

        assertFalse(adminDeletado);
    }

    @Test
    public void deletarCliente_Sucesso() {
        String[] dadosCliente = {"clienteTest", "cliente@gmail.com", "12345678900", "Rua das ruas", "senha123"};

        // Registrar novamente o cliente para testar a deleção
        registrador.registrarCliente(dadosCliente);

        boolean clienteDeletado = registrador.deletarCliente(dadosCliente);

        assertTrue(clienteDeletado); // O cliente foi deletado, então esperamos que seja null
    }

    @Test
    public void deletarCliente_Inexistente() {
        String[] dadosCliente = {"clienteInexistente", "cliente@example.com", "00000000000", "Rua Desconhecida", "senhaErrada"};

        boolean clienteDeletado = registrador.deletarCliente(dadosCliente);

        assertFalse(clienteDeletado); // Esperamos que o cliente não seja encontrado
    }

    @Test
    public void deletarLoja_Sucesso() {
        String[] dadosLoja = {"lojaTest", "teste@gmail.com", "12345678000195", "Rua das lojas amarelas", "senha123"};

        // Registrar novamente a loja para testar a deleção
        registrador.registrarLoja(dadosLoja);

        boolean lojaDeletada = registrador.deletarLoja(dadosLoja);

        assertTrue(lojaDeletada); // Esperamos que a loja tenha sido deletada
    }

    @Test
    public void deletarLoja_Inexistente() {
        String[] dadosLoja = {"lojaInexistente", "loja@example.com", "00000000000000", "Rua Desconhecida", "senhaErrada"};

        boolean lojaDeletada = registrador.deletarLoja(dadosLoja);

        assertFalse(lojaDeletada); // Esperamos que a loja não seja encontrada
    }

    @Test
    public void extrairIDadmin_Valido() {
        String[] dadosAdmin = {"adminTest", "admin@gmail.com", "12345678900", "rua tal", "senha123"};

        registrador.registrarAdmin(dadosAdmin);

        int id = registrador.extrairIDadmin("admin@gmail.com", "senha123");

        assertNotEquals(-1, id);
    }

    @Test
    public void extrairIDadmin_Invalido() {
        int id = registrador.extrairIDadmin("emailInvalido@example.com", "senhaErrada");

        assertEquals(-1, id); // Não existe o admin com esse email e senha
    }

    @Test
    public void extrairIDcliente_Valido() {
        String[] dadosCliente = {"clienteTest", "cliente@gmail.com", "12345678900", "Rua das ruas", "senha123"};

        // Registrar novamente o cliente
        registrador.registrarCliente(dadosCliente);

        int id = registrador.extrairIDcliente("12345678900", "senha123");

        assertNotEquals(-1, id);
    }

    @Test
    public void extrairIDcliente_Invalido() {
        int id = registrador.extrairIDcliente("00000000000", "senhaErrada");

        assertEquals(-1, id); // Não existe o cliente com esse CPF e senha
    }

    @Test
    public void extrairIDloja_Valido() {
        String[] dadosLoja = {"lojaTest", "teste@gmail.com", "12345678000195", "Rua das lojas amarelas", "senha123"};

        // Registrar novamente a loja
        registrador.registrarLoja(dadosLoja);

        int id = registrador.extrairIDloja("12345678000195", "senha123");

        assertNotEquals(-1, id); // O ID da loja registrada é 0, já que é a primeira loja
    }

    @Test
    public void extrairIDloja_Invalido() {
        int id = registrador.extrairIDloja("00000000000000", "senhaErrada");

        assertEquals(-1, id); // Não existe a loja com esse CNPJ e senha
    }
}
