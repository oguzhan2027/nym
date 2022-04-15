/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Oguzhan
 */
public class urun {
    private int id;
    private kategori kategori;
    private String isim;
    private int fiyat;
    private int stok;

    public urun() {
    }

    public urun(int id, String isim) {
        this.id = id;
        this.isim = isim;
    }

    public urun(int id, kategori kategori, String isim, int fiyat, int stok) {
        this.id = id;
        this.kategori = kategori;
        this.isim = isim;
        this.fiyat = fiyat;
        this.stok = stok;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public kategori getKategori() {
        return kategori;
    }

    public void setKategori(kategori kategori) {
        this.kategori = kategori;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final urun other = (urun) obj;
        return this.id == other.id;
    }
    
    
   
    
    
    
}
