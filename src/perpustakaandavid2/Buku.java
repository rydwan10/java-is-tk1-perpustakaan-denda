/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perpustakaandavid2;

/**
 *
 * @author muhammadrydwan
 */
public class Buku {
    private String namaBuku;
    private int kategori;

    public Buku(String namaBuku, int kategori) {
        this.namaBuku = namaBuku;
        this.kategori = kategori;
    }

    public String getNamaBuku() {
        return namaBuku;
    }

    public int getKategori() {
        return kategori;
    }
}
