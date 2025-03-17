package DataBase;

import entities.Loja;

import java.util.ArrayList;

public class DataLojas {
    DataBaseManager data;
    ArrayList<Loja> lojas;

    public DataLojas() {
        data = new DataBaseManager("lojas", Loja.class);
        lojas = new ArrayList<>();
        Object[] obj = data.parseData();

        for (int i = 0; i < obj.length; i++) {
            if (obj[i] instanceof Loja) {
                lojas.add((Loja) obj[i]);
            }
        }
    }

    public ArrayList<Loja> getLojas() {
        return lojas;
    }

    public Loja getLoja(int id) {
        return lojas.get(id);
    }

    public void addLoja(Loja admin) {
        lojas.add(admin);
        data.writeData(lojas.toArray());
    }

    public void removeLoja(int id) {
        lojas.remove(id);
        data.writeData(lojas.toArray());
    }
}