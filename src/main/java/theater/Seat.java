package theater;

class Seat {
    private int fileNum;
    private  int seatNum;
    private String reservedName;

    public Seat(int fileNum, int seatNum, String reservedName) {
        this.fileNum = fileNum;
        this.seatNum = seatNum;
        this.reservedName = reservedName;
    }

    protected int getFileNum() {
        return fileNum;
    }

    protected int getSeatNum() {
        return seatNum;
    }

    protected String getReservedName() {
        return reservedName;
    }

    protected String equals(){
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
