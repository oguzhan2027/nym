package converter;


import dao.musteriDAO;
import entity.musteri;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author tr
 */ 
@FacesConverter("musteriConverter")
public class musteriConverter implements Converter {

    private musteriDAO musteriDao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id = Integer.valueOf(string);
        musteri m = this.getmusteriDao().findByID(id);
        return m;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        musteri m = (musteri) t;
        return String.valueOf(m.getId());
    }

    public musteriDAO getmusteriDao() {
        if (musteriDao == null) {
            this.musteriDao = new musteriDAO();
        }
        return musteriDao;
    }

    public void setmusteriDao(musteriDAO musteriDao) {
        this.musteriDao = musteriDao;
    }

}