package uz.app.hotel.main;

import uz.app.hotel.main.service.AuthService;
import uz.app.hotel.main.service.Utils;

public class Main {
    static AuthService authService = new AuthService();
    public static void main(String[] args) {
        while (true){
            switch (Utils.getInt("""
                    0 -> Exit 
                    1 -> Sign in 
                    2 -> Sign up
                    """)){
                case 0 -> {
                    System.out.println("See you later!");
                    return;
                }
                case 1 -> {
                    authService.signIn();
                }
                case 2 -> {
                    authService.signUp();
                }
            }
        }
    }
}
