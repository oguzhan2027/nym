/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.musteriDAO;
import entity.musteri;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Oguzhan
 */
@Named(value = "musteriBean")
@SessionScoped
public class musteriBean implements Serializable {

    private musteri entity;
    private musteriDAO dao;
    private List<musteri> list;
    
     public musteriBean() {
    }

   

    public void create() {
        this.getDao().create(entity);
        entity = new musteri();
    }

    public void update() {
        this.getDao().update(entity);
        entity = new musteri();
    }

    public void delete(musteri m) {
        this.getDao().delete(m);
        entity = new musteri();
    }

    public void clear() {
        entity = new musteri();
    }

    public musteri getEntity() {
        if (this.entity == null) {
            this.entity = new musteri();
        }
        return entity;
    }

    public void setEntity(musteri entity) {
        this.entity = entity;
    }

    public musteriDAO getDao() {
        if (this.dao == null) {
            this.dao = new musteriDAO();
        }
        return dao;
    }

    public void setDao(musteriDAO dao) {
        this.dao = dao;
    }

    public List<musteri> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<musteri> list) {
        this.list = list;
    }
    
}

    

