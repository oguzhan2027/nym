/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.satisDAO;
import entity.satis;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;


@FacesConverter("satisConverter")
public class satisConverter implements Converter{

    private satisDAO satisDao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id = Integer.valueOf(string);
        satis s = this.getUrunDao().findByID(id);
        return s;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        satis s = (satis) t;
        return String.valueOf(s.getId());
    }

    public satisDAO getUrunDao() {
        if (satisDao == null) {
            this.satisDao = new satisDAO();
        }
        return satisDao;
    }

    public void setUrunDao(satisDAO satisDao) {
        this.satisDao = satisDao;
    }
 
}
