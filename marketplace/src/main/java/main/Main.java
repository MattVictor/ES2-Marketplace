package main;

import abstracts.Entities;
import entities.Loja;
import entities.MarketPlace;

public class Main {
    public static void main(String[] args) {
        MarketPlace marketPlace = new MarketPlace();

        Loja loja1 = marketPlace.criarLoja("Loja A", "lojaA@gmail.com", "senha123", "111.111.111-11", "12345678900001", "Av. Principal, 123");
        Loja loja2 = marketPlace.criarLoja("Loja B", "lojaB@hotmail.com", "senha456", "222.222.222-22", "98765432100001", "Rua Central, 456");
        Loja loja3 = marketPlace.criarLoja("Loja C", "lojaC@yahoo.com", "senha789", "333.333.333-33", "56789012300001", "Travessa X, 789");

        marketPlace.cadastrarLoja(loja1);
        marketPlace.cadastrarLoja(loja2);
        marketPlace.cadastrarLoja(loja3);

        marketPlace.exibirLoja(loja1);

        marketPlace.buscarLoja("Loja B");

        marketPlace.listarLojas();

        marketPlace.removerLoja("Loja C");

        marketPlace.listarLojas();
    }
}