package controle;

import interfaces.Menus;
import static controle.Estados.*;

public class Controlador {

    private final AcessarDados acessarDados = new AcessarDados();
    private final Registrador registrador = new Registrador();
    private final Autenticador autenticador = new Autenticador();
    private final Menus menu = new Menus();
    private Estados estadoAtual = MENU_PRINCIPAL;

    public Estados executarMenu() {

        String resposta;
        String[] dados;
        int respostaInt;
        boolean loginValido;

        switch (estadoAtual) {

            case MENU_PRINCIPAL:
                resposta = menu.desenharMenuPrincipal();
                respostaInt = Integer.parseInt(resposta);

                estadoAtual = respostaInt == 4? estadoAtual.voltar() : estadoAtual.avancar(respostaInt-1);
                break;

            case LOGIN_ADMIN:
                dados = menu.desenharMenuLoginAdministrador();
                loginValido = autenticador.autenticarAdmin(dados[0], dados[1]);

                estadoAtual = loginValido? estadoAtual.avancar() : estadoAtual.voltar();
                break;

            case MENU_CLIENTE:
                resposta = menu.desenharMenuCliente();
                respostaInt = Integer.parseInt(resposta);

                estadoAtual = respostaInt == 4? estadoAtual.voltar(): estadoAtual.avancar(respostaInt-1);
                break;

            case MENU_LOJAS:
                resposta = menu.desenharMenuLoja();
                respostaInt = Integer.parseInt(resposta);

                estadoAtual = respostaInt == 4? estadoAtual.voltar() : estadoAtual.avancar(respostaInt-1);
                break;

            case LOGIN_CLIENTE:
                dados = menu.desenharMenuLoginCliente();
                loginValido = autenticador.autenticarCliente(dados[0], dados[1]);

                estadoAtual = loginValido? estadoAtual.avancar() : estadoAtual.voltar();
                break;

            case LOGIN_LOJAS:
                dados = menu.desenharMenuLoginLoja();
                loginValido = autenticador.autenticarLoja(dados[0], dados[1]);

                estadoAtual = loginValido? estadoAtual.avancar() : estadoAtual.voltar();
                break;

            case CADASTRO_CLIENTE:
                dados = menu.desenharMenuCadastrarCliente();
                registrador.registrarCliente(dados);
                estadoAtual = estadoAtual.voltar();
                break;

            case DELETAR_CLIENTE:
                dados = menu.desenharMenuDeletarCliente();
                registrador.deletarCliente(dados);
                estadoAtual = estadoAtual.voltar();
                break;

            case CADASTRO_LOJAS:
                dados = menu.desenharMenuCadastrarLoja();
                registrador.registrarLoja(dados);
                estadoAtual = estadoAtual.voltar();
                break;

            case DELETAR_LOJAS:
                dados = menu.desenharMenuDeletarLoja();
                registrador.deletarLoja(dados);
                estadoAtual = estadoAtual.voltar();
                break;

            case LOJA_PARA_CLIENTE:
                resposta = menu.desenharLojaParaCliente();
                respostaInt = Integer.parseInt(resposta);
                estadoAtual =  estadoAtual.voltar();
                break;

            case PAINEL_PARA_LOJA:
                resposta = menu.desenharPainelParaLoja();
                respostaInt = Integer.parseInt(resposta);
                estadoAtual =  estadoAtual.voltar();
                break;

            case MENU_ADMIN:
                resposta = menu.desenharMenuAdministrador();

                switch (resposta) {
                    case "1": acessarDados.listarAdmins(); break;
                    case "2": acessarDados.listarClientes(); break;
                    case "3": acessarDados.listarLojas(); break;
                    case "4": estadoAtual = estadoAtual.avancar(0); break;
                    case "5": estadoAtual = estadoAtual.avancar(1); break;
                    case "6": estadoAtual = estadoAtual.voltar(); break;
                }
                break;

            case CADASTRO_ADMIN:
                dados = menu.desenharMenuCadastrarAdmin();
                registrador.registrarAdmin(dados);
                estadoAtual = estadoAtual.voltar();
                break;

            case DELETAR_ADMIN:
                dados = menu.desenharMenuDeletarAdmin();
                registrador.deletarAdmin(dados);
                estadoAtual = estadoAtual.voltar();
                break;
        }

        return estadoAtual;
    }
}
