package DataBase;

import com.google.gson.*;
import org.apache.commons.io.IOUtils;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DataBaseManager {
    String dataBase;
    Class c;
    Gson gson;

    public DataBaseManager(String archive, Class c) {
        // dataBase = nome do arquivo que guarda os dados | c = classe que representa os objetos daquele arquivo (usar .class para o parametro)
        this.dataBase = archive;
        this.c = c;
        gson = new Gson();
    }

    public Object[] parseData(){
        String content = new String();
        JsonArray jsonArray;

        String path = getJsonPath(dataBase);

        try {
            FileReader fileReader = new FileReader(path);
            content = IOUtils.toString(fileReader);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            jsonArray = this.gson.fromJson(content, JsonArray.class);
        }

        Object[] objects = new Object[jsonArray.size()];

        for (int i = 0; i < jsonArray.size(); i++) {
            objects[i] = gson.fromJson(jsonArray.get(i), c);
        }

        return objects;
    }

    public void writeData(Object[] arr) {
        JsonArray jsonArray = new JsonArray();
        for (int i = 0; i < arr.length; i++) {
            jsonArray.add(gson.toJson(arr[i],c));
        }

        String path = getJsonPath(dataBase);

        try (Writer writer = new FileWriter(path)) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(arr, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getJsonPath(String jsonName) {
        String basePath = System.getProperty("user.dir");
        String relativePath = "src/main/java/DataBase/Data/"+jsonName+".json";

        // Se estiver rodando do repositório root (exemplo: marketplace/)
        File file = new File(basePath, relativePath);
        if (!file.exists()) {

            // Se não existir, tenta remover o prefixo "marketplace/"
            relativePath = "marketplace/" + relativePath;
            file = new File(basePath, relativePath);
        }

        return file.getAbsolutePath();
    }
}
