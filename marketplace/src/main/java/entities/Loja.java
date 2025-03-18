package entities;

import abstracts.Entities;

import java.util.ArrayList;

public class Loja extends Entities {
    private String CNPJ;
    private ArrayList<Produto> produtos;
    protected Loja() {}

    public Loja(String nome, String email, String CNPJ, String endereco, String senha, ArrayList<Produto> produtos) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.CNPJ = CNPJ;
        this.endereco = endereco;
        this.produtos = produtos;
    }

    public Loja(String nome, String email, String CNPJ, String endereco, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.CNPJ = CNPJ;
        this.endereco = endereco;
        this.produtos = new ArrayList<Produto>();
    }

    public Loja(String[] dados, ArrayList<Produto> produtos) {
        this.nome = dados[0];
        this.email = dados[1];
        this.CNPJ = dados[2];
        this.endereco = dados[3];
        this.senha = dados[4];
        this.produtos = produtos;
    }

    public Loja(String[] dados) {
        this.nome = dados[0];
        this.email = dados[1];
        this.CNPJ = dados[2];
        this.endereco = dados[3];
        this.senha = dados[4];
        this.produtos = new ArrayList<Produto>();
    }

    @Override
    public String toString() {
        return "{nome: "+this.nome+",\n"+
                "email: "+this.email+",\n"+
                "senha: "+this.senha+",\n"+
                "CNPJ:"+this.CNPJ+",\n"+
                "endereco: "+this.endereco+"\n"+
                "}";
    }

    public String getCNPJ() {
        return CNPJ;
    }
}
