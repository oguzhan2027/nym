/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Oguzhan
 */
public class satis {
    private int id;
    private urun urun;
    private musteri musteri;
    private String satistarihi;
    private String satisismi;

    public satis() {
    }

    public satis(int id, String satisismi) {
        this.id = id;
        this.satisismi = satisismi;
    }

    public satis(int id, urun urun, musteri musteri, String satistarihi, String satisismi) {
        this.id = id;
        this.urun = urun;
        this.musteri = musteri;
        this.satistarihi = satistarihi;
        this.satisismi = satisismi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public urun getUrun() {
        return urun;
    }

    public void setUrun(urun urun) {
        this.urun = urun;
    }

    public musteri getMusteri() {
        return musteri;
    }

    public void setMusteri(musteri musteri) {
        this.musteri = musteri;
    }

    public String getSatistarihi() {
        return satistarihi;
    }

    public void setSatistarihi(String satistarihi) {
        this.satistarihi = satistarihi;
    }

    public String getSatisismi() {
        return satisismi;
    }

    public void setSatisismi(String satisismi) {
        this.satisismi = satisismi;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.id;
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
        final satis other = (satis) obj;
        return this.id == other.id;
    }
    
    
    
    
}
