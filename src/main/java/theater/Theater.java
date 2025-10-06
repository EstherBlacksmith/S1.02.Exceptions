package theater;


class Theater {
    int numRowsPerTheater;
    int numSeatsPerRow;
    SeatsManagement seatsManagement;
    TheaterManagement theaterManagement;

    public Theater() {
        seatsManagement = new SeatsManagement();
        theaterManagement = new TheaterManagement(this);
        askInitialData();
    }

    protected void askInitialData() {

        String question = "";

        while (numRowsPerTheater == 0) {
            question = "Indicate the rows number in the theater";
            numRowsPerTheater = Validation.validateInt(question);
        }
        while (numSeatsPerRow == 0) {
            question = "Indicate the seats number per row";
            numSeatsPerRow = Validation.validateInt(question);
        }

    }

    protected void init() {
        askInitialData();
        int option = -1;

        do {
            option = theaterManagement.menu();

            switch (option) {
                case 0 -> {
                    System.out.println("Exit");
                    return;
                }
                case 1 -> {
                    System.out.println(theaterManagement.showReservedSeats());
                }
                case 2 -> {
                    System.out.println(theaterManagement.showReservedSeatsOnePerson());
                }
                case 3 -> {
                    theaterManagement.reserveSeat();
                }
                case 4 -> {
                    System.out.println(theaterManagement.cancelSeatReservation());
                }

                case 5 -> {
                    System.out.println(theaterManagement.cancelAllReservedSeatsOnePerson());
                }
                default -> {
                    System.out.println("Incorrect menu option.");
                }

            }
        } while (option != 0);


    }


}
