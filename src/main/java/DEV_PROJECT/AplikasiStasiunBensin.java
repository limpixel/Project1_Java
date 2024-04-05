/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DEV_PROJECT;

/**
 *
 * @author ASUS
 */
import java.util.Scanner;

// Kelas abstrak untuk Bahan Bakar
abstract class BahanBakar {
    protected double hargaPerLiter;

    public BahanBakar(double hargaPerLiter) {
        this.hargaPerLiter = hargaPerLiter;
    }

    public abstract double hitungBiaya(double liter);
}

// Kelas Petrol yang mewarisi BahanBakar
class Petrol extends BahanBakar {
    public Petrol(double hargaPerLiter) {
        super(hargaPerLiter);
    }

    @Override
    public double hitungBiaya(double liter) {
        return liter * hargaPerLiter;
    }
}

// Kelas Diesel yang mewarisi BahanBakar
class Diesel extends BahanBakar {
    public Diesel(double hargaPerLiter) {
        super(hargaPerLiter);
    }

    @Override
    public double hitungBiaya(double liter) {
        return liter * hargaPerLiter;
    }
}

// Kelas Pompa untuk pompa bahan bakar
class Pompa {
    private BahanBakar jenisBahanBakar;

    public Pompa(BahanBakar jenisBahanBakar) {
        this.jenisBahanBakar = jenisBahanBakar;
    }

    public double isiBahanBakar(double liter) {
        return jenisBahanBakar.hitungBiaya(liter);
    }
}

// Kelas StasiunBensin yang merepresentasikan stasiun bensin
class StasiunBensin {
    private Pompa pompaPetrol;
    private Pompa pompaDiesel;

    public StasiunBensin(Pompa pompaPetrol, Pompa pompaDiesel) {
        this.pompaPetrol = pompaPetrol;
        this.pompaDiesel = pompaDiesel;
    }

    public double isiPetrol(double liter) {
        return pompaPetrol.isiBahanBakar(liter);
    }

    public double isiDiesel(double liter) {
        return pompaDiesel.isiBahanBakar(liter);
    }
}

public class AplikasiStasiunBensin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Buat pompa petrol dan pompa diesel
        Petrol petrol = new Petrol(1.5); // Harga per liter petrol
        Diesel diesel = new Diesel(1.2); // Harga per liter diesel
        Pompa pompaPetrol = new Pompa(petrol);
        Pompa pompaDiesel = new Pompa(diesel);

        // Buat stasiun bensin
        StasiunBensin stasiunBensin = new StasiunBensin(pompaPetrol, pompaDiesel);

        // Interaksi dengan pengguna
        System.out.println("Selamat datang di Stasiun Bensin!");
        while (true) {
            System.out.println("Pilih opsi:");
            System.out.println("1. Isi Petrol");
            System.out.println("2. Isi Diesel");
            System.out.println("3. Keluar");

            int pilihan = scanner.nextInt();
            double liter;
            double biaya;
            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan liter petrol: ");
                    liter = scanner.nextDouble();
                    biaya = stasiunBensin.isiPetrol(liter);
                    System.out.println("Biaya untuk mengisi petrol: Rp" + biaya);
                    break;
                case 2:
                    System.out.print("Masukkan liter diesel: ");
                    liter = scanner.nextDouble();
                    biaya = stasiunBensin.isiDiesel(liter);
                    System.out.println("Biaya untuk mengisi diesel: Rp" + biaya);
                    break;
                case 3:
                    System.out.println("Terima kasih telah menggunakan layanan kami!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
}
