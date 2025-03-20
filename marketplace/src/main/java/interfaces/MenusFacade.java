package interfaces;

import java.util.Scanner;

public class MenusFacade {

    MenusAdmin menusAdmin = new MenusAdmin();
    MenusCliente menusCliente = new MenusCliente();
    MenusLoja menusLoja = new MenusLoja();

    public String desenharMenuPrincipal() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--MARKETPLACE MENU--");
        System.out.println(" Qual o seu perfil? ");
        System.out.println("1 - Administrador");
        System.out.println("2 - Cliente");
        System.out.println("3 - Loja");
        System.out.println("4 - Sair");

        return scanner.nextLine();
    }

    public String desenharMenuAdmin() {
        return menusAdmin.desenharMenuAdministrador();
    }

    public String[] desenharMenuLoginAdmin() {
        return menusAdmin.desenharMenuLoginAdministrador();
    }

    public String[] desenharMenuCadastrarAdmin() {
        return menusAdmin.desenharMenuCadastrarAdmin();
    }

    public String[] desenharMenuDeletarAdmin() {
        return menusAdmin.desenharMenuDeletarAdmin();
    }

    public String desenharMenuCliente() {
        return menusCliente.desenharMenuCliente();
    }

    public String[] desenharMenuLoginCliente() {
        return menusCliente.desenharMenuLoginCliente();
    }

    public String[] desenharMenuCadastrarCliente() {
        return menusCliente.desenharMenuCadastrarCliente();
    }

    public String[] desenharMenuDeletarCliente() {
        return menusCliente.desenharMenuDeletarCliente();
    }

    public String desenharLojaParaCliente() {
        return menusCliente.desenharLojaParaCliente();
    }

    public String desenharMenuLoja() {
        return menusLoja.desenharMenuLoja();
    }

    public String[] desenharMenuLoginLoja() {
        return menusLoja.desenharMenuLoginLoja();
    }

    public String[] desenharMenuCadastrarLoja() {
        return menusLoja.desenharMenuCadastrarLoja();
    }

    public String[] desenharMenuDeletarLoja() {
        return menusLoja.desenharMenuDeletarLoja();
    }

    public String desenharPainelParaLoja() {
        return menusLoja.desenharPainelParaLoja();
    }
}
