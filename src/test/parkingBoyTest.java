import org.junit.Test;

import static java.util.Arrays.asList;
import static junit.framework.TestCase.assertNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsSame.sameInstance;

public class parkingBoyTest {

    @Test
    public void should_able_to_pick_up_car_byParking_boy_when_parking_boy_parking_car_given_there_is_one_parking_lot() {
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(asList(parkingLot));

        Car car = new Car();
        Long token = parkingBoy.parking(car);

        Car pickedCar = parkingBoy.pick(token);

        assertThat(pickedCar, sameInstance(car));
    }

    @Test
    public void should_able_to_pick_up_car_when_parking_boy_parking_car_given_there_is_one_parking_lot() {
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(asList(parkingLot));

        Car car = new Car();
        Long token = parkingBoy.parking(car);

        Car pickedCar = parkingLot.pick(token);
        assertThat(pickedCar, sameInstance(car));
    }

    @Test
    public void should_able_to_pick_up_car_by_parking_boy_when_I_parking_car_given_there_is_one_parking_lot() {
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(asList(parkingLot));

        Car car = new Car();
        Long token = parkingLot.parking(car);

        Car pickedCar = parkingBoy.pick(token);
        assertThat(pickedCar, sameInstance(car));
    }

    @Test
    public void should_able_to_pick_up_car_by_parking_boy_when_parking_boy_parking_car_given_there_are_multiple_parking_lots() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(asList(firstParkingLot, secondParkingLot));
        parkingBoy.parking(new Car());

        Car car = new Car();
        Long token = parkingBoy.parking(car);

        Car pickedCar = parkingBoy.pick(token);
        assertThat(pickedCar, sameInstance(car));
    }

    @Test
    public void should_able_to_pick_up_car_by_parking_boy_when_I_parking_car_given_there_are_multiple_parking_lots() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(asList(firstParkingLot, secondParkingLot));
        firstParkingLot.parking(new Car());

        Car car = new Car();
        Long token = secondParkingLot.parking(car);

        Car pickedCar = parkingBoy.pick(token);
        assertThat(pickedCar, sameInstance(car));
    }

    @Test
    public void should_able_to_pick_up_car_when_parking_boy_parking_car_given_there_are_multiple_parking_lots() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(asList(firstParkingLot, secondParkingLot));
        firstParkingLot.parking(new Car());

        Car car = new Car();
        Long token = parkingBoy.parking(car);

        Car pickedCar = secondParkingLot.pick(token);
        assertThat(pickedCar, sameInstance(car));
    }

    @Test
    public void should_not_able_to_pick_up_car_from_other_lot_when_parking_boy_parking_car_given_there_are_multiple_parking_lots() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(asList(firstParkingLot, secondParkingLot));
        firstParkingLot.parking(new Car());

        Car car = new Car();
        Long token = parkingBoy.parking(car);

        assertNull(firstParkingLot.pick(token));
    }

    @Test
    public void should_not_able_to_pick_up_car_twice_when_parking_boy_parking_car_given_there_are_multiple_parking_lots() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(asList(firstParkingLot, secondParkingLot));
        firstParkingLot.parking(new Car());

        Car car = new Car();
        Long token = parkingBoy.parking(car);

        Car pickedCar = secondParkingLot.pick(token);
        assertThat(pickedCar, sameInstance(car));
        assertNull(secondParkingLot.pick(token));
    }
}
