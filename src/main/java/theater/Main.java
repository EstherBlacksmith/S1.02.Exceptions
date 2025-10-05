package theater;

import java.util.Scanner;

public class Main {
    static Scanner inputScanner = new Scanner(System.in);

    public static void main(String[] args) {
        Theater theater = new Theater();

        theater.init();

        if(inputScanner!= null){
            inputScanner.close();
        }
    }
}
