package theater;

import entry.InputPersonalicedMismatchException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Validation {

    protected static int validateInt(String question, Scanner inputScanner){
        int readedInt = 0;
        System.out.println(question);

        while (readedInt == 0) {
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

    protected static boolean maxLinesExceeded (int numLine, int maxLinesTheater){
        if (maxLinesTheater <= numLine) {
            return true;
        }else {
            return false;
        }
    }
    protected static boolean maxSeatsExceeded(int numSeat, int maxSeatPerLineTheater){
        if (maxSeatPerLineTheater <= numSeat) {
            return true;
        }else {
            return false;
        }
    }

    protected static boolean noReservationsYet(ArrayList<Seat> seatsArray){
        if(seatsArray.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
    protected static String validateString(String question, Scanner inputScanner){
        String readedString = "";
        System.out.println(question);

        while (readedString == "") {
            if (inputScanner.hasNext()) {
                try {
                    readedString = inputScanner.next();

                } catch (InputPersonalicedMismatchException e) {
                    System.out.println("Incorrect type.\n" + question);
                    inputScanner.next();
                }
            }
        }

        return readedString;
    }
}
