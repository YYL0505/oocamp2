import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsSame.sameInstance;

public class ParkingLotTest {

    @Test
    public void should_be_able_to_pick_up_car_when_parking_it() {
        ParkingLot parkingLot = new ParkingLot();
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
    public void should_able_to_pick_up_first_car_when_I_parking_another_car_given_there_is_a_car_in_parking_lot() {
        ParkingLot parkingLot = new ParkingLot();
        Car existedCar = new Car();
        int tokenOfExistedCar = parkingLot.parking(existedCar);

        Car myCar = new Car();
        parkingLot.parking(myCar);

        assertThat(existedCar, sameInstance(parkingLot.pick(tokenOfExistedCar)));
    }
}