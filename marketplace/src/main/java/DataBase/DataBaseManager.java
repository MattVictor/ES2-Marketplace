package DataBase;

import com.google.gson.*;
import org.apache.commons.io.IOUtils;
import java.io.*;

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

    public JsonElement parseData(){
        String content = new String();

        try {
            content = IOUtils.toString(new FileReader("marketplace/src/main/java/DataBase/"+dataBase+".json"));
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        JsonArray jsonObject = this.gson.fromJson(content, JsonArray.class);


        return jsonObject;
    }

    public void writeData(JsonArray arr) {
        try (Writer writer = new FileWriter("marketplace/src/main/java/DataBase/"+dataBase+".json")) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(arr, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Object getData(int id){
        JsonArray jsonArray = parseData().getAsJsonArray();

        for(JsonElement jsonElement : jsonArray){
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            if(id == jsonObject.get("id").getAsInt()){
                return jsonObject;
            }
        }

        return null;
    }

    public boolean insertData(Object obj){
        JsonArray jsonArray = parseData().getAsJsonArray();

        String teste = gson.toJson(obj,c);

        JsonObject o = JsonParser.parseString(teste).getAsJsonObject();

        jsonArray.add(o);

        writeData(jsonArray);

        return true;
    }

    public boolean changeData(int id, Object obj) {
        JsonArray jsonArray = parseData().getAsJsonArray();

        for(JsonElement jsonElement : jsonArray){
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            if(id == jsonObject.get("id").getAsInt()){
                jsonArray.remove(jsonObject);
                String teste = gson.toJson(obj,c);

                JsonObject o = JsonParser.parseString(teste).getAsJsonObject();

                jsonArray.add(o);
                break;
            }
        }

        writeData(jsonArray);

        return true;
    }

    public boolean deleteData(int id){
        JsonArray jsonArray = parseData().getAsJsonArray();

        for(JsonElement jsonElement : jsonArray){
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            if(id == jsonObject.get("id").getAsInt()){
                jsonArray.remove(jsonObject);
                break;
            }
        }

        writeData(jsonArray);

        return true;
    }

    public int getDataBaseSize(){
        return parseData().getAsJsonArray().size();
    }
}
