package entities;

import abstracts.Entities;

import java.util.ArrayList;
import java.util.Objects;

public class Loja extends Entities {
    private String CNPJ;
    private ArrayList<Loja> lojas = new ArrayList<>();

    protected Loja() {}

    public Loja(String nome, String email, String senha, String CPF, String CNPJ, String endereco) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.CPF = CPF;
        this.CNPJ = CNPJ;
        this.endereco = endereco;
    }

    public Loja cadastrarLoja (Loja newLoja) {
        lojas.add(newLoja);

        return newLoja;
    }

    public void exibirLoja (Loja loja) {
        System.out.println("O nome da loja é: " + loja.nome);
    }

    public Loja buscarLoja (String nome) {
        for (Loja loja : lojas) {
            if (Objects.equals(loja.nome, nome)) {
                return loja;
            }
        }

        System.out.println("Nenhuma loja com o nome " + nome + "foi encontrada!");
        return null;
    }

    public Loja removerLoja (String nome) {
        for (Loja loja : lojas) {
            if (Objects.equals(loja.nome, nome)) {
                lojas.remove(loja);
                return loja;
            }
        }

        System.out.println("Nenhuma loja com o nome " + nome + "foi encontrada!");
        return null;
    }

    public void listarLojas () {
        for (Loja loja : lojas) {
            System.out.println(loja.nome);
        }
    }
}
