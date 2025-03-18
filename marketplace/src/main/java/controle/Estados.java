package controle;
import java.util.EnumMap;
import java.util.Map;

public enum Estados {
    SAIR,
    MENU_PRINCIPAL,
    LOGIN_ADMIN,
    MENU_ADMIN,
    MENU_CLIENTE,
    LOGIN_CLIENTE,
    CADASTRO_CLIENTE,
    MENU_LOJAS,
    LOGIN_LOJAS,
    CADASTRO_LOJAS,
    LOJA_PARA_CLIENTE,
    PAINEL_PARA_LOJA;

    // Define o próximo estado para avançar
    private static final Map<Estados, Estados[]> estadoProximo = new EnumMap<>(Map.of(
            MENU_PRINCIPAL, new Estados[]{LOGIN_ADMIN, MENU_CLIENTE, MENU_LOJAS},
            MENU_CLIENTE, new Estados[]{LOGIN_CLIENTE, CADASTRO_CLIENTE},
            MENU_LOJAS, new Estados[]{LOGIN_LOJAS, CADASTRO_LOJAS}
    ));

    private static final Map<Estados, Estados> estadoProximoUnico = new EnumMap<>(Map.of(
            LOGIN_ADMIN, MENU_ADMIN,
            LOGIN_LOJAS, PAINEL_PARA_LOJA,
            LOGIN_CLIENTE, LOJA_PARA_CLIENTE
    ));

    // Define o estado anterior para voltar
    private static final Map<Estados, Estados> estadoAnterior = new EnumMap<>(Map.ofEntries(
            Map.entry(MENU_PRINCIPAL, SAIR),
            Map.entry(LOGIN_ADMIN, MENU_PRINCIPAL),
            Map.entry(MENU_CLIENTE, MENU_PRINCIPAL),
            Map.entry(LOGIN_CLIENTE, MENU_CLIENTE),
            Map.entry(CADASTRO_CLIENTE, MENU_CLIENTE),
            Map.entry(MENU_LOJAS, MENU_PRINCIPAL),
            Map.entry(LOGIN_LOJAS, MENU_LOJAS),
            Map.entry(CADASTRO_LOJAS, MENU_LOJAS),
            Map.entry(MENU_ADMIN, MENU_PRINCIPAL),
            Map.entry(PAINEL_PARA_LOJA, LOGIN_LOJAS),
            Map.entry(LOJA_PARA_CLIENTE, LOGIN_CLIENTE)
    ));

    public Estados avancar(int opcao) {
        if (!estadoProximo.containsKey(this)) {
            throw new IllegalStateException("Não é possível avançar a partir de " + this);
        }
        return estadoProximo.get(this)[opcao];
    }

    public Estados avancar() {
        if (!estadoProximoUnico.containsKey(this)) {
            throw new IllegalStateException("Não é possível avançar a partir de " + this);
        }
        return estadoProximoUnico.get(this);
    }

    public Estados voltar() {
        if (!estadoAnterior.containsKey(this)) {
            throw new IllegalStateException("Não é possível voltar a partir de " + this);
        }
        return estadoAnterior.get(this);
    }
}
