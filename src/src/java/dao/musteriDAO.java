
package dao;


import entity.musteri;
import entity.urun;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class musteriDAO extends DBConnection {

   
   
    

    public musteri findByID(int id) {
        musteri m = null;

        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from musteri where id=" + id;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                m = new musteri(rs.getInt("id"), rs.getString("isim"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return m;
    }

    public void create(musteri m ) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "insert into musteri (isim,soyisim,tlf) values ('" + m.getIsim()+ "','" + m.getSoyisim() + "','" + m.getTlf() + "')";
            st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void update(musteri m) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update musteri set isim='" + "',isim='" + m.getIsim() + "',soyisim='" + m.getSoyisim() + "',tlf='" + m.getTlf();//idyi silebilirim
            st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void delete(musteri m) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "delete from musteri where id=" + m.getId();
            st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

    public List<musteri> getList() {
        List<musteri> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from musteri";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                list.add(new musteri(rs.getInt("id"), rs.getString("isim")));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return list;
    }

   

    

}
