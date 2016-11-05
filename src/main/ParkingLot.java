import java.util.HashMap;

public class ParkingLot {
    public static int Max_Capicity = 100;
    private int count = 0;

    private HashMap<Integer, Car> cars = new HashMap<Integer, Car>();
    public Integer parking(Car car) {
        if (Max_Capicity == count) {
            return null;
        }

        count++;
        cars.put(count, car);
        return count;
    }

    public Car pick(Integer token) {
        Car car = cars.get(token);
        if (null != car) {
            count--;
        }
        return car;
    }

}
