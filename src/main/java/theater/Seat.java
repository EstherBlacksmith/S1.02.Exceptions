package theater;

public class Seat {
    private int fileNum;
    private  int seatNum;
    private String reservedName;

    public Seat(int fileNum, int seatNum, String reservedName) {
        this.fileNum = fileNum;
        this.seatNum = seatNum;
        this.reservedName = reservedName;
    }

    public int getFileNum() {
        return fileNum;
    }

    public int getSeatNum() {
        return seatNum;
    }

    public String getReservedName() {
        return reservedName;
    }

    public String equals(){
        String equalSeats = "";

        return equalSeats;
    }

    @Override
    public String toString() {
        return "File:" + fileNum +
                ", seat: " + seatNum +
                ", reserved to:" + reservedName + "\n";

    }
}
