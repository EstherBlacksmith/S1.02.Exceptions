package theater;

class Seat {
    private final int fileNum;
    private final int seatNum;
    private final String reservedName;

    public Seat(int fileNum, int seatNum, String reservedName) {
        this.fileNum = fileNum;
        this.seatNum = seatNum;
        this.reservedName = reservedName;
    }

    protected int getRowNum() {
        return fileNum;
    }

    protected int getSeatNum() {
        return seatNum;
    }

    protected String getReservedName() {
        return reservedName;
    }

    protected boolean equals(Seat seatOne, Seat seatTwo){
        boolean equalSeats = false ;

        if(seatOne.fileNum == seatTwo.fileNum
                && seatOne.seatNum == seatTwo.seatNum){
            equalSeats = true;
        }

        return equalSeats;
    }

    @Override
    public String toString() {
        return "File:" + fileNum +
                ", seat: " + seatNum +
                ", reserved to:" + reservedName + "\n";

    }
}
