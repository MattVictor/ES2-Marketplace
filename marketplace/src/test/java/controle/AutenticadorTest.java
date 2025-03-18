package controle;

import entities.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AutenticadorTest {

    Registrador registrador;
    Autenticador autenticador;

    @Before
    public void setUp() {
        registrador = new Registrador();

        String[] admin = {"adminTest", "admin@gmail.com", "senha123", "12345678900", "rua tal"};
        String[] cliente = {"clienteTest", "cliente@gmail.com", "senha123", "12345678900", "Rua das ruas"};
        String[] loja = {"lojaTest", "teste@gmail.com", "12345678000195", "Rua das lojas amarelas", "senha123"};

        registrador.registrarAdmin(admin);
        registrador.registrarCliente(cliente);
        registrador.registrarLoja(loja);
    }

    @Test
    public void autenticarAdmin_Sucesso() {
        boolean resultado = autenticador.autenticarAdmin("admin@gmail.com", "senha123");
        assertTrue(resultado);
    }

    @Test
    public void autenticarAdmin_FalhaEmail() {
        boolean resultado = autenticador.autenticarAdmin("emailInvalido@example.com", "senha123");
        assertFalse(resultado);
    }

    @Test
    public void autenticarAdmin_FalhaSenha() {
        boolean resultado = autenticador.autenticarAdmin("admin@gmail.com", "senhaErrada");
        assertFalse(resultado);
    }

    @Test
    public void autenticarCliente_Sucesso() {
        boolean resultado = autenticador.autenticarCliente("12345678900", "senha123");
        assertTrue(resultado);
    }

    @Test
    public void autenticarCliente_FalhaCPF() {
        boolean resultado = autenticador.autenticarCliente("00000000000", "senha123");
        assertFalse(resultado);
    }

    @Test
    public void autenticarCliente_FalhaSenha() {
        boolean resultado = autenticador.autenticarCliente("12345678900", "senhaErrada");
        assertFalse(resultado);
    }

    @Test
    public void autenticarLoja_Sucesso() {
        boolean resultado = autenticador.autenticarLoja("12345678000195", "senha123");
        assertTrue(resultado);
    }

    @Test
    public void autenticarLoja_FalhaCNPJ() {
        boolean resultado = autenticador.autenticarLoja("98765432000100", "senha123");
        assertFalse(resultado);
    }

    @Test
    public void autenticarLoja_FalhaSenha() {
        boolean resultado = autenticador.autenticarLoja("12345678000195", "senhaErrada");
        assertFalse(resultado);
    }
}
