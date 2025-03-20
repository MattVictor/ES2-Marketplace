package interfaces;

import java.util.Scanner;

public class MenusCliente implements MenusMethods {

    public String desenharMenuCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("---MENU DO CLIENTE---");
        System.out.println(" Como deseja entrar? ");
        System.out.println("1 - Fazer Login");
        System.out.println("2 - Novo cadastro");
        System.out.println("3 - Deletar cadastro");
        System.out.println("4 - Voltar");

        return scanner.nextLine();
    }

    public String[] desenharMenuLoginCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--LOGIN CLIENTE--");
        System.out.println(" Digite seu CPF: ");
        String cpf = scanner.nextLine();
        System.out.println(" Digite sua senha: ");
        String senha = scanner.nextLine();

        return new String[]{cpf, senha};
    }

    public String[] desenharMenuCadastrarCliente() {
        Scanner scanner = new Scanner(System.in);

        String[] dados = {"nome","email","cpf","endereco"};
        System.out.println("--CADASTRAR CLIENTE--");

        return inputDados(dados);
    }

    public String[] desenharMenuDeletarCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--DELETAR CLIENTE--");
        System.out.println(" Digite o CPF: ");
        String cpf = scanner.nextLine();
        System.out.println(" Digite a senha: ");
        String senha = scanner.nextLine();

        return new String[]{cpf, senha};
    }

    public String desenharLojaParaCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" *Opções futuras aqui* ");
        System.out.println(" 1 - Voltar");

        return scanner.nextLine();
    }
}
