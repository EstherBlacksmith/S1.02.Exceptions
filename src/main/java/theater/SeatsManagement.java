package theater;

import java.util.ArrayList;

class SeatsManagement {
    ArrayList seatsArray;

    public SeatsManagement() {
        seatsArray = new ArrayList <Seat>();
    }

    protected ArrayList <Seat> getSeats() {
        return seatsArray;
    }

    protected void addSeat(Seat seat) throws InUseSeatException{
        try{
            int seatIndex = searchSeat(seat.getRowNum(),seat.getSeatNum());
            if(seatIndex == -1){
                seatsArray.add(seat);
            }
        }catch (InUseSeatException e){
            throw new InUseSeatException("The seat was already in use");
        }
    }

    protected void deleteSeat(int rowNum, int seatNum) {
        try{
            int seatIndex = searchSeat(rowNum,seatNum);
            if(seatIndex == -1){
                seatsArray.remove(seatIndex);
            }
        }catch (FreeSeatException e){
            throw new FreeSeatException("The seat was already free");
        }

    }

    protected int searchSeat(int rowNum, int seatNum) {
        Seat searchedSeat;
        int seatsIndex = -1;
        try {
            searchedSeat = (Seat) seatsArray.stream()
                    .filter(seat ->  rowNum == rowNum && seatNum== seatNum).findFirst().orElse(null);

            if(searchedSeat != null) {
                seatsIndex = seatsArray.indexOf(searchedSeat);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return seatsIndex;
    }
}



