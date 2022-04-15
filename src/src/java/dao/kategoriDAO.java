/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.kategori;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class kategoriDAO extends DBConnection {

    public kategori findByID(int id) {
        kategori k = null;

        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from kategori where id=" + id;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                k = new kategori(rs.getInt("id"), rs.getString("isim"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return k;
    }

    public void create(kategori k) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "insert into kategori (isim) values ('"+ k.getIsim() + "')";
            st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void update(kategori k) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update kategori set isim='" + k.getIsim() + "'where id=" + k.getId();
            st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void delete(kategori k) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "delete from kategori where id=" + k.getId();
            st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

    public List<kategori> getList() {
        List<kategori> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from kategori";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                list.add(new kategori(rs.getInt("id"), rs.getString("ad")));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return list;
    }

}