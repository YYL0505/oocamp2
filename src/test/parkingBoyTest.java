import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsSame.sameInstance;

public class parkingBoyTest {

    @Test
    public void should_able_to_pick_up_car_byParking_boy_when_parking_boy_parking_car_given_there_is_one_parking_lot() {
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        Car car = new Car();
        Integer token = parkingBoy.parking(car);

        Car pickedCar = parkingBoy.pick(token);

        assertThat(pickedCar, sameInstance(car));
    }

    @Test
    public void should_able_to_pick_up_car_when_parking_boy_parking_car_given_there_is_one_parking_lot() {
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        Car car = new Car();
        Integer token = parkingBoy.parking(car);

        Car pickedCar = parkingLot.pick(token);
        assertThat(pickedCar, sameInstance(car));
    }

    @Test
    public void should_able_to_pick_up_car_by_parking_boy_when_I_parking_car_given_there_is_one_parking_lot() {
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        Car car = new Car();
        Integer token = parkingLot.parking(car);

        Car pickedCar = parkingBoy.pick(token);
        assertThat(pickedCar, sameInstance(car));
    }

}
