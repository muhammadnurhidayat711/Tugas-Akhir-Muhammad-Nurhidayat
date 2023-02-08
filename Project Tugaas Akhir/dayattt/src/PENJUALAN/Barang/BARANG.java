/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package PENJUALAN.Barang;

import java.util.Date;



/**
 *
 * @author arya
 */
public class BARANG{
    private Long id;
    private String nama;
    private String jumlah;
    private String harga;
    private String garansi;
    private Date waktu;
    private String keterangan;
    
 

   

   
    public String getJumlah() {
       return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

      public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public String getGaransi() {
        return garansi;
    }

    public void setGaransi(String garansi) {
        this.garansi = garansi;
    }
    
    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Date getWaktu() {
        return waktu;
    }

    public void setWaktu(Date waktu) {
        this.waktu = waktu;
    }
    
}
