package interfaces;

import java.util.Scanner;

public class Menus {
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

    public String desenharMenuAdministrador() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--MENU DO ADMINISTRADOR--");
        System.out.println(" *Opções futuras aqui* ");
        System.out.println(" 1 - Voltar");

        return scanner.nextLine();
    }

    public String desenharLojaParaCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" *Opções futuras aqui* ");
        System.out.println(" 1 - Voltar");

        return scanner.nextLine();
    }

    public String desenharPainelParaLoja() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" *Opções futuras aqui* ");
        System.out.println(" 1 - Voltar");

        return scanner.nextLine();
    }

    public String desenharMenuCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("---MENU DO CLIENTE---");
        System.out.println(" Como deseja entrar? ");
        System.out.println("1 - Fazer Login");
        System.out.println("2 - Novo cadastro");
        System.out.println("3 - Voltar");

        return scanner.nextLine();
    }

    public String desenharMenuLoja() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("---MENU DA LOJA---");
        System.out.println(" Como deseja entrar? ");
        System.out.println("1 - Fazer Login");
        System.out.println("2 - Novo cadastro");
        System.out.println("3 - Voltar");

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

    public String[] desenharMenuLoginCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--LOGIN CLIENTE--");
        System.out.println(" Digite seu CPF: ");
        String cpf = scanner.nextLine();
        System.out.println(" Digite sua senha: ");
        String senha = scanner.nextLine();

        return new String[]{cpf, senha};
    }

    public String[] desenharMenuLoginLoja() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--LOGIN LOJA--");
        System.out.println(" Digite seu CNPJ: ");
        String cnpj = scanner.nextLine();
        System.out.println(" Digite sua senha: ");
        String senha = scanner.nextLine();

        return new String[]{cnpj, senha};
    }

    public String[] desenharMenuCadastrarCliente() {
        Scanner scanner = new Scanner(System.in);

        String[] dados = {"nome","email","cpf","endereco"};
        System.out.println("--CADASTRAR CLIENTE--");

        return inputDados(dados);
    }

    public String[] desenharMenuCadastrarLoja() {

        String[] dados = {"nome","email","cnpj","endereco"};
        System.out.println("--CADASTRAR LOJA--");

        return inputDados(dados);
    }

    private String[] inputDados(String[] dados) {
        Scanner scanner = new Scanner(System.in);

        String[] dadosCadastrados = new String[dados.length + 1];

        for (int i = 0; i < dados.length; i++) {
            System.out.println(" Digite seu " + dados[i] + ": ");
            dadosCadastrados[i] = scanner.nextLine();
        }
        System.out.println(" Digite sua senha: ");
        dadosCadastrados[dados.length] = scanner.nextLine();

        return dadosCadastrados;
    }
}
