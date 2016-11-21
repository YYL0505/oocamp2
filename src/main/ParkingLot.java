import java.util.HashMap;

public class ParkingLot {
    public int maxCapacity = 100;
    private int count = 0;
    private HashMap<Integer, Car> cars = new HashMap<Integer, Car>();

    public ParkingLot(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public ParkingLot() {
    }

    public Integer parking(Car car) {
        if (maxCapacity == count) {
            return null;
        }

        count++;
        cars.put(count, car);
        return count;
    }

    public Car pick(Integer token) {
        Car car = cars.get(token);
        if (null != car) {
            cars.remove(token);
            count--;
        }
        return car;
    }
}
