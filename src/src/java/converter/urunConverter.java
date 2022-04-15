/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.urunDAO;
import entity.urun;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;


@FacesConverter("urunConverter")
public class urunConverter implements Converter{

    private urunDAO urunDao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id = Integer.valueOf(string);
        urun u = this.getUrunDao().findByID(id);
        return u;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        urun u = (urun) t;
        return String.valueOf(u.getId());
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

}
