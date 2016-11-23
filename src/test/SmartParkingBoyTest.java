import org.junit.Test;

import static java.util.Arrays.asList;
import static junit.framework.TestCase.assertNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsSame.sameInstance;

public class SmartParkingBoyTest {
    @Test
    public void should_able_to_park_a_car_given_there_is_a_park_lot() {
        ParkingLot parkingLot = new ParkingLot(1);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(asList(parkingLot));
        Car car = new Car();

        Long token = smartParkingBoy.park(car);

        assertThat(car, sameInstance(parkingLot.pick(token)));
    }

    @Test
    public void should_able_to_pick_a_car_after_park_it_given_there_is_a_park_lot() {
        ParkingLot parkingLot = new ParkingLot(1);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(asList(parkingLot));
        Car car = new Car();

        Long token = smartParkingBoy.park(car);

        assertThat(car, sameInstance(smartParkingBoy.pick(token)));
    }

    @Test
    public void should_able_to_park_car_to_lot_whose_space_is_more_given_there_are_two_park_lot() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(asList(firstParkingLot, secondParkingLot));
        Car car = new Car();

        Long token = smartParkingBoy.park(car);

        assertThat(car, sameInstance(secondParkingLot.pick(token)));
    }

    @Test
    public void should_able_to_park_car_by_order_given_there_are_two_park_lot_and_space_are_same() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(asList(firstParkingLot, secondParkingLot));
        Car car = new Car();

        Long token = smartParkingBoy.park(car);

        assertThat(car, sameInstance(firstParkingLot.pick(token)));
    }

    @Test
    public void should_able_to_pick_car_after_park_it_given_there_are_two_park_lot() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(asList(firstParkingLot, secondParkingLot));
        Car car = new Car();

        Long token = smartParkingBoy.park(car);

        assertThat(car, sameInstance(smartParkingBoy.pick(token)));
    }

    @Test
    public void should_fail_to_pick_a_car_when_never_park_it() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(asList(firstParkingLot, secondParkingLot));

        Long token = 2313L;;

        assertNull(smartParkingBoy.pick(token));
    }

    @Test
    public void should_fail_to_pick_a_car_twice_when_park_it_once() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(asList(firstParkingLot, secondParkingLot));
        Car car = new Car();

        Long token = smartParkingBoy.park(car);

        assertThat(car, sameInstance(smartParkingBoy.pick(token)));
        assertNull(smartParkingBoy.pick(token));
    }

    @Test
    public void should_fail_to_park_when_park_lot_is_full_() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(asList(firstParkingLot, secondParkingLot));
        smartParkingBoy.park(new Car());
        smartParkingBoy.park(new Car());
        Car car = new Car();

        Long token = smartParkingBoy.park(car);

        assertNull(smartParkingBoy.pick(token));
    }

}
