import java.util.ArrayList;

class ParkingManager {

    private ArrayList<Vehicle> parkingList = new ArrayList<>();

    private final int MAX_CAPACITY = 5;

    public void addVehicle(Vehicle vehicle) throws ParkingException {
        if (parkingList.size() >= MAX_CAPACITY) {
            throw new ParkingException("Parkiran penuh!");
        }
        parkingList.add(vehicle);
        System.out.println("Kendaraan berhasil masuk");
    }

    private String getJenis(Vehicle v) {
        if (v instanceof Car) return "Mobil";
        if (v instanceof Motorcycle) return "Motor";
        if (v instanceof Truck) return "Truk";
        return "Unknown";
    }

    public void showVehicles() {
        System.out.println("\n=================================================");
        System.out.println("          DAFTAR KENDARAAN PARKIR");
        System.out.println("=================================================");

        if (parkingList.isEmpty()) {
            System.out.println();
            System.out.println("(Belum ada kendaraan yang diparkir)");
            System.out.println();
            System.out.println("=================================================");
            return;
        }

        int countCar = 0;
        int countMotor = 0;
        int countTruck = 0;

        for (Vehicle v : parkingList) {
            if (v instanceof Car) countCar++;
            else if (v instanceof Motorcycle) countMotor++;
            else if (v instanceof Truck) countTruck++;
        }

        System.out.println();

        printSection("Mobil", countCar);
        printSection("Motor", countMotor);
        printSection("Truk", countTruck);

        System.out.println("------------------------------------------------");
        System.out.println("        JUMLAH KENDARAAN (TOTAL PER JENIS)");
        System.out.println("------------------------------------------------");
        System.out.println("Mobil : " + countCar);
        System.out.println("Motor : " + countMotor);
        System.out.println("Truk  : " + countTruck);

        System.out.println("=================================================");

    }

    private void printSection(String jenisTitle, int count) {
        System.out.println(jenisTitle + " (jumlah: " + count + ")");
        System.out.println("------------------------------------------------");
        System.out.printf("%-3s %-15s %-12s%n", "No", "Nomor Polisi", "Lama Parkir");
        System.out.println("------------------------------------------------");

        if (count == 0) {
            System.out.println("(Tidak ada kendaraan " + jenisTitle.toLowerCase() + ")");
            System.out.println();
            return;
        }

        int no = 1;
        for (Vehicle v : parkingList) {
            boolean match = false;
            if (jenisTitle.equals("Mobil") && v instanceof Car) match = true;
            else if (jenisTitle.equals("Motor") && v instanceof Motorcycle) match = true;
            else if (jenisTitle.equals("Truk") && v instanceof Truck) match = true;

            if (match) {
                System.out.printf("%-3d %-15s %-12d%n", no, v.getPlateNumber(), v.getParkingHours());
                no++;
            }
        }

        System.out.println();
    }


    public double calculateIncome() {
        double total = 0;
        for (Vehicle vehicle : parkingList) {
            total += vehicle.calculateFee();
        }
        return total;
    }
}

