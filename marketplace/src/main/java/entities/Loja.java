package entities;

import abstracts.Entities;

public class Loja extends Entities {
    private String CNPJ;

    protected Loja() {}

    public Loja(int id, String nome, String email, String senha, String CPF, String CNPJ, String endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.CPF = CPF;
        this.CNPJ = CNPJ;
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "{nome: "+this.nome+",\n"+
                "email: "+this.email+",\n"+
                "senha: "+this.senha+",\n"+
                "CAD:"+this.CPF+",\n"+
                "endereco"+this.endereco+"\n"+
                "}";
    }

}
