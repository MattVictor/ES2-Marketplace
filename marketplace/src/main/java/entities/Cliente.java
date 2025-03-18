package entities;

import abstracts.Entities;

public class Cliente extends Entities{

    private String CPF;

    public Cliente(String nome, String email, String senha, String cpf, String endereco) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.CPF = cpf;
        this.endereco = endereco;
    }

    public Cliente(String[] dados) {
        this.nome = dados[0];
        this.email = dados[1];
        this.CPF = dados[2];
        this.endereco = dados[3];
        this.senha = dados[4];
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
}
