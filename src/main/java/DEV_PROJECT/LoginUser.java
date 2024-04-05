/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DEV_PROJECT;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class LoginUser {
    private String username;
    private String email;
    private String password;
    private List<String> loginHistory;

    public LoginUser() {
        loginHistory = new ArrayList<>();
    }

    public void signUp(String email, String password) {
        if (this.email != null && this.password != null) {
            System.out.println("Anda tidak perlu Sign Up, harap Login");
        } else {
            this.email = email;
            this.password = password;
            System.out.println("Sign Up berhasil! Anda akan diarahkan ke halaman utama.");
            // Arahkan pengguna ke halaman utama untuk mendaftarkan mobil
            registerCar();
        }
    }

    public void registerCar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Silakan daftarkan mobil Anda:");

        System.out.print("Plat Nomor: ");
        String platNomor = sc.nextLine(); // Menggunakan nextLine() agar bisa membaca spasi

        System.out.print("Merek Mobil: ");
        String merekMobil = sc.nextLine();

        System.out.print("Nama Pemilik: ");
        String namaPemilik = sc.nextLine();

        System.out.print("CC Mobil: ");
        String ccMobil = sc.nextLine();

        // Lakukan sesuatu dengan data mobil yang didaftarkan, misalnya menyimpan ke database
        System.out.println("Mobil berhasil didaftarkan!");

        // Tambahkan riwayat login
        loginHistory.add("Pendaftaran mobil dengan plat nomor " + platNomor);
    }

    public void printLoginHistory() {
        System.out.println("Riwayat Login:");
        for (String log : loginHistory) {
            System.out.println(log);
        }
    }

    public static void main(String[] args) {
        LoginUser app = new LoginUser();
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan email: ");
        String email = sc.next();

        System.out.print("Masukkan password: ");
        String password = sc.next();

        app.signUp(email, password);

        // Tampilkan riwayat login
        app.printLoginHistory();

        // Tutup scanner setelah digunakan
        sc.close();
    }
}
