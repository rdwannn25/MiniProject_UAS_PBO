class Car extends Vehicle {

    public Car(String plateNumber, int parkingHours) {
        super(plateNumber, parkingHours);
    }

    @Override
    public double calculateFee() {
        return getParkingHours() * 5000;
    }
}