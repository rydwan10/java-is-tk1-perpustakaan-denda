/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package perpustakaandavid2;

import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 *
 * @author muhammadrydwan
 */

// Kelas Perpustakaan untuk mengelola peminjaman dan perhitungan denda
class PerpustakaanDavid2 {
    private static final int BATAS_WAKTU_PINJAM = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("d MMMM yyyy");

        do {
            // Ambil data input dari user
            System.out.print("Nama: ");
            String nama = scanner.nextLine();

            System.out.print("Nama Buku: ");
            String namaBuku = scanner.nextLine();

            int kategori;
            do {
                System.out.print("Pilih Kategori (1. Pelajaran, 2. Novel, 3. Skripsi): ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Masukkan angka yang valid.");
                    System.out.print("Pilih Kategori (1. Pelajaran, 2. Novel, 3. Skripsi): ");
                    scanner.next();
                }
                kategori = scanner.nextInt();
                if (kategori < 1 || kategori > 3) {
                    System.out.println("Kategori tidak valid. Silakan masukkan kategori yang sesuai.");
                }
            } while (kategori < 1 || kategori > 3);

            // Input tanggal awal dan akhir pinjaman dengan perulangan agar memastikan input sesuai
            String awalPinjamStr, akhirPinjamStr;
            do {
                System.out.print("Tanggal Awal Pinjam (Format: DD-MM-YYYY): ");
                awalPinjamStr = scanner.next();
            } while (!Perhitungan.isValidFormat("dd-MM-yyyy", awalPinjamStr));

            do {
                System.out.print("Tanggal Akhir Pinjam (Format: DD-MM-YYYY): ");
                akhirPinjamStr = scanner.next();
            } while (!Perhitungan.isValidFormat("dd-MM-yyyy", akhirPinjamStr));

            // Buat objek Buku dan Peminjaman
            Buku buku = new Buku(namaBuku, kategori);
            Peminjaman peminjaman = new Peminjaman(nama, buku, awalPinjamStr, akhirPinjamStr);

            // Hitung denda
            int denda = Perhitungan.hitungDenda(peminjaman);

            // Tampilkan hasil
            System.out.println("\n=== Detail Peminjaman ===");
            System.out.println("Nama: " + peminjaman.getNama());
            System.out.println("Nama Buku: " + peminjaman.getBuku().getNamaBuku());
            System.out.println("Kategori: " + peminjaman.getBuku().getKategori());
            System.out.println("Awal Pinjam: " + outputDateFormat.format(Perhitungan.parseDate(peminjaman.getAwalPinjamStr())));
            System.out.println("Akhir Pinjam: " + outputDateFormat.format(Perhitungan.parseDate(peminjaman.getAkhirPinjamStr())));

            if (denda > 0) {
                long hariKeterlambatan = Perhitungan.hitungSelisihHari(peminjaman.getAwalPinjamStr(), peminjaman.getAkhirPinjamStr());
                System.out.println("\nAnda melewati batas waktu pinjam selama " + hariKeterlambatan + " hari dan dikenakan denda sebesar Rp" + denda + ".");
            } else {
                System.out.println("\nTerima kasih, Anda mengembalikan buku tepat waktu.");
            }

            // Meminta input untuk mengulangi atau mengakhiri program
            System.out.print("\nIngin meminjam buku lagi? (Y/N): ");
            String ulangi = scanner.next().toUpperCase();

            // Mengulangi program atau mengakhiri program
            if (!ulangi.equals("Y")) {
                break;
            }

            // Membersihkan newline yang tersisa di buffer
            scanner.nextLine();

        } while (true);

        System.out.println("Terima kasih telah menggunakan program ini. Sampai jumpa!");
    }

    
}
