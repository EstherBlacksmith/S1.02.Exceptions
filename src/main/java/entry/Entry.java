package entry;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Entry {
    static Scanner inputScanner = new Scanner(System.in);

    static Byte readByte(String question) {
        Byte readedByte = 0;

        System.out.println(question);

        while (readedByte == 0) {
            if (inputScanner.hasNext()) {
                try {
                    readedByte = inputScanner.nextByte();

                } catch (InputMismatchException e) {
                    System.out.println("Incorrect type.\n" + question);
                    inputScanner.next();
                }
            }
        }

        return readedByte;
    }


    static int readInt(String question) {
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

    static Float readFloat(String question) {
        Float readedFloat = 0f;

        while (readedFloat == 0f) {
            if (inputScanner.hasNext()) {
                try {
                    readedFloat = inputScanner.nextFloat();

                } catch (InputMismatchException e) {
                    System.out.println("Incorrect type.\n" + question);
                    inputScanner.next();
                }
            }

        }
        return readedFloat;
    }
}