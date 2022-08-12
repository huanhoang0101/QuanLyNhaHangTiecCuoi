/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.pojo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HoanTran
 */
@Entity
@Table(name = "menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m"),
    @NamedQuery(name = "Menu.findByMaMenu", query = "SELECT m FROM Menu m WHERE m.maMenu = :maMenu"),
    @NamedQuery(name = "Menu.findByTenMon", query = "SELECT m FROM Menu m WHERE m.tenMon = :tenMon"),
    @NamedQuery(name = "Menu.findByLoaiMon", query = "SELECT m FROM Menu m WHERE m.loaiMon = :loaiMon"),
    @NamedQuery(name = "Menu.findByGia", query = "SELECT m FROM Menu m WHERE m.gia = :gia"),
    @NamedQuery(name = "Menu.findByImage", query = "SELECT m FROM Menu m WHERE m.image = :image")})
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaMenu")
    private Integer maMenu;
    @Basic(optional = false)
    @NotNull(message = "{monAn.name.err}")
    @Column(name = "TenMon")
    private String tenMon;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "LoaiMon")
    private String loaiMon;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Gia")
    @Min(value = 10000, message = "{monAn.price.minErr}")
    @Max(value = 10000000, message = "{monAn.price.maxErr}")
    private long gia;
    @Size(max = 100)
    @Column(name = "image")
    private String image;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menuMaMenu")
    private Set<Hoadonmonan> hoadonmonanSet;

    public Menu() {
    }

    public Menu(Integer maMenu) {
        this.maMenu = maMenu;
    }

    public Menu(Integer maMenu, String tenMon, String loaiMon, long gia) {
        this.maMenu = maMenu;
        this.tenMon = tenMon;
        this.loaiMon = loaiMon;
        this.gia = gia;
    }

    public Integer getMaMenu() {
        return maMenu;
    }

    public void setMaMenu(Integer maMenu) {
        this.maMenu = maMenu;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public String getLoaiMon() {
        return loaiMon;
    }

    public void setLoaiMon(String loaiMon) {
        this.loaiMon = loaiMon;
    }

    public long getGia() {
        return gia;
    }

    public void setGia(long gia) {
        this.gia = gia;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @XmlTransient
    public Set<Hoadonmonan> getHoadonmonanSet() {
        return hoadonmonanSet;
    }

    public void setHoadonmonanSet(Set<Hoadonmonan> hoadonmonanSet) {
        this.hoadonmonanSet = hoadonmonanSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maMenu != null ? maMenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.maMenu == null && other.maMenu != null) || (this.maMenu != null && !this.maMenu.equals(other.maMenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hmh.pojo.Menu[ maMenu=" + maMenu + " ]";
    }
    
}
