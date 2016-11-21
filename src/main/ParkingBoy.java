public class ParkingBoy {

    private  ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Integer parking(Car car) {
        return parkingLot.parking(car);
    }

    public Car pick(Integer token) {
        return parkingLot.pick(token);
    }
}
