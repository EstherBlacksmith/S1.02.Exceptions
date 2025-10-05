package theater;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

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

            option = Validation.validateInt(question);

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

        List<Seat> reservedSeats;

        if(!Validation.noReservationsYet(this.theater.seatsManagement.getSeats())){

            reservedSeats = this.theater.seatsManagement.seatsArray.stream()
                    .filter(seat -> seat.getReservedName() == name ).toList();
            System.out.println(reservedSeats);
        }else{
            return NORESERVATIONSYET;
        }
        return reservedSeats.toString();
    }

    private String askNameReservation() {
        String question = "Indicate the name under the reservation is made";
        String name = Validation.validateString(question);
        return name;
    }

    private int askRowReservation(){
        String question = "Indicate the row";
        int row = Validation.validateInt(question);
        return row;
    }

    private int askSeatReservation(){
        String question = "Indicate the seat";
        int seat = Validation.validateInt(question);
        return seat;
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

        if(!Validation.noReservationsYet(this.theater.seatsManagement.getSeats())){
            int row = askRowReservation();
            int seat = askSeatReservation();
            this.theater.seatsManagement.deleteSeat(row,seat);

            return "Reservation has been cancelled";
        }else{
            return NORESERVATIONSYET;
        }
    }

    protected void reserveSeat() {
        int row = askRowReservation();
        Validation.maxRowsExceeded(row, this.theater.numRowsPerTheater);

        int seat = askSeatReservation();
        Validation.maxSeatsExceeded(seat,this.theater.numSeatsPerRow);

        String name = askNameReservation();

        Seat seatToAdd = new Seat(row,seat,name);
       try{
           this.theater.seatsManagement.addSeat(seatToAdd);
           System.out.println("Seat added correctly:\n" + seatToAdd.toString());
       } catch (InUseSeatException e) {
           System.out.println( e.getMessage());
       }

    }
}
