/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DEV_PROJECT;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class TransactionGasStation {
     //public static void main(String[] args) {
    public static void main() {
        Scanner input = new Scanner(System.in);

        // Variable needed
        String pilihanBB;
        String paymentMethod;
        int liter;
        int hargaSementara;
        int discountMembers;
        int hargaAkhir;

        // Selecting fuel type
        System.out.println("-> Silahkan Pilih Sesuai dengan Kendaraan Anda");
        System.out.println("  1. Standard - 92 Oktan");
        System.out.println("  2. Diesel - CN 48");
        System.out.println("  3. Ultimate - 95 Oktan");
        System.out.print("Pilih jenis bahan bakar (1/2/3): ");
        int jenisBahanBakar = input.nextInt();

        double hargaPerLiter = 0;
        String jenisBahanBakarStr = "";

        switch (jenisBahanBakar) {
            case 1:
                hargaPerLiter = 14300;
                jenisBahanBakarStr = "Standard - 92 Oktan";
                break;
            case 2:
                hargaPerLiter = 15230;
                jenisBahanBakarStr = "Diesel - CN 48";
                break;
            case 3:
                hargaPerLiter = 15230;
                jenisBahanBakarStr = "Ultimate - 95 Oktan";
                break;
            default:
                System.out.println("Pilihan tidak valid!");
                return;
        }

        // Input liter yang dibutuhkan
        System.out.print("Masukkan jumlah liter yang dibutuhkan: ");
        liter = input.nextInt();

        // Hitung harga total
        int hargaTotal = (int) (hargaPerLiter * liter);

        // Selecting payment method
        System.out.println("--> Harga Total : Rp. " + hargaTotal);
        System.out.println("--> Pilih Jenis Pembayaran :");
        System.out.println("  1. Cashier");
        System.out.println("  2. Gopay");
        System.out.println("  3. OvO");
        System.out.println("  4. Dana");
        System.out.println("  5. Bank");
        System.out.print("Pilih jenis pembayaran (1/2/3/4/5): ");
        int jenisPembayaran = input.nextInt();

        String jenisPembayaranStr = "";
        switch (jenisPembayaran) {
            case 1:
                jenisPembayaranStr = "Cashier";
                break;
            case 2:
                jenisPembayaranStr = "Gopay";
                break;
            case 3:
                jenisPembayaranStr = "OvO";
                break;
            case 4:
                jenisPembayaranStr = "Dana";
                break;
            case 5:
                jenisPembayaranStr = "Bank";
                break;
            default:
                System.out.println("Pilihan tidak valid!");
                return;
        }

        if (jenisPembayaranStr.equals("Gopay") || jenisPembayaranStr.equals("OvO") || jenisPembayaranStr.equals("Dana")) {
            String id;
            do {
                System.out.print("Masukkan ID Anda: ");
                input.nextLine(); // Consume newline left-over
                id = input.nextLine();
                if (id.trim().isEmpty()) {
                    System.out.println("Tolong Masukkan ID Anda!");
                }
            } while (id.trim().isEmpty());
        } else if (jenisPembayaranStr.equals("Bank")) {
            System.out.println("Pilihan Bank:");
            System.out.println("1. BCA");
            System.out.println("2. BNI");
            System.out.println("3. BRI");
            System.out.println("4. BSI");
            System.out.println("5. Mandiri");
            System.out.print("Pilih Bank (1/2/3/4/5): ");
            int bankChoice = input.nextInt();
            input.nextLine(); // Consume newline left-over
            String bankName = "";
            switch (bankChoice) {
                case 1:
                    bankName = "BCA";
                    break;
                case 2:
                    bankName = "BNI";
                    break;
                case 3:
                    bankName = "BRI";
                    break;
                case 4:
                    bankName = "BSI";
                    break;
                case 5:
                    bankName = "Mandiri";
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
                    return;
            }
            String bankMethod;
            do {
                System.out.print("Masukkan metode pembayaran (Kredit/Debit): ");
                bankMethod = input.nextLine().toUpperCase();
                if (bankMethod.trim().isEmpty()) {
                    System.out.println("Tolong Masukkan Metode Pembayaran Anda!");
                }
            } while (bankMethod.trim().isEmpty());

            int adminFee = 1500; // Admin fee for both credit and debit
            int additionalFee = 0; // Additional fee for credit
            if (bankMethod.equals("KREDIT")) {
                // Additional fee for credit
                additionalFee = (int) Math.ceil(hargaTotal / 10000) * 2500;
            }
            int totalBankPayment = hargaTotal + adminFee + additionalFee;

            System.out.println("Metode pembayaran: " + bankMethod);
            System.out.println("Bank: " + bankName);
            System.out.println("Biaya Admin: Rp. " + adminFee);
            if (bankMethod.equals("KREDIT")) {
                System.out.println("Biaya Tambahan (Kredit): Rp. " + additionalFee);
            }
            System.out.println("Total Pembayaran: Rp. " + totalBankPayment);

            String pin;
            do {
                System.out.print("Masukkan PIN Anda: ");
                pin = input.nextLine();
                if (pin.trim().isEmpty()) {
                    System.out.println("Tolong Masukkan PIN Anda!");
                }
            } while (pin.trim().isEmpty());
            
            System.out.println("Pembayaran Sukses!");
        }

        input.close();
        System.out.println("Terima Kasih telah melakukan Service dan Pengisian Bahan Bakar di Gas Stattion ");

        System.exit(0);
    }

}
