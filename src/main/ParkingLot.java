import java.util.HashMap;
import java.util.Random;

public class ParkingLot {
    public int maxCapacity = 100;
    private int count = 0;
    private HashMap<Long, Car> cars = new HashMap<Long, Car>();

    public ParkingLot(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public ParkingLot() {
    }

    public Long parking(Car car) {
        if (maxCapacity == count) {
            return null;
        }

        count++;
        long token = System.currentTimeMillis() + new Random().nextLong();
        cars.put(token, car);
        return token;
    }

    public Car pick(Long token) {
        Car car = cars.get(token);
        if (null != car) {
            cars.remove(token);
            count--;
        }
        return car;
    }

    public boolean isFull() {
        return maxCapacity == count;
    }

    public int getSpace() {
        return maxCapacity - count;
    }

    public double vacancyRate() {
        return ((double) (maxCapacity - count)) / ((double) maxCapacity);
    }
}
