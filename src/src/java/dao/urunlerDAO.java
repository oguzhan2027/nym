
package dao;


import entity.kategori;
import entity.urunler;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class urunlerDAO extends DBConnection {

    private kategoriDAO kategoriDao;
   
    

    public urunler findByID(int id) {
        urunler u = null;

        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from urunler where id=" + id;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                u = new urunler(rs.getInt("id"), rs.getString("isim"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return u;
    }

    public void create(urunler u) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "insert into urunler (kategori_id,isim,fiyat,stok) values (" + u.getKategori().getId() + ",'" + u.getIsim()+ "','" + u.getFiyat() + "','" + u.getStok() + "')";
            st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void update(urunler u) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update urunler set kategori_id=" + u.getKategori().getId() + ",isim='" + u.getIsim() + "',fiyat='" + u.getFiyat() + "',stok='" + u.getStok() + "'where id=" + u.getId();//idyi silebilirim
            st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void delete(urunler u) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "delete from urunler where id=" + u.getId();
            st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

    public List<urunler> getList() {
        List<urunler> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from urunler";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                kategori k = this.getKategoriDao().findByID(rs.getInt("kategori_id"));
                list.add(new urunler(rs.getInt("id"), k, rs.getString("isim"), rs.getInt("fiyat"),rs.getInt("stok")));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return list;
    }

    public kategoriDAO getKategoriDao() {
        if (kategoriDao == null) {
            this.kategoriDao = new kategoriDAO();
        }
        return kategoriDao;
    }

    public void setKategoriDao(kategoriDAO kategoriDao) {
        this.kategoriDao = kategoriDao;
    }

    

}
