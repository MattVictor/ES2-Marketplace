package DataBase;

import entities.Admin;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DataAdminsTest {

    private DataAdmins dataAdmins;

    @Before
    public void setUp() {
        dataAdmins = new DataAdmins();

        Admin admin1 = new Admin("adminTest", "admin@gmail.com", "senha123", "12345678900", "Rua Tal");
        Admin admin2 = new Admin("adminTest2", "admin2@gmail.com", "senha123", "98765432100", "Rua Teste");

        dataAdmins.getAdmins().add(admin1);
        dataAdmins.getAdmins().add(admin2);
    }

    @Test
    public void testAddAdmin() {
        Admin newAdmin = new Admin("admin3", "admin3@gmail.com", "senha123", "12312312300", "Rua Nova");

        // Adicionando o Admin
        Admin addedAdmin = dataAdmins.addAdmin(newAdmin);

        assertNotNull(addedAdmin);
        assertEquals("admin3", addedAdmin.getNome());
        assertEquals("admin3@gmail.com", addedAdmin.getEmail());
        assertEquals(3, dataAdmins.getAdmins().size());
    }

    @Test
    public void testRemoveAdmin() {
        Admin removedAdmin = dataAdmins.removeAdmin(0);

        assertNotNull(removedAdmin);
        assertEquals("adminTest", removedAdmin.getNome());
        assertEquals(1, dataAdmins.getAdmins().size());
    }

    @Test
    public void testGetAdmins() {
        ArrayList<Admin> admins = dataAdmins.getAdmins();

        assertNotNull(admins);
        assertEquals(2, admins.size());
    }

    @Test
    public void testGetAdmin() {
        Admin admin = dataAdmins.getAdmin(1);

        assertNotNull(admin);
        assertEquals("adminTest2", admin.getNome());
        assertEquals("admin2@gmail.com", admin.getEmail());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetAdmin_IndiceInvalido() {
        dataAdmins.getAdmin(10);  // Deve lançar IndexOutOfBoundsException
    }
}
