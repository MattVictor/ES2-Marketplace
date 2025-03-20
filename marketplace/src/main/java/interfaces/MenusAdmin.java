package interfaces;

import java.util.Scanner;

public class MenusAdmin implements MenusMethods {

    public String desenharMenuAdministrador() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--MENU DO ADMINISTRADOR--");
        System.out.println(" 1 - Listar Administradores ");
        System.out.println(" 2 - Listar Clientes ");
        System.out.println(" 3 - Listar Lojas ");
        System.out.println(" 4 - Cadastrar novo administrador");
        System.out.println(" 5 - Deletar administrador");
        System.out.println(" 6 - Voltar");

        return scanner.nextLine();
    }

    public String[] desenharMenuLoginAdministrador() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--LOGIN DE ADMINISTRADOR--");
        System.out.println(" Digite seu e-mail: ");
        String email = scanner.nextLine();
        System.out.println(" Digite seu senha: ");
        String senha = scanner.nextLine();

        return new String[]{email, senha};
    }

    public String[] desenharMenuCadastrarAdmin() {
        Scanner scanner = new Scanner(System.in);

        String[] dados = {"nome","email","cpf","endereco"};
        System.out.println("--CADASTRAR ADMINISTRADOR--");

        return inputDados(dados);
    }

    public String[] desenharMenuDeletarAdmin() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--DELETAR ADMINISTRADOR--");
        System.out.println(" Digite o e-mail: ");
        String email = scanner.nextLine();
        System.out.println(" Digite a senha: ");
        String senha = scanner.nextLine();

        return new String[]{email, senha};
    }
}
