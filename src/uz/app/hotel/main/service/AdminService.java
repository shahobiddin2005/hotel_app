package uz.app.hotel.main.service;

import uz.app.hotel.database.DB;
import uz.app.hotel.entity.Hotel;
import uz.app.hotel.entity.Location;
import uz.app.hotel.entity.Reservation;
import uz.app.hotel.entity.User;

public class AdminService implements uz.app.hotel.service.AdminService {

    private DB db = DB.getInstance();

    @Override
    public void service() {
        while (true){
            switch (Utils.getInt("""
                    0 -> Exit 
                    1 -> Add hotel 
                    2 -> Show hotels 
                    3 -> Edit hotel 
                    4 -> Delete hotel 
                    5 -> Show users 
                    6 -> showReservationHistory
                    7 -> calcelReservation
                    8 -> reserveForUser
                    
                    """)){
                case 0 -> {
                    return;
                }
                case 1 -> {
                   addHotel();
                }
                case 2 -> {
                    showHotels();
                }
                case 3 -> {
                    editHotel();
                }
                case 4 -> {
                    deleteHotel();
                }
                case 5 -> {
                    showUsers();
                }
                case 6 -> {
                    showReservationHistory();
                }
                case 7 -> {
                    calcelReservation();
                }
                case 8 -> {reserveForUser();}
            }
        }
    }

    @Override
    public void addHotel() {
        System.out.println("Enter Hotel name: ");
        String name = Utils.strScanner.nextLine();
        Integer floor = Utils.getInt("Enter hotel floor:");
        Integer roomCount = Utils.getInt("Enter Room Count:");

        Hotel hotel = new Hotel(name, Location.TASHKENT, floor, roomCount);
        db.add(hotel);
    }

    @Override
    public void showHotel() {

    }

    @Override
    public void showHotels() {
        for (Hotel hotel : db.showAll()) {
            System.out.println(hotel);
        }
    }

    @Override
    public void editHotel() {
        showHotels();
        System.out.println("Enter id:");
        String id = Utils.strScanner.nextLine();
        System.out.println("Enter Hotel name: ");
        String name = Utils.strScanner.nextLine();
        Integer floor = Utils.getInt("Enter hotel floor:");
        Integer roomCount = Utils.getInt("Enter Room Count:");

        Hotel hotel = new Hotel(name, Location.TASHKENT, floor, roomCount);
        if (db.edit(id, hotel)) {
            System.out.println("Hotel edited!");
            return;
        }
        System.out.println("Hotel was not found!");
    }

    @Override
    public void deleteHotel() {
        showHotels();
        System.out.println("Enter id:");
        String id = Utils.strScanner.nextLine();
        if (db.delete(id)) {
            System.out.println("Hotel deleted!");
            return;
        }
        System.out.println("Hotel was not found!");
    }

    @Override
    public void showUsers() {
        for (User user : db.getUsers()) {
            System.out.println(user);
        }
    }

    @Override
    public void showReservationHistory() {
        for (Hotel hotel : db.showAll()) {
            for (Reservation reservation : db.showReservationByHotel(hotel.getId())) {
                System.out.println(reservation);
            }
        }
    }

    @Override
    public void calcelReservation() {

    }

    @Override
    public void reserveForUser() {
        for (User user : db.getUsers()) {
            for (Reservation reservation : db.showReservationByUser(user.getId())) {
                System.out.println(reservation);
            }
        }
    }
}
