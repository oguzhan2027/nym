/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.urunlerDAO;
import entity.urunler;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;


@FacesConverter("urunlerConverter")
public class urunlerConverter implements Converter{

    private urunlerDAO urunlerDao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id = Integer.valueOf(string);
        urunler u = this.getUrunlerDao().findByID(id);
        return u;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        urunler u = (urunler) t;
        return String.valueOf(u.getId());
    }

    public urunlerDAO getUrunlerDao() {
        if (urunlerDao == null) {
            this.urunlerDao = new urunlerDAO();
        }
        return urunlerDao;
    }

    public void setUrunlerDao(urunlerDAO urunlerDao) {
        this.urunlerDao = urunlerDao;
    }

}
