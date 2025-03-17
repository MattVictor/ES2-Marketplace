package entities;

import abstracts.Entities;

public class Cliente extends Entities{
    public Cliente(String nome, String email, String senha, String cpf, String endereco) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.CPF = cpf;
        this.endereco = endereco;
    }
}
