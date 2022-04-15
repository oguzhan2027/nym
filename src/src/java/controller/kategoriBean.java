package controller;

import dao.kategoriDAO;
import entity.kategori;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;


@Named(value = "kategoriBean")
@SessionScoped
public class kategoriBean implements Serializable {

    private kategori entity;
    private kategoriDAO dao;
    private List<kategori> list;

    public kategoriBean() {
    }

    public String getTitle(int id) {
        kategori k = this.getDao().findByID(id);
        return k.getIsim();
    }

    public void create() {
        this.getDao().create(entity);
        entity = new kategori();
    }

    public void update() {
        this.getDao().update(entity);
        entity = new kategori();
    }

    public void delete(kategori k) {
        this.getDao().delete(k);
        entity = new kategori();
    }

    public void clear() {
        entity = new kategori();
    }

    public kategori getEntity() {
        if (this.entity == null) {
            this.entity = new kategori();
        }
        return entity;
    }

    public void setEntity(kategori entity) {
        this.entity = entity;
    }

    public kategoriDAO getDao() {
        if (this.dao == null) {
            this.dao = new kategoriDAO();
        }
        return dao;
    }

    public void setDao(kategoriDAO dao) {
        this.dao = dao;
    }

    public List<kategori> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<kategori> list) {
        this.list = list;
    }
}