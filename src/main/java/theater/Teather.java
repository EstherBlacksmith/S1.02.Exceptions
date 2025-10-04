package theater;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Teather {
    int numFilesPerTeather;
    int numSeatsPerFile;
    SeatsManagement seatsManagement;
    TeatherManagement teatherManagement;

    public Teather() {
        seatsManagement = new SeatsManagement();
        teatherManagement = new TeatherManagement(new Teather());
        askInitialData();
    }

    private void askInitialData() {
        Scanner inputScanner = new Scanner(System.in);
        String question = "";

        while (numFilesPerTeather == 0) {
            question = "Indicate the files number ine the teather";
            numFilesPerTeather = validateInt(question, inputScanner);
        }
        while (numSeatsPerFile == 0) {
            question = "Indicate the seats number per file";
            numSeatsPerFile = validateInt(question, inputScanner);
        }

        if (inputScanner != null){
            inputScanner.close();
        }
    }

    void init(){
        teatherManagement.menu();
    }

    private int validateInt(String question, Scanner inputScanner){
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
}
