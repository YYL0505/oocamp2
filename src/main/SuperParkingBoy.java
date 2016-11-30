import java.util.List;

public class SuperParkingBoy {
    private List<ParkingLot> parkingLots;

    public SuperParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Long park(Car car) {
        ParkingLot parkingLotWithMaxVacancyRate = parkingLots.get(0);
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.vacancyRate() > parkingLotWithMaxVacancyRate.vacancyRate()) {
                parkingLotWithMaxVacancyRate = parkingLot;
            }
        }
        return parkingLotWithMaxVacancyRate.parking(car);
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
