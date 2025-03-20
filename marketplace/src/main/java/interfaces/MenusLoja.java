package interfaces;

import java.util.Scanner;

public class MenusLoja implements MenusMethods {

    public String desenharMenuLoja() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("---MENU DA LOJA---");
        System.out.println(" Como deseja entrar? ");
        System.out.println("1 - Fazer Login");
        System.out.println("2 - Novo cadastro");
        System.out.println("3 - Deletar cadastro");
        System.out.println("4 - Voltar");

        return scanner.nextLine();
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

    public String[] desenharMenuCadastrarLoja() {

        String[] dados = {"nome","email","cnpj","endereco"};
        System.out.println("--CADASTRAR LOJA--");

        return inputDados(dados);
    }

    public String[] desenharMenuDeletarLoja() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--DELETAR LOJA--");
        System.out.println(" Digite o CNPJ: ");
        String cnpj = scanner.nextLine();
        System.out.println(" Digite a senha: ");
        String senha = scanner.nextLine();

        return new String[]{cnpj, senha};
    }

    public String desenharPainelParaLoja() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" *Opções futuras aqui* ");
        System.out.println(" 1 - Voltar");

        return scanner.nextLine();
    }
}
