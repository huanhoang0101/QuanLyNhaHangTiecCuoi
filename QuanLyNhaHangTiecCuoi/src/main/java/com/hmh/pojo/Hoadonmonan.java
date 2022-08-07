/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HoanTran
 */
@Entity
@Table(name = "hoadonmonan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hoadonmonan.findAll", query = "SELECT h FROM Hoadonmonan h"),
    @NamedQuery(name = "Hoadonmonan.findByMaHDMA", query = "SELECT h FROM Hoadonmonan h WHERE h.maHDMA = :maHDMA"),
    @NamedQuery(name = "Hoadonmonan.findBySoLuong", query = "SELECT h FROM Hoadonmonan h WHERE h.soLuong = :soLuong"),
    @NamedQuery(name = "Hoadonmonan.findByThanhTien", query = "SELECT h FROM Hoadonmonan h WHERE h.thanhTien = :thanhTien")})
public class Hoadonmonan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaHDMA")
    private Integer maHDMA;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SoLuong")
    private int soLuong;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ThanhTien")
    private int thanhTien;
    @JoinColumn(name = "hoadon_MaHD", referencedColumnName = "MaHD")
    @ManyToOne(optional = false)
    private Hoadon hoadonMaHD;
    @JoinColumn(name = "menu_MaMenu", referencedColumnName = "MaMenu")
    @ManyToOne(optional = false)
    private Menu menuMaMenu;

    public Hoadonmonan() {
    }

    public Hoadonmonan(Integer maHDMA) {
        this.maHDMA = maHDMA;
    }

    public Hoadonmonan(Integer maHDMA, int soLuong, int thanhTien) {
        this.maHDMA = maHDMA;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
    }

    public Integer getMaHDMA() {
        return maHDMA;
    }

    public void setMaHDMA(Integer maHDMA) {
        this.maHDMA = maHDMA;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }

    public Hoadon getHoadonMaHD() {
        return hoadonMaHD;
    }

    public void setHoadonMaHD(Hoadon hoadonMaHD) {
        this.hoadonMaHD = hoadonMaHD;
    }

    public Menu getMenuMaMenu() {
        return menuMaMenu;
    }

    public void setMenuMaMenu(Menu menuMaMenu) {
        this.menuMaMenu = menuMaMenu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maHDMA != null ? maHDMA.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hoadonmonan)) {
            return false;
        }
        Hoadonmonan other = (Hoadonmonan) object;
        if ((this.maHDMA == null && other.maHDMA != null) || (this.maHDMA != null && !this.maHDMA.equals(other.maHDMA))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hmh.pojo.Hoadonmonan[ maHDMA=" + maHDMA + " ]";
    }
    
}
