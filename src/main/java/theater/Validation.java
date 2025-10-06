package theater;

import entry.InputPersonalicedMismatchException;

import java.util.ArrayList;
import java.util.InputMismatchException;

import static theater.Main.inputScanner;

class Validation {

    protected static int validateInt(String question){
        int readedInt = -1;
        System.out.println(question);

        while (readedInt == -1) {
            if (inputScanner.hasNext()) {
                try {
                    readedInt = inputScanner.nextInt();

                } catch (InputMismatchException e) {
                    System.out.println("Incorrect type.\n" + question);
                    inputScanner.next();
                }
            }
        }

        return readedInt;
    }

    protected static void maxRowsExceeded(int numRow, int maxRowsTheater){
        if (maxRowsTheater < numRow) {
            throw new IncorrectRowException("There aren't that many rows");
        }
    }
    protected static void maxSeatsExceeded(int numSeat, int maxSeatPerRowTheater){
        if (maxSeatPerRowTheater < numSeat) {
            throw new IncorrectSeatException("There aren't that many seats");
        }
    }

    protected static boolean noReservationsYet(ArrayList<Seat> seatsArray){
        if(seatsArray.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
    protected static String validateString(String question){
        String readedString = "";
        System.out.println(question);

        while (readedString == "") {
            if (inputScanner.hasNext()) {
                try {
                    readedString = inputScanner.next();
                    if(readedString.matches(".*\\d.*")){
                        throw new IncorrectPersonNameException("The name must not contain numbers");
                    }
                } catch (InputPersonalicedMismatchException e) {
                    System.out.println("Incorrect type.\n" + question);
                    inputScanner.nextLine();
                }
            }
        }

        return readedString;
    }
}
