import org.junit.Test;

import static java.util.Arrays.asList;
import static junit.framework.TestCase.assertNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsSame.sameInstance;

public class parkingBoyTest {

    @Test
    public void should_able_to_park_car_given_there_is_one_parking_lot() {
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(asList(parkingLot));
        Car car = new Car();

        Long token = parkingBoy.parking(car);

        assertThat(car, sameInstance(parkingLot.pick(token)));
    }

    @Test
    public void should_able_to_pick_up_car_given_there_is_one_parking_lot() {
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(asList(parkingLot));
        Car car = new Car();

        Long token = parkingLot.parking(car);

        assertThat(car, sameInstance(parkingBoy.pick(token)));
    }

    @Test
    public void should_able_to_park_car_to_first_space_when_there_is_space_given_there_are_multiple_parking_lots() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(asList(firstParkingLot, secondParkingLot));
        Car car = new Car();

        Long token = parkingBoy.parking(car);

        assertThat(car, sameInstance(firstParkingLot.pick(token)));
    }

    @Test
    public void should_able_to_park_car_to_second_space_when_there_is_space_in_first_one_given_there_are_multiple_parking_lots() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(asList(firstParkingLot, secondParkingLot));
        parkingBoy.parking(new Car());
        Car car = new Car();

        Long token = parkingBoy.parking(car);

        assertThat(car, sameInstance(secondParkingLot.pick(token)));
    }

    @Test
    public void should_able_to_pick_up_car_given_there_are_multiple_parking_lots() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(asList(firstParkingLot, secondParkingLot));
        Car car = new Car();

        Long token = secondParkingLot.parking(car);

        assertThat(car, sameInstance(parkingBoy.pick(token)));
    }

    @Test
    public void should_not_able_to_pick_up_car_twice_given_there_are_multiple_parking_lots() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(asList(firstParkingLot, secondParkingLot));
        Car car = new Car();

        Long token = parkingBoy.parking(car);

        assertThat(car, sameInstance(parkingBoy.pick(token)));
        assertNull(parkingBoy.pick(token));
    }

    @Test
    public void should_not_able_to_pick_up_car_when_never_park_it_given_there_are_multiple_parking_lots() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(asList(firstParkingLot, secondParkingLot));

        Long token = 1233L;

        assertNull(parkingBoy.pick(token));
    }

    @Test
    public void should_not_able_to_park_car_when_lot_are_full_given_there_are_multiple_parking_lots() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(asList(firstParkingLot, secondParkingLot));
        parkingBoy.parking(new Car());
        parkingBoy.parking(new Car());
        Car car = new Car();

        Long token = parkingBoy.parking(car);

        assertNull(parkingBoy.pick(token));
    }
}
