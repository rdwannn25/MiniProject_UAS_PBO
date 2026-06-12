class Motorcycle extends Vehicle {

    public Motorcycle(String plateNumber, int parkingHours) {
        super(plateNumber, parkingHours);
    }

    @Override
    public double calculateFee() {
        return getParkingHours() * 3000;
    }
}