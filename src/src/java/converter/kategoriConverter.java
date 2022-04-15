package converter;


import dao.kategoriDAO;
import entity.kategori;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author tr
 */
@FacesConverter("kategoriConverter")
public class kategoriConverter implements Converter {

    private kategoriDAO kategoriDao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id = Integer.valueOf(string);
        kategori k = this.getKategoriDao().findByID(id);
        return k;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        kategori k = (kategori) t;
        return String.valueOf(k.getId());
    }

    public kategoriDAO getKategoriDao() {
        if (kategoriDao == null) {
            this.kategoriDao = new kategoriDAO();
        }
        return kategoriDao;
    }

    public void sekategoriDao(kategoriDAO kategoriDao) {
        this.kategoriDao = kategoriDao;
    }

} 