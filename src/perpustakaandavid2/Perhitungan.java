/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perpustakaandavid2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author muhammadrydwan
 */
public class Perhitungan {
    // 10 hari pertama gratis, seterusnya adalah denda perhari
     private static final int BATAS_WAKTU_PINJAM = 10;
     
    // Method untuk menghitung denda
    public static int hitungDenda(Peminjaman peminjaman) {
        int dendaPerHari;

        switch (peminjaman.getBuku().getKategori()) {
            case 1:
                dendaPerHari = 2000;
                break;
            case 2:
                dendaPerHari = 5000;
                break;
            case 3:
                dendaPerHari = 10000;
                break;
            default:
                System.out.println("Kategori buku tidak valid.");
                return 0;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date awalPinjam = dateFormat.parse(peminjaman.getAwalPinjamStr());
            Date akhirPinjam = dateFormat.parse(peminjaman.getAkhirPinjamStr());

            long selisihHari = (akhirPinjam.getTime() - awalPinjam.getTime()) / (24 * 60 * 60 * 1000);

            if (selisihHari > BATAS_WAKTU_PINJAM) {
                return (int) ((selisihHari - BATAS_WAKTU_PINJAM) * dendaPerHari);
            } else {
                return 0;
            }
        } catch (ParseException e) {
            System.out.println("Format tanggal tidak valid.");
            return 0;
        }
    }

    // Method untuk memeriksa format tanggal
    public static boolean isValidFormat(String format, String value) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(value);
            return true;
        } catch (ParseException e) {
            System.out.println("Format tanggal tidak valid. Silakan masukkan ulang.");
            return false;
        }
    }

    // Method parsing date untuk outputnya nanti
    public static Date parseDate(String dateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
    }

    // Method untung menghitung selisih hari awal pinjam dan akhir pinjam
    public static long hitungSelisihHari(String awalPinjamStr, String akhirPinjamStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date awalPinjam = dateFormat.parse(awalPinjamStr);
            Date akhirPinjam = dateFormat.parse(akhirPinjamStr);

            long selisihHari = (akhirPinjam.getTime() - awalPinjam.getTime()) / (24 * 60 * 60 * 1000);

            // Jika melewati batas waktu, hitung selisih dari batas waktu
            if (selisihHari > BATAS_WAKTU_PINJAM) {
                Date batasWaktu = new Date(awalPinjam.getTime() + (BATAS_WAKTU_PINJAM * 24 * 60 * 60 * 1000));
                selisihHari = (akhirPinjam.getTime() - batasWaktu.getTime()) / (24 * 60 * 60 * 1000);
            }

            return Math.max(0, selisihHari);
        } catch (ParseException e) {
            return 0;
        }
    }
}
