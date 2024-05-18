package uz.app.hotel.main.service;

import uz.app.hotel.database.DB;
import uz.app.hotel.entity.Hotel;
import uz.app.hotel.entity.User;
import uz.app.hotel.service.UserService;

public class UserServise implements UserService {
    private User currentUser;
    private DB db= DB.getInstance();
    @Override
    public void service(User user) {
        currentUser=user;
        while (true){
            switch (Utils.getInt("""
                    0 Exit
                    1 Show hotel
                    2 Show reservations
                    3 Reversee
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
                    for (Hotel hotel : db.showAll()) {

                    }

                }
                case 2->{}
                case 3->{}
                case 4->{}
                case 5->{}
                case 6->{}
            }
        }
    }

    @Override
    public void showHotels() {

    }

    @Override
    public void showReservations() {

    }

    @Override
    public void reserve() {

    }

    @Override
    public void cancelReservation() {

    }

    @Override
    public void rescheduleReservation() {

    }

    @Override
    public void showHistory() {

    }
}
