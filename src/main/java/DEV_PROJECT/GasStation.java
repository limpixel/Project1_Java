/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DEV_PROJECT;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 */
// Implementasi Pre-order service car
public class GasStation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalHarga = 0;

        

        // Menu loop
        LoginUser.main();
        while (true) {
            // Menampilkan menu layanan
            ServiceApp.SerOpt();
            System.out.println("Apakah Isi Bensin ? :");
            System.out.println("1. Ya ");
            System.out.println("2. Tidak ");
            System.out.print("Pilih layanan (1-2): ");
            int pilihan = scanner.nextInt();

            // Membuat objek layanan
            //LayananMobil layananMobil = null;

            switch (pilihan) {
                case 1:
                    TransactionGasStation.main();
                    //System.out.println("Terima Kasih telah melakukan Service dan Pengisian Bahan Bakar di Gas Stattion ");
                    break;
                case 2:
                    // Keluar dari program
                    //System.out.println("Terima kasih!");
                    System.out.println("Terima kasih telah melakukan service di Gas Station");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid!");
                    break;
            }

            System.out.println("Total Harga Layanan: Rp. " + totalHarga);
        }
    }

    
}
