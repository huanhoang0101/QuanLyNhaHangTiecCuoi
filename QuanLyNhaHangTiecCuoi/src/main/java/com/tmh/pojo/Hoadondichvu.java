/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tmh.pojo;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HoanTran
 */
@Entity
@Table(name = "hoadondichvu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hoadondichvu.findAll", query = "SELECT h FROM Hoadondichvu h"),
    @NamedQuery(name = "Hoadondichvu.findByMaHDDV", query = "SELECT h FROM Hoadondichvu h WHERE h.maHDDV = :maHDDV")})
public class Hoadondichvu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaHDDV")
    private Integer maHDDV;
    @JoinColumn(name = "dichvu_MaDV", referencedColumnName = "MaDV")
    @ManyToOne(optional = false)
    private Dichvu dichvuMaDV;
    @JoinColumn(name = "hoadon_MaHD", referencedColumnName = "MaHD")
    @ManyToOne(optional = false)
    private Hoadon hoadonMaHD;

    public Hoadondichvu() {
    }

    public Hoadondichvu(Integer maHDDV) {
        this.maHDDV = maHDDV;
    }

    public Integer getMaHDDV() {
        return maHDDV;
    }

    public void setMaHDDV(Integer maHDDV) {
        this.maHDDV = maHDDV;
    }

    public Dichvu getDichvuMaDV() {
        return dichvuMaDV;
    }

    public void setDichvuMaDV(Dichvu dichvuMaDV) {
        this.dichvuMaDV = dichvuMaDV;
    }

    public Hoadon getHoadonMaHD() {
        return hoadonMaHD;
    }

    public void setHoadonMaHD(Hoadon hoadonMaHD) {
        this.hoadonMaHD = hoadonMaHD;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maHDDV != null ? maHDDV.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hoadondichvu)) {
            return false;
        }
        Hoadondichvu other = (Hoadondichvu) object;
        if ((this.maHDDV == null && other.maHDDV != null) || (this.maHDDV != null && !this.maHDDV.equals(other.maHDDV))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tmh.pojo.Hoadondichvu[ maHDDV=" + maHDDV + " ]";
    }
    
}
