package entities;

public class MarketPlace {
    private Loja lojaPrincipal = new Loja();

    public Loja criarLoja (String nome, String email, String senha, String CPF, String CNPJ, String endereco) {
        return new Loja(nome, email, senha, CPF, CNPJ, endereco);
    }

    public void cadastrarLoja (Loja loja) {
        lojaPrincipal.cadastrarLoja(loja);
    }

    public void exibirLoja (Loja loja) {
        lojaPrincipal.exibirLoja(loja);
    }

    public void buscarLoja (String nome) {
        lojaPrincipal.buscarLoja(nome);
    }

    public void removerLoja (String nome) {
        lojaPrincipal.removerLoja(nome);
    }

    public void listarLojas () {
        lojaPrincipal.listarLojas();
    }
}
