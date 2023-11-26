/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perpustakaandavid2;

/**
 *
 * @author muhammadrydwan
 */
public class Peminjaman {
    private String nama;
    private Buku buku;
    private String awalPinjamStr;
    private String akhirPinjamStr;

    public Peminjaman(String nama, Buku buku, String awalPinjamStr, String akhirPinjamStr) {
        this.nama = nama;
        this.buku = buku;
        this.awalPinjamStr = awalPinjamStr;
        this.akhirPinjamStr = akhirPinjamStr;
    }

    public String getNama() {
        return nama;
    }

    public Buku getBuku() {
        return buku;
    }

    public String getAwalPinjamStr() {
        return awalPinjamStr;
    }

    public String getAkhirPinjamStr() {
        return akhirPinjamStr;
    }
}
