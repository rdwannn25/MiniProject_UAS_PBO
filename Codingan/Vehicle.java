abstract class Vehicle {

    private String plateNumber;
    private int parkingHours;

    public Vehicle(String plateNumber, int parkingHours) {
        this.plateNumber = plateNumber;
        this.parkingHours = parkingHours;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public int getParkingHours() {
        return parkingHours;
    }

    public abstract double calculateFee();

    public void vehicleInfo() {
        System.out.println("Plat Nomor : " + plateNumber);
        System.out.println("Durasi     : " + parkingHours + " jam");
    }
}