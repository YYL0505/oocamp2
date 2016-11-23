import java.util.List;


public class SmartParkingBoy {
    private List<ParkingLot> parkingLots;

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Long park(Car car) {
        ParkingLot parkingLotWithMaxSpace = parkingLots.get(0);
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getSpace() > parkingLotWithMaxSpace.getSpace()) {
                parkingLotWithMaxSpace = parkingLot;
            }
        }

        return parkingLotWithMaxSpace.parking(car);
    }

    public Car pick(Long token) {
        Car car = null;

        for (ParkingLot parkingLot : parkingLots) {
            car = parkingLot.pick(token);
            if (null != car) {
                break;
            }
        }
        return car;
    }
}
