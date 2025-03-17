package entities;

public class Produto {
    private String nome;
    private String marca;
    private String tipo;
    private String descricao;
    private String valor;
    private int quantidade;

    public Produto(String nome, String marca, String tipo, String descricao, String valor, int quantidade) {
        this.nome = nome;
        this.marca = marca;
        this.tipo = tipo;
        this.descricao = descricao;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public Produto(String nome, String marca, String tipo, String descricao, String valor) {
        this.nome = nome;
        this.marca = marca;
        this.tipo = tipo;
        this.descricao = descricao;
        this.valor = valor;
        this.quantidade = 0;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
