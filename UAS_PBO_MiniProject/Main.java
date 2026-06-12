import java.util.Scanner;

public class Main {

    private static void printMenu() {
        System.out.println("=================================================");
        System.out.println("           SMART PARKING SYSTEM                 ");
        System.out.println("=================================================");
        System.out.println("[1] Tambah Kendaraan");
        System.out.println("[2] Tampilkan Kendaraan");
        System.out.println("[3] Total Pendapatan");
        System.out.println("[4] Keluar");
        System.out.println("=================================================");
        System.out.print("Masukkan Pilihan Anda : ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ParkingManager manager = new ParkingManager();

        while (true) {
            printMenu();

            int choice;
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Input tidak valid! Masukkan angka 1-4.\n");
                sc.nextLine();
                continue;
            }

            if (choice == 4) {
                System.out.println("Terima kasih! Program selesai.");
                break;
            }

            try {
                switch (choice) {
                    case 1: {
                        System.out.println("=================================================");
                        System.out.println("           TAMBAH KENDARAAN");
                        System.out.println("=================================================");
                        System.out.println("Pilih Jenis Kendaraan");
                        System.out.println("1. Mobil");
                        System.out.println("2. Motor");
                        System.out.println("3. Truk");

                        System.out.print("Masukkan Nomor Polisi : ");
                        String plate = sc.next();

                        System.out.print("Masukkan Lama Parkir (Jam) : ");
                        int hours = sc.nextInt();

                        System.out.print("Pilih tipe (1=Mobil, 2=Motor, 3=Truk): ");
                        int type = sc.nextInt();

                        Vehicle v;
                        if (type == 1) {
                            v = new Car(plate, hours);
                        } else if (type == 2) {
                            v = new Motorcycle(plate, hours);
                        } else if (type == 3) {
                            v = new Truck(plate, hours);
                        } else {
                            throw new IllegalArgumentException("Tipe kendaraan tidak valid");
                        }

                        manager.addVehicle(v);
                        System.out.println("=================================================");
                        break;
                    }
                    case 2: {
                        System.out.println("\n--- Tampilkan Kendaraan ---");
                        manager.showVehicles();
                        System.out.println();
                        break;
                    }
                    case 3: {
                        double income = manager.calculateIncome();
                        System.out.println("=================================================");
                        System.out.println("                TOTAL PENDAPATAN");
                        System.out.println("=================================================");
                        System.out.println("Total Pendapatan Parkir :");
                        System.out.println("Rp " + String.format("%.0f", income));
                        System.out.println("=================================================");
                        System.out.println();
                        break;
                    }
                    default:
                        System.out.println("Pilihan tidak tersedia. Pilih angka 1-4.\n");
                }
            } catch (ParkingException e) {
                System.out.println("Error: " + e.getMessage() + "\n");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage() + "\n");
            }
        }

        sc.close();
    }
}

