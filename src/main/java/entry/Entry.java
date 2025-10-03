package entry;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Entry {
    static Scanner inputScanner = new Scanner(System.in).useLocale(Locale.US);

    private static boolean findingPatternToAvoid(){
        final String patternToAvoid = "[,]+";
        boolean foundedPattern = false;
        String commaThrouble = null;

        commaThrouble = inputScanner.findInLine(patternToAvoid);

        if (commaThrouble != null) {
            foundedPattern = true;
        }
        return foundedPattern;
    }

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
        float readedFloat = 0f;
        System.out.println(question);

        while (readedFloat == 0f) {
            if (inputScanner.hasNext()) {
                if(findingPatternToAvoid()){
                    System.out.println("Format error.\n" + question);
                     inputScanner.next();
                } else {

                    try {
                        readedFloat = inputScanner.nextFloat();
                    } catch (InputMismatchException e) {
                        System.out.println("Incorrect type.\n" + question);
                        inputScanner.next();
                    }
                }
                inputScanner.nextLine();
            }
        }
        return readedFloat;
    }

    public static Double readDouble(String question) {
        Double readedDouble = 0.0;
        System.out.println(question);

        while (readedDouble == 0) {
            if (inputScanner.hasNext()) {
                if(findingPatternToAvoid()){
                    System.out.println("Format error.\n" + question);
                    inputScanner.next();
                } else  {
                    try {
                        readedDouble = inputScanner.nextDouble();

                    } catch (InputMismatchException e) {
                        System.out.println("Incorrect type.\n" + question);
                        inputScanner.next();
                    }
                }
                inputScanner.nextLine();
            }
        }
        return readedDouble;
    }

}