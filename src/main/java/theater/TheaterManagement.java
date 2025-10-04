package theater;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class TheaterManagement {
    Theater theater;

    final static String NORESERVATIONSYET =  "There is not reservations yet";
    public TheaterManagement(Theater theater) {
        this.theater = theater;
    }

    protected int menu() {
        int option = 0;
        String question =
                "Please select an option:\n" +
                "1.- Show all the reserved seats.\n" +
                "2.- Show all the reserved seats of one person.\n" +
                "3.- Reserve a seat.\n" +
                "4.- Cancel the reservation for a seat.\n" +
                "5.- Cancel all reservation for a person.\n" +
                "0.- Exit.";

        Scanner inputScan = new Scanner(System.in);
        Validation.validateInt(question,inputScan);

        inputScan.close();

        return option;
    }

    protected String showReservedSeats() {
        String reservedSeats = "";
        if(!Validation.noReservationsYet(this.theater.seatsManagement.getSeats())){
            reservedSeats = this.theater.seatsManagement.getSeats().toString();
        }else{
            reservedSeats = NORESERVATIONSYET;
        }
        return reservedSeats;
    }

    protected String showReservedSeatsOnePerson() {
        String name = askNameReservation();

        ArrayList <Seat> reservedSeats = new ArrayList<>();

        if(!Validation.noReservationsYet(this.theater.seatsManagement.getSeats())){

            reservedSeats = (ArrayList<Seat>) this.theater.seatsManagement.seatsArray.stream()
                    .filter(seat -> seat.getReservedName() == name );

        }else{
            return NORESERVATIONSYET;
        }
        return reservedSeats.toString();
    }

    private String askNameReservation() {
        Scanner inputScan = new Scanner(System.in);
        String question = "Indicate the name the reservation is made";
        String name = Validation.validateString(question,inputScan);
        inputScan.close();
        return name;
    }

    protected String cancelAllReservedSeatsOnePerson() {
        String name = askNameReservation();
        ArrayList <Seat> reservedSeats;
        int removedReservations = 0;
        if(!Validation.noReservationsYet(this.theater.seatsManagement.getSeats())){
            reservedSeats = this.theater.seatsManagement.getSeats();

           Iterator <Seat> iterator = reservedSeats.iterator() ;

            while(iterator.hasNext()){
                if(iterator.next().getReservedName().equalsIgnoreCase(name)){
                    iterator.remove();
                    removedReservations ++;
                }
            }
        }
        return "Total of reservations cancelled:  " + removedReservations;
    }

    protected String cancelSeatReservation() {
        ArrayList <Seat> reservedSeats;
        int removedReservations = 0;

        if(!Validation.noReservationsYet(this.theater.seatsManagement.getSeats())){
            reservedSeats = this.theater.seatsManagement.getSeats();
            reservedSeats.clear();
            return "All reservations has been cancelled";
        }else{
            return NORESERVATIONSYET;

        }

    }

    protected void reserveSeat() {

    }
}
