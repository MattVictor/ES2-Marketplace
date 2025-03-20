package DataBase;

import entities.Admin;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DataAdminsTest {

    private DataAdmins dataAdmins;

    @Before
    public void setUp() {
        dataAdmins = new DataAdmins();
    }

    @Test
    public void testInicializacaoAdmins() {
        assertNotNull(dataAdmins.getAdmins());
        assertTrue(dataAdmins.getAdmins().size() >= 0);
    }

    @Test
    public void testAddAdmin() {
        Admin admin = new Admin("João", "joao@gmail.com", "12345678900", "Rua A, 123", "senha123");
        Admin addedAdmin = dataAdmins.addAdmin(admin);

        assertNotNull(addedAdmin);
        assertEquals(admin, addedAdmin);
        assertTrue(dataAdmins.getAdmins().contains(admin));
    }

    @Test
    public void testAddAdmin_Aumento() {
        int initialSize = dataAdmins.getAdmins().size();
        Admin admin = new Admin("Maria", "maria@gmail.com", "12345678901", "Rua B, 456", "senha123");

        dataAdmins.addAdmin(admin);

        assertEquals(initialSize + 1, dataAdmins.getAdmins().size());
    }

    @Test
    public void testRemoveAdmin_Sucesso() {
        Admin admin = new Admin("Carlos", "carlos@gmail.com", "12345678902", "Rua C, 789", "senha123");
        dataAdmins.addAdmin(admin);

        int adminId = dataAdmins.getAdmins().size() - 1;
        boolean result = dataAdmins.removeAdmin(adminId);

        assertTrue(result);
        assertFalse(dataAdmins.getAdmins().contains(admin));
    }

    @Test
    public void testRemoveAdmin_Falha_IdInvalido() {
        assertThrows(IndexOutOfBoundsException.class, () -> {dataAdmins.removeAdmin(999);});
    }

    @Test
    public void testGetAdmin_Valido() {
        Admin admin = new Admin("Pedro", "pedro@gmail.com", "12345678903", "Rua D, 101", "senha123");
        dataAdmins.addAdmin(admin);

        int adminId = dataAdmins.getAdmins().size() - 1;
        Admin fetchedAdmin = dataAdmins.getAdmin(adminId);

        assertNotNull(fetchedAdmin);
        assertEquals(admin, fetchedAdmin);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetAdmin_IdInvalido() {
        dataAdmins.getAdmin(999);
    }
}
