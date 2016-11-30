import org.junit.Test;

import static java.util.Arrays.asList;
import static junit.framework.TestCase.assertNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsSame.sameInstance;

public class SuperParkingBoyTest {
    @Test
    public void should_able_to_park_a_car_given_there_is_a_park_lot() {
        ParkingLot parkingLot = new ParkingLot(1);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(asList(parkingLot));
        Car car = new Car();

        Long token = superParkingBoy.park(car);

        assertThat(car, sameInstance(parkingLot.pick(token)));
    }

    @Test
    public void should_able_to_pick_a_car_after_park_it_given_there_is_a_park_lot() {
        ParkingLot parkingLot = new ParkingLot(1);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(asList(parkingLot));
        Car car = new Car();

        Long token = superParkingBoy.park(car);

        assertThat(car, sameInstance(superParkingBoy.pick(token)));
    }

    @Test
    public void should_able_to_park_car_to_lot_whose_space_persent_is_more_given_there_are_two_park_lot() {
        ParkingLot firstParkingLot = new ParkingLot(3);
        ParkingLot secondParkingLot = new ParkingLot(2);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(asList(firstParkingLot, secondParkingLot));
        superParkingBoy.park(new Car());
        Car car = new Car();

        Long token = superParkingBoy.park(car);

        assertThat(car, sameInstance(secondParkingLot.pick(token)));
    }

    @Test
    public void should_able_to_park_car_to_lot_whose_vacancy_rate_is_more_given_there_are_two_park_lot() {
        ParkingLot firstParkingLot = new ParkingLot(2);
        ParkingLot secondParkingLot = new ParkingLot(3);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(asList(firstParkingLot, secondParkingLot));
        superParkingBoy.park(new Car());
        superParkingBoy.park(new Car());
        Car car = new Car();

        Long token = superParkingBoy.park(car);

        assertThat(car, sameInstance(secondParkingLot.pick(token)));
    }

    @Test
    public void should_able_to_park_car_by_order_given_there_are_two_park_lot_and_space_are_same() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(asList(firstParkingLot, secondParkingLot));
        Car car = new Car();

        Long token = superParkingBoy.park(car);

        assertThat(car, sameInstance(firstParkingLot.pick(token)));
    }

    @Test
    public void should_able_to_pick_car_after_park_it_given_there_are_two_park_lot() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(2);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(asList(firstParkingLot, secondParkingLot));
        Car car = new Car();

        Long token = superParkingBoy.park(car);

        assertThat(car, sameInstance(superParkingBoy.pick(token)));
    }

    @Test
    public void should_fail_to_pick_a_car_when_never_park_it() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(asList(firstParkingLot, secondParkingLot));

        Long token = 2313L;;

        assertNull(superParkingBoy.pick(token));
    }

    @Test
    public void should_fail_to_pick_a_car_twice_when_park_it_once() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(asList(firstParkingLot, secondParkingLot));
        Car car = new Car();

        Long token = superParkingBoy.park(car);

        assertThat(car, sameInstance(superParkingBoy.pick(token)));
        assertNull(superParkingBoy.pick(token));
    }

    @Test
    public void should_fail_to_park_when_park_lot_is_full_() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(asList(firstParkingLot, secondParkingLot));
        superParkingBoy.park(new Car());
        superParkingBoy.park(new Car());
        Car car = new Car();

        Long token = superParkingBoy.park(car);

        assertNull(superParkingBoy.pick(token));
    }

}
