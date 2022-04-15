/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.urunDAO;
import entity.urun;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "urunBean")
@SessionScoped 
public class urunBean implements Serializable {

    private urun entity;
    private urunDAO dao;
    private List<urun> list;

    public urunBean() {
    }
  public String getTitle(int id) {
        urun c = this.getDao().findByID(id);
        return c.getIsim();
    }


    public void create() {
        this.getDao().create(entity);
        entity = new urun();
    }

    public void update() {
        this.getDao().update(entity);
        entity = new urun();
    }

    public void delete(urun p) {
        this.getDao().delete(p);
        entity = new urun();
    }

    public void clear() {
        entity = new urun();
    }

    public urun getEntity() {
        if (this.entity == null) {
            this.entity = new urun();
        }
        return entity;
    }

    public void setEntity(urun entity) {
        this.entity = entity;
    }

    public urunDAO getDao() {
        if (this.dao == null) {
            this.dao = new urunDAO();
        }
        return dao;
    }

    public void setDao(urunDAO dao) {
        this.dao = dao;
    }

    public List<urun> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<urun> list) {
        this.list = list;
    }
}
