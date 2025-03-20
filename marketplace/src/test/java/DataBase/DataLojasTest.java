package DataBase;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import entities.Loja;

import java.util.ArrayList;

public class DataLojasTest {

    private DataLojas dataLojas;

    @Before
    public void setUp() {
        dataLojas = new DataLojas();
    }

    @Test
    public void testAddLoja_Sucesso() {
        Loja loja = new Loja("Loja Teste", "loja@gmail.com", "12345678000195", "Rua da Loja", "senha123");
        Loja lojaAdicionada = dataLojas.addLoja(loja);

        assertNotNull(lojaAdicionada);
        assertEquals(loja, lojaAdicionada);
    }

    @Test
    public void testAddLoja_ListaNaoVazia() {
        Loja loja = new Loja("Loja Teste", "loja@gmail.com", "12345678000195", "Rua da Loja", "senha123");
        dataLojas.addLoja(loja);
        assertFalse(dataLojas.getLojas().isEmpty());
    }

    @Test
    public void testRemoveLoja_Sucesso() {
        Loja loja = new Loja("Loja Teste", "loja@gmail.com", "12345678000195", "Rua da Loja", "senha123");
        dataLojas.addLoja(loja);
        int idLoja = dataLojas.getLojas().size() - 1;
        boolean resultado = dataLojas.removeLoja(idLoja);
        assertTrue(resultado);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveLoja_Falha_IdInvalido() {
        dataLojas.removeLoja(999);
    }

    @Test
    public void testRemoveLoja_LojaNaoExistente() {
        Loja loja = new Loja("Loja Teste", "loja@gmail.com", "12345678000195", "Rua da Loja", "senha123");
        dataLojas.addLoja(loja);
        int idLoja = dataLojas.getLojas().size() - 1;
        dataLojas.removeLoja(idLoja);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            dataLojas.getLoja(idLoja);
        });
    }

    @Test
    public void testGetLoja_Sucesso() {
        Loja loja = new Loja("Loja Teste", "loja@gmail.com", "12345678000195", "Rua da Loja", "senha123");
        dataLojas.addLoja(loja);
        int idLoja = dataLojas.getLojas().size() - 1;
        Loja lojaObtida = dataLojas.getLoja(idLoja);
        assertNotNull(lojaObtida);
        assertEquals(loja, lojaObtida);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetLoja_IdInvalido() {
        dataLojas.getLoja(999);
    }

    @Test
    public void testSaveCurrentData_Sucesso() {
        Loja loja = new Loja("Loja Teste", "loja@gmail.com", "12345678000195", "Rua da Loja", "senha123");
        dataLojas.addLoja(loja);
        dataLojas.saveCurrentData();
        assertTrue(true);
    }
}
