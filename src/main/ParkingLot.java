import java.util.HashMap;

/**
 * Created by ylyuan on 11/3/16.
 */
public class ParkingLot {
    private int count = 0;
    private HashMap<Integer, Car> cars = new HashMap<>();
    private Car car;

    public int parking(Car car) {
        count++;
        cars.put(count, car);
        return count;
    }

    public Car pick(int token) {

        return cars.get(token);
    }
}
