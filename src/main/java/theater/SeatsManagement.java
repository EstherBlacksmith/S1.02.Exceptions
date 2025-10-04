package theater;

import java.util.ArrayList;

class SeatsManagement {
    ArrayList<Seat> seatsArray;

    public SeatsManagement() {
        seatsArray = new ArrayList <Seat>();
    }

    protected ArrayList <Seat> getSeats() {
        return seatsArray;
    }

    protected void addSeat(Seat seat) {
        try{
            int seatIndex = searchSeat(seat.getFileNum(),seat.getSeatNum());
            if(seatIndex != -1){
                seatsArray.add(seat);
            }
        }catch (InUseSeatException e){
            throw new InUseSeatException("The seat was already in use");
        }
    }

    protected void deleteSeat(int fileNum, int seatNum) {
        try{
            int seatIndex = searchSeat(fileNum,seatNum);
            if(seatIndex == -1){
                seatsArray.remove(seatIndex);
            }
        }catch (FreeSeatException e){
            throw new FreeSeatException("The seat was already free");
        }

    }

    protected int searchSeat(int fileNum, int seatNum) {
        Seat searchedSeat;
        int seatsIndex = -1;
        try {
            searchedSeat = seatsArray.stream()
                    .filter(seat -> seat.getFileNum() == fileNum && seat.getSeatNum() == seatNum).findFirst().orElse(null);

            if(searchedSeat != null) {
                seatsIndex = seatsArray.indexOf(searchedSeat);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return seatsIndex;
    }
}



