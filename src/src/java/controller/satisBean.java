/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.satisDAO;
import entity.satis;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "satisBean")
@SessionScoped 
public class satisBean implements Serializable {

    private satis entity;
    private satisDAO dao;
    private List<satis> list;

    public satisBean() {
    }
  public String getTitle(int id) {
        satis c = this.getDao().findByID(id);
        return c.getSatisismi();
    }


    public void create() {
        this.getDao().create(entity);
        entity = new satis();
    }

    public void update() {
        this.getDao().update(entity);
        entity = new satis();
    }

    public void delete(satis p) {
        this.getDao().delete(p);
        entity = new satis();
    }

    public void clear() {
        entity = new satis();
    }

    public satis getEntity() {
        if (this.entity == null) {
            this.entity = new satis();
        }
        return entity;
    }

    public void setEntity(satis entity) {
        this.entity = entity;
    }

    public satisDAO getDao() {
        if (this.dao == null) {
            this.dao = new satisDAO();
        }
        return dao;
    }

    public void setDao(satisDAO dao) {
        this.dao = dao;
    }

    public List<satis> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<satis> list) {
        this.list = list;
    }
}
