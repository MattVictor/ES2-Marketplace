package entities;

import abstracts.Entities;

import java.util.ArrayList;

public class Loja extends Entities {
    private String CNPJ;
    private ArrayList<Produto> produtos;
    protected Loja() {}

    public Loja(String nome, String email, String senha, String CPF, String CNPJ, String endereco, ArrayList<Produto> produtos) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.CPF = CPF;
        this.CNPJ = CNPJ;
        this.endereco = endereco;
        this.produtos = produtos;
    }

    public Loja(String nome, String email, String senha, String CPF, String CNPJ, String endereco) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.CPF = CPF;
        this.CNPJ = CNPJ;
        this.endereco = endereco;
        this.produtos = new ArrayList<Produto>();
    }

    @Override
    public String toString() {
        return "{nome: "+this.nome+",\n"+
                "email: "+this.email+",\n"+
                "senha: "+this.senha+",\n"+
                "CAD:"+this.CPF+",\n"+
                "endereco: "+this.endereco+"\n"+
                "}";
    }

}
