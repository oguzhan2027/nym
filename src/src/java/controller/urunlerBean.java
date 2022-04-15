/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.urunlerDAO;
import entity.urunler;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "urunlerBean")
@SessionScoped
public class urunlerBean implements Serializable {

    private urunler entity;
    private urunlerDAO dao;
    private List<urunler> list;

    public urunlerBean() {
    }
  public String getTitle(int id) {
        urunler c = this.getDao().findByID(id);
        return c.getIsim();
    }


    public void create() {
        this.getDao().create(entity);
        entity = new urunler();
    }

    public void update() {
        this.getDao().update(entity);
        entity = new urunler();
    }

    public void delete(urunler p) {
        this.getDao().delete(p);
        entity = new urunler();
    }

    public void clear() {
        entity = new urunler();
    }

    public urunler getEntity() {
        if (this.entity == null) {
            this.entity = new urunler();
        }
        return entity;
    }

    public void setEntity(urunler entity) {
        this.entity = entity;
    }

    public urunlerDAO getDao() {
        if (this.dao == null) {
            this.dao = new urunlerDAO();
        }
        return dao;
    }

    public void setDao(urunlerDAO dao) {
        this.dao = dao;
    }

    public List<urunler> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<urunler> list) {
        this.list = list;
    }
}
