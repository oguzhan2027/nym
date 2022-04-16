
package dao;


import entity.satis;
import entity.urun;
import entity.musteri;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class satisDAO extends DBConnection {

    private urunDAO urunDao;
    private musteriDAO musteriDao;
   
    

    public satis findByID(int id) {
        satis s = null;

        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from satis where id=" + id;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                s = new satis(rs.getInt("id"), rs.getString("satisismi"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return s;
    }

    public void create(satis s) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "insert into satis (urun_id,musteri_id,satisismi,satistarihi) values (" + s.getUrun().getId() + "," + s.getMusteri().getId() + ",'" + s.getSatisismi()+ "','" + s.getSatistarihi() + "')";
            st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void update(satis s) {
        try { 
            Statement st = this.getConnection().createStatement();
            String query = "update satis set urun_id=" + s.getUrun().getId() + ",satisismi='" + s.getSatisismi() + "',satistarihi='" + s.getSatistarihi() + "'where id=" + s.getId();//idyi silebilirim
            st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void delete(satis s) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "delete from satis where id=" + s.getId();
            st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

    public List<satis> getList() {
        List<satis> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from satis";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                urun u = this.getUrunDao().findByID(rs.getInt("urun_id"));
                musteri m = this.getMusteriDao().findByID(rs.getInt("musteri_id"));
               
                list.add(new satis(rs.getInt("id"), u, m,rs.getString("satismi"), rs.getString("satistarihi")));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return list;
    }

    public urunDAO getUrunDao() {
        if (urunDao == null) {
            this.urunDao = new urunDAO();
        }
        return urunDao;
    }

    public void setUrunDao(urunDAO urunDao) {
        this.urunDao = urunDao;
    }

    public musteriDAO getMusteriDao() {
        return musteriDao;
    }

    public void setMusteriDao(musteriDAO musteriDao) {
        this.musteriDao = musteriDao;
    }
    
    

    

}
