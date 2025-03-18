package controle;

import interfaces.Menus;
import static controle.Estados.*;

public class Controlador {

    private final Registrador registrador = new Registrador();
    private final Autenticador autenticador = new Autenticador(registrador);
    private final Menus menu = new Menus();
    private Estados estadoAtual = MENU_PRINCIPAL;

    public Estados executarMenu() {

        if (estadoAtual.equals(MENU_PRINCIPAL)) {
            String resposta = menu.desenharMenuPrincipal();
            int respostaInt = Integer.parseInt(resposta);

            estadoAtual = respostaInt == 4? estadoAtual.voltar() : estadoAtual.avancar(respostaInt-1);
        }

        else if (estadoAtual.equals(LOGIN_ADMIN)) {
            String[] resposta = menu.desenharMenuLoginAdministrador();
            boolean loginValido = autenticador.autenticarAdmin(resposta[0], resposta[1]);

            estadoAtual = loginValido? estadoAtual.avancar() : estadoAtual.voltar();
        }

        else if (estadoAtual.equals(MENU_CLIENTE)) {
            String resposta = menu.desenharMenuCliente();
            int respostaInt = Integer.parseInt(resposta);

            estadoAtual = respostaInt == 3? estadoAtual.voltar(): estadoAtual.avancar(respostaInt-1);
        }

        else if (estadoAtual.equals(MENU_LOJAS)) {
            String resposta = menu.desenharMenuLoja();
            int respostaInt = Integer.parseInt(resposta);

            estadoAtual = respostaInt == 3? estadoAtual.voltar() : estadoAtual.avancar(respostaInt-1);
        }

        else if (estadoAtual.equals(LOGIN_CLIENTE)) {
            String[] resposta = menu.desenharMenuLoginCliente();
            boolean loginValido = autenticador.autenticarCliente(resposta[0], resposta[1]);

            estadoAtual = loginValido? estadoAtual.avancar() : estadoAtual.voltar();
        }

        else if (estadoAtual.equals(LOGIN_LOJAS)) {
            String[] resposta = menu.desenharMenuLoginLoja();
            boolean loginValido = autenticador.autenticarLoja(resposta[0], resposta[1]);

            estadoAtual = loginValido? estadoAtual.avancar() : estadoAtual.voltar();
        }

        else if (estadoAtual.equals(CADASTRO_CLIENTE)) {
            String[] resposta = menu.desenharMenuCadastrarCliente();
            registrador.registrarCliente(resposta);

            estadoAtual = estadoAtual.voltar();
        }

        else if (estadoAtual.equals(CADASTRO_LOJAS)) {
            String[] resposta = menu.desenharMenuCadastrarLoja();
            registrador.registrarLoja(resposta);

            estadoAtual = estadoAtual.voltar();
        }

        else if (estadoAtual.equals(LOJA_PARA_CLIENTE)) {
            String resposta = menu.desenharLojaParaCliente();
            int respostaInt = Integer.parseInt(resposta);

            estadoAtual =  estadoAtual.voltar();
        }

        else if (estadoAtual.equals(PAINEL_PARA_LOJA)) {
            String resposta = menu.desenharPainelParaLoja();
            int respostaInt = Integer.parseInt(resposta);

            estadoAtual =  estadoAtual.voltar();
        }

        return estadoAtual;
    }
}
