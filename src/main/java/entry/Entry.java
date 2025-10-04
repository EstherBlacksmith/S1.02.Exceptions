package entry;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Entry {
    static Scanner inputScanner = new Scanner(System.in).useLocale(Locale.US);

    private static boolean findingPatternToAvoid() {
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
                if (findingPatternToAvoid()) {
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

    static Double readDouble(String question) {
        Double readedDouble = 0.0;
        System.out.println(question);

        while (readedDouble == 0) {
            if (inputScanner.hasNext()) {
                if (findingPatternToAvoid()) {
                    System.out.println("Format error.\n" + question);
                    inputScanner.next();
                } else {
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

    static char readChar(String question) {
        char readedChar = ' ';

        System.out.println(question);
        while (readedChar == ' ') {
            String readedCharString = "";
            if (inputScanner.hasNext()) {
                try {
                    readedCharString = inputScanner.next();
                    if (readedCharString.length() > 1) {
                        System.out.println("Format error.\n" + question);
                        inputScanner.nextLine();
                    } else {
                        readedChar = readedCharString.charAt(0);
                    }
                } catch (InputPersonalicedMismatchException e) {
                    System.out.println("Incorrect type.\n" + question);
                    inputScanner.nextLine();
                }
            }
        }

        return readedChar;
    }

    static String readString(String question) {
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

    static boolean readBoolean(String question) {
        Boolean readedBoolean = null;
        String stringBoolean = "";
        System.out.println(question);

        while (readedBoolean == null) {

            if (inputScanner.hasNext()) {

                try {
                    stringBoolean = inputScanner.next();

                    if (!stringBoolean.matches("^[YyNn]$")) {
                        System.out.println("Incorrect, yo must introduce Y o N.\n" + question);
                        inputScanner.nextLine();
                    }

                    if (stringBoolean.equalsIgnoreCase("N")) {
                        readedBoolean = false;
                    } else if (stringBoolean.equalsIgnoreCase("Y")) {
                        readedBoolean = true;
                    }

                } catch (InputPersonalicedMismatchException e) {
                    System.out.println("Incorrect type.\n" + question);
                    inputScanner.next();
                }
            }
        }
        return readedBoolean.booleanValue();
    }
}