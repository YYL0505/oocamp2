import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsSame.sameInstance;

public class ParkingLotTest {

    @Test
    public void should_be_able_to_pick_up_car_when_parking_it() {
        ParkingLot parkingLot = new ParkingLot(100);
        Car car = new Car();

        int token = parkingLot.parking(car);

        assertThat(car, sameInstance(parkingLot.pick(token)));
    }

    @Test
    public void should_able_to_pick_up_my_car_when_I_parking_it_before_given_there_is_a_car_in_parking_lot() {
        ParkingLot parkingLot = new ParkingLot();
        Car existedCar = new Car();
        parkingLot.parking(existedCar);

        Car myCar = new Car();
        int tokenOfMyCar = parkingLot.parking(myCar);

        assertThat(myCar, sameInstance(parkingLot.pick(tokenOfMyCar)));
    }

    @Test
    public void should_able_to_pick_up_my_car_after_another_car_parking_given_there_is_a_car_in_parking_lot() {
        ParkingLot parkingLot = new ParkingLot();
        Car myCar = new Car();
        Integer myToken = parkingLot.parking(myCar);

        Car anotherCar = new Car();

        assertThat(myCar, sameInstance(parkingLot.pick(myToken)));
    }

    @Test
    public void should_not_able_to_park_car_when_the_parking_lot_is_full() {
        ParkingLot parkingLot = new ParkingLot(1);

        parkingLot.parking(new Car());

        Car car = new Car();
        Integer nullToken = parkingLot.parking(car);

        assertNull(nullToken);
    }

    @Test
    public void should_not_able_to_park_car_when_lot_is_full_and_one_car_is_picked() {
        ParkingLot parkingLot = new ParkingLot(1);

        Car car = new Car();
        Integer token = parkingLot.parking(car);
        parkingLot.pick(token);

        Car myCar = new Car();
        Integer myToken = parkingLot.parking(myCar);

        assertThat(myCar, sameInstance(parkingLot.pick(myToken)));

    }

    @Test
    public void should_able_to_park_car_when_another_car_picked_given_parking_lot_is_full() {
        ParkingLot parkingLot = new ParkingLot(1);

        Integer token = null;
        token = parkingLot.parking(new Car());
        parkingLot.pick(token);

        Car car = new Car();
        Integer myToken = parkingLot.parking(car);

        assertNotNull(myToken);
    }

    @Test
    public void should_not_able_to_pick_up_car_when_I_not_park_a_car() {
        ParkingLot parkingLot = new ParkingLot(100);

        Integer token = 2313;

        assertNull(parkingLot.pick(token));
    }

    @Test
    public void should_not_able_to_pick_up_car_twice_when_I_park_a_car_once() {
        ParkingLot parkingLot = new ParkingLot(100);

        Car car = new Car();
        Integer myToken = parkingLot.parking(car);

        assertThat(car, sameInstance(parkingLot.pick(myToken)));

        assertNull(parkingLot.pick(myToken));
    }


}