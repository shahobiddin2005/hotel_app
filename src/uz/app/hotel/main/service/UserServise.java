package uz.app.hotel.main.service;

import uz.app.hotel.database.DB;
import uz.app.hotel.entity.Hotel;
import uz.app.hotel.entity.Reservation;
import uz.app.hotel.entity.User;
import uz.app.hotel.service.UserService;

import java.time.LocalDate;

public class UserServise implements UserService {
    private User currentUser;
    private DB db= DB.getInstance();
    @Override
    public void service(User user) {
        currentUser=user;
        while (true){
            switch (Utils.getInt("""
                    0 Exit
                    1 Show hotels
                    2 Show reservations
                    3 Add reservation
                    4 Cancle reservation
                    5 Reschedule reservation
                    6 Show history
                    """)){
                case 0->{
                    System.out.println("See you soon "+currentUser.getUsername());
                    currentUser=null;
                    return;
                }
                case 1->{
                    showHotels();
                }
                case 2->{
                    showReservations();
                }
                case 3->{
                    reserve();
                }
                case 4->{
                    cancelReservation();
                }
                case 5->{
                    rescheduleReservation();
                }
                case 6->{
                    showHistory();
                }
            }
        }
    }

    @Override
    public void showHotels() {
        for (Hotel hotel : db.showAll()) {
            System.out.println(hotel);
        }
    }

    @Override
    public void showReservations() {
        for (Hotel hotel : db.showAll()) {
            for (Reservation reservation : db.showReservationByHotel(hotel.getId())) {
                if (reservation.getStartDate().isBefore(LocalDate.now())) {
                    System.out.println(reservation);
                }
            }
        }
    }

    @Override
    public void reserve() {
        showHotels();
        System.out.println("Enter hotel id");
        String s = Utils.strScanner.nextLine();
        Hotel show = db.show(s);
        Integer enterRoomFloor = Utils.getInt("Enter room floor");
        Integer enterRoomNumber = Utils.getInt("Enter room number");
        Integer anInt1 = Utils.getInt("How many days will you visit our hotel?");
        Integer anInt = Utils.getInt("How many days do you want to stay in this hotel?");
        if (show.getFloors()<enterRoomFloor||show.getRoomsCount()<enterRoomNumber) {
            System.out.println("Error");
            return;
        }
        Reservation reservation=new Reservation(currentUser,show,enterRoomFloor,enterRoomNumber,LocalDate.now().plusDays(anInt1),LocalDate.now().plusDays(anInt));
        db.addReservation(reservation);

    }

    @Override
    public void cancelReservation() {
        for (Reservation reservation : db.showReservationByUser(currentUser.getId())) {
            System.out.println(reservation);
        }
        System.out.println("Enter reservetion id");
        String s = Utils.strScanner.nextLine();
        db.cancelReservation(s);
    }

    @Override
    public void rescheduleReservation() {

    }

    @Override
    public void showHistory() {
        for (Reservation reservation : db.showReservationByUser(currentUser.getId())) {
            System.out.println(reservation);
        }
    }
}
