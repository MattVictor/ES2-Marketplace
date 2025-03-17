package DataBase;

import entities.Admin;

import java.util.ArrayList;

public class DataAdmins {
    DataBaseManager data;
    ArrayList<Admin> admins;

    public DataAdmins() {
        data = new DataBaseManager("admins", Admin.class);
        admins = new ArrayList<>();
        Object[] obj = data.parseData();

        for (int i = 0; i < obj.length; i++) {
            if (obj[i] instanceof Admin) {
                admins.add((Admin) obj[i]);
            }
        }
    }

    public ArrayList<Admin> getAdmins() {
        return admins;
    }

    public Admin getAdmin(int id) {
        return admins.get(id);
    }

    public void addAdmin(Admin admin) {
        admins.add(admin);
        data.writeData(admins.toArray());
    }

    public void removeAdmin(int id) {
        admins.remove(id);
        data.writeData(admins.toArray());
    }
}
