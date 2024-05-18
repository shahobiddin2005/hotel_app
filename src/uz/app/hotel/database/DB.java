package uz.app.hotel.database;

import uz.app.hotel.entity.Hotel;
import uz.app.hotel.entity.Reservation;
import uz.app.hotel.entity.User;
import uz.app.hotel.service.HotelService;
import uz.app.hotel.service.ReservationService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DB implements HotelService, ReservationService {

    private HashSet<User> users = new HashSet<>();
    private ArrayList<Hotel> hotels = new ArrayList<>();
    private ArrayList<Reservation> reservations = new ArrayList<>();

    private static DB db ;
    public static DB getInstance(){
        if (db == null)
            db=new DB();
        return db;
    }

    public HashSet<User> getUsers() {
        return users;
    }

    @Override
    public void add(Hotel hotel) {
        if (hotels.add(hotel)) {
            System.out.println("Bajarildi");
        }else{
            System.out.println("Qandaydir muammo sodir buldi");
        }
    }

    @Override
    public Hotel show(String id) {
        for (Hotel hotel : hotels) {
            if(hotel.getId().equals(id)){
                return hotel;
            }
        }
        return null;
    }

    @Override
    public List<Hotel> showAll() {
        return hotels;
    }

    @Override
    public boolean edit(String id, Hotel hotel) {
        Hotel show = show(id);
        if (show==null){
            return false;
        }
        show.setFloors(hotel.getFloors());
        show.setName(hotel.getName());
        show.setLocation(hotel.getLocation());
        show.setRoomsCount(hotel.getRoomsCount());
        return true;
    }

    @Override
    public boolean delete(String id) {
        Hotel show = show(id);
        return hotels.remove(show);

    }

    @Override
    public boolean addReservation(Reservation reservation) {
        return reservations.add(reservation);
    }

    @Override
    public Reservation showReservation(String id) {
        for (Reservation reservation : reservations) {
           if(reservation.getId().equals(id)){
               return reservation;
           }
        }
        return null;
    }

    @Override
    public List<Reservation> showReservationByUser(String id) {
        ArrayList<Reservation> d=new ArrayList<>();
        for (Reservation reservation : reservations) {
            if(reservation.getUser().getId().equals(id)){
                d.add(reservation);
            }
        }
        return d;
    }

    @Override
    public List<Reservation> showReservationByHotel(String id) {
        ArrayList<Reservation> d=new ArrayList<>();
        for (Reservation reservation : reservations) {
            if(reservation.getHotel().getId().equals(id)){
                d.add(reservation);
            }
        }
        return d;
    }

    @Override
    public boolean cancelReservation(String id) {
        Reservation reservation = showReservation(id);
        if (reservation==null){
            return false;
        }
        reservation.setEarlierFinished(true);
        return true;
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
