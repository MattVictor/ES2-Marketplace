package interfaces;

import java.util.Scanner;

public interface MenusMethods {

    default String[] inputDados(String[] dados) {
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
