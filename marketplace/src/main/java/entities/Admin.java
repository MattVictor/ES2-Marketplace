package entities;

import abstracts.Entities;

public class Admin extends Entities {

    private String CPF;

    public Admin (String nome, String email, String cpf, String endereco, String senha) {
        this.nome = nome;
        this.email = email;
        this.CPF = cpf;
        this.endereco = endereco;
        this.senha = senha;
    }

    public Admin (String[] dados) {
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

    public String[] getDados() {
        String[] dados = {this.nome, this.email, this.CPF, this.endereco, this.senha};
        return dados;
    }
}
