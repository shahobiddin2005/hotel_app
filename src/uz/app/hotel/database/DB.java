package uz.app.hotel.database;

import uz.app.hotel.entity.Hotel;
import uz.app.hotel.entity.Reservation;
import uz.app.hotel.entity.User;
import uz.app.hotel.service.AdminService;
import uz.app.hotel.service.HotelService;
import uz.app.hotel.service.ReservationService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DB implements HotelService, ReservationService {

    private static HashSet<User> users = new HashSet<>();
    private static ArrayList<Hotel> hotels = new ArrayList<>();
    private static ArrayList<Reservation> reservations = new ArrayList<>();

    private static DB db ;
    public static DB getInstance(){
        if (db == null)
            db=new DB();
        return db;
    }

    public static HashSet<User> getUsers() {
        return users;
    }

    @Override
    public void add(Hotel hotel) {

    }

    @Override
    public Hotel show(String id) {
        return null;
    }

    @Override
    public List<Hotel> showAll() {
        return null;
    }

    @Override
    public boolean edit(String id, Hotel hotel) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public boolean addReservation(Reservation reservation) {
        return false;
    }

    @Override
    public Reservation showReservation(String id) {
        return null;
    }

    @Override
    public List<Reservation> showReservationByUser(String id) {
        return null;
    }

    @Override
    public List<Reservation> showReservationByHotel(String id) {
        return null;
    }

    @Override
    public boolean cancelReservation(String id) {
        return false;
    }

    @Override
    public boolean finishReservation(String id, LocalDate date) {
        return false;
    }

    @Override
    public boolean rescheduleReservation(String id, LocalDate from, LocalDate to) {
        return false;
    }
}
