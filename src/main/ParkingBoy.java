import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {

    private  List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots.addAll(parkingLots);
    }

    public Long parking(Car car) {
        for (ParkingLot parkingLot : parkingLots) {
            if (!parkingLot.isFull()) {
                return parkingLot.parking(car);
            }
        }
        return null;
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
