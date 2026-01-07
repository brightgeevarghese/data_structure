package learn.inner_static_class;

public class ParkingLot {
    private final String lotName;

    public ParkingLot(String lotName) {
        this.lotName = lotName;
    }
    class Car {
        private final String plateNumber;
        Car(String plateNumber) {
            this.plateNumber = plateNumber;
        }
        public void printDetails() {
            System.out.println("Plate Number: " + plateNumber);
        }
    }
    static class ParkingRule {
        static final int MAX_HOURS = 4;
        static void printRule() {
            System.out.println("Maximum hours allowed: " + MAX_HOURS);
        }
    }
}

class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot("MIU main lot");
        ParkingLot.Car car = parkingLot.new Car("MIU-1234");
        car.printDetails();
        ParkingLot.ParkingRule.printRule();
    }
}
