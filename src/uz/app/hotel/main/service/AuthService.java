package uz.app.hotel.main.service;

import uz.app.hotel.database.DB;
import uz.app.hotel.entity.User;

public class AuthService implements uz.app.hotel.service.AuthService {

    private DB db = DB.getInstance();
    @Override
    public void signUp() {
        String name = Utils.strScanner.nextLine();
        String username = Utils.strScanner.nextLine();
        String password = Utils.strScanner.nextLine();

        User user = new User(name, username, password);
        if (db.getUsers().add(user)) {
            System.out.println("User royhatdan otdi!");
            return;
        }
        System.out.println("Username band");
    }

    @Override
    public void signIn() {

    }
}
