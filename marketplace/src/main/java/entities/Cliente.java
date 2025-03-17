package entities;

import abstracts.Entities;

public class Cliente extends Entities{
    public Cliente(int id, String nome, String email, String senha, String cpf, String endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.CPF = cpf;
        this.endereco = endereco;
    }
}
