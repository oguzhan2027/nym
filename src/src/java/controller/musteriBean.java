/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.musteriDAO;
import entity.musteri;
import java.util.List;

/**
 *
 * @author Oguzhan
 */
public class musteriBean {
    private musteri entity;
    private musteriDAO dao;
    private List<musteri> list;
    
     public musteriBean() {
    }

    public String getTitle(int id) {
        musteri m = this.getDao().findByID(id);
        return m.getIsim();
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
