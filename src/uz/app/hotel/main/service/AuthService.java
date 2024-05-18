package uz.app.hotel.main.service;

import uz.app.hotel.database.DB;
import uz.app.hotel.entity.User;

import java.util.Objects;
import java.util.Optional;

public class AuthService implements uz.app.hotel.service.AuthService {

    private DB db = DB.getInstance();
    private UserServise userService = new UserServise();
    private AdminService adminService = new AdminService();
    @Override
    public void signUp() {
        System.out.println("Enret name: ");
        String name = Utils.strScanner.nextLine();
        System.out.println("Enret username: ");
        String username = Utils.strScanner.nextLine();
        System.out.println("Enret password: ");
        String password = Utils.strScanner.nextLine();

        User user = new User(name, username, password);
        if (db.getUsers().add(user)) {
            System.out.println("User royhatdan otdi!");
            userService.service(user);
            return;
        }
        System.out.println("Username band");
    }

    @Override
    public void signIn() {
        System.out.println("Enret username: ");
        String username = Utils.strScanner.nextLine();
        System.out.println("Enret password: ");
        String password = Utils.strScanner.nextLine();

        if (Objects.equals("admin", username) && Objects.equals("admin", password)){
            adminService.service();
            return;
        }
        for (User user : db.getUsers()) {
            if (Objects.equals(user.getUsername(), username) && Objects.equals(user.getPassword(), password)){
                userService.service(user);
                return;
            }
        }
        System.out.println("User not found");
    }
}
