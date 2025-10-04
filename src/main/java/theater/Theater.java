package theater;

import java.util.Scanner;

class Theater {
    int numFilesPerTheater;
    int numSeatsPerFile;
    SeatsManagement seatsManagement;
    TheaterManagement theaterManagement;

    public Theater() {
        seatsManagement = new SeatsManagement();
        theaterManagement = new TheaterManagement(new Theater());
        askInitialData();
    }

    protected void askInitialData() {
        Scanner inputScanner = new Scanner(System.in);
        String question = "";

        while (numFilesPerTheater == 0) {
            question = "Indicate the files number ine the theater";
            numFilesPerTheater = Validation.validateInt(question, inputScanner);
        }
        while (numSeatsPerFile == 0) {
            question = "Indicate the seats number per file";
            numSeatsPerFile = Validation.validateInt(question, inputScanner);
        }

        if (inputScanner != null){
            inputScanner.close();
        }
    }

    protected void init(){
        askInitialData();

        int option = theaterManagement.menu();

        switch (option){
            case 0 -> {
                return;
            }
            case 1 -> {
                theaterManagement.showReservedSeats();
            }
            case 2 ->{
                theaterManagement.showReservedSeatsOnePerson();
            }
            case 3 -> {
                theaterManagement.reserveSeat();
            }
            case 4 -> {
                theaterManagement.cancelSeatReservation();
            }

            case 5 ->{
                theaterManagement.cancelAllReservedSeatsOnePerson();
            }
            default -> {return;}

        }
    }


}
