package uz.app.hotel.main.service;

import java.util.Scanner;

public class Utils {
    private static Scanner scanner = new Scanner(System.in);
    public static Scanner strScanner = new Scanner(System.in);

    public static Integer getInt(String message){
        try {
            System.out.println(message);
            return scanner.nextInt();
        }catch (Exception e){
            scanner.nextLine();
            return getInt(message);
        }
    }
    public static Double getDouble(String message){
        try {
            System.out.println(message);
            return scanner.nextDouble();
        }catch (Exception e){
            scanner.nextLine();
            return getDouble(message);
        }
    }
}
