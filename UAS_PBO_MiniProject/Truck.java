class Truck extends Vehicle {

    public Truck(String plateNumber, int parkingHours) {
        super(plateNumber, parkingHours);
    }

    @Override
    public double calculateFee() {
        return getParkingHours() * 8000;
    }
}