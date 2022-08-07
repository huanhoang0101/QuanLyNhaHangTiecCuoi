/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HoanTran
 */
@Entity
@Table(name = "hoadon")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hoadon.findAll", query = "SELECT h FROM Hoadon h"),
    @NamedQuery(name = "Hoadon.findByMaHD", query = "SELECT h FROM Hoadon h WHERE h.maHD = :maHD"),
    @NamedQuery(name = "Hoadon.findByNgayToChuc", query = "SELECT h FROM Hoadon h WHERE h.ngayToChuc = :ngayToChuc"),
    @NamedQuery(name = "Hoadon.findByTongCong", query = "SELECT h FROM Hoadon h WHERE h.tongCong = :tongCong"),
    @NamedQuery(name = "Hoadon.findByNote", query = "SELECT h FROM Hoadon h WHERE h.note = :note"),
    @NamedQuery(name = "Hoadon.findByNgayLap", query = "SELECT h FROM Hoadon h WHERE h.ngayLap = :ngayLap")})
public class Hoadon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaHD")
    private Integer maHD;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NgayToChuc")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayToChuc;
    @Column(name = "TongCong")
    private Integer tongCong;
    @Size(max = 100)
    @Column(name = "Note")
    private String note;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NgayLap")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayLap;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hoadonMaHD")
    private Set<Hoadonmonan> hoadonmonanSet;
    @JoinColumn(name = "chitietsanh_MaChiTiet", referencedColumnName = "MaChiTiet")
    @ManyToOne(optional = false)
    private Chitietsanh chitietsanhMaChiTiet;
    @JoinColumn(name = "khachhang_MaKH", referencedColumnName = "MaKH")
    @ManyToOne(optional = false)
    private Khachhang khachhangMaKH;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hoadonMaHD")
    private Set<Hoadondichvu> hoadondichvuSet;

    public Hoadon() {
    }

    public Hoadon(Integer maHD) {
        this.maHD = maHD;
    }

    public Hoadon(Integer maHD, Date ngayToChuc, Date ngayLap) {
        this.maHD = maHD;
        this.ngayToChuc = ngayToChuc;
        this.ngayLap = ngayLap;
    }

    public Integer getMaHD() {
        return maHD;
    }

    public void setMaHD(Integer maHD) {
        this.maHD = maHD;
    }

    public Date getNgayToChuc() {
        return ngayToChuc;
    }

    public void setNgayToChuc(Date ngayToChuc) {
        this.ngayToChuc = ngayToChuc;
    }

    public Integer getTongCong() {
        return tongCong;
    }

    public void setTongCong(Integer tongCong) {
        this.tongCong = tongCong;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    @XmlTransient
    public Set<Hoadonmonan> getHoadonmonanSet() {
        return hoadonmonanSet;
    }

    public void setHoadonmonanSet(Set<Hoadonmonan> hoadonmonanSet) {
        this.hoadonmonanSet = hoadonmonanSet;
    }

    public Chitietsanh getChitietsanhMaChiTiet() {
        return chitietsanhMaChiTiet;
    }

    public void setChitietsanhMaChiTiet(Chitietsanh chitietsanhMaChiTiet) {
        this.chitietsanhMaChiTiet = chitietsanhMaChiTiet;
    }

    public Khachhang getKhachhangMaKH() {
        return khachhangMaKH;
    }

    public void setKhachhangMaKH(Khachhang khachhangMaKH) {
        this.khachhangMaKH = khachhangMaKH;
    }

    @XmlTransient
    public Set<Hoadondichvu> getHoadondichvuSet() {
        return hoadondichvuSet;
    }

    public void setHoadondichvuSet(Set<Hoadondichvu> hoadondichvuSet) {
        this.hoadondichvuSet = hoadondichvuSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maHD != null ? maHD.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hoadon)) {
            return false;
        }
        Hoadon other = (Hoadon) object;
        if ((this.maHD == null && other.maHD != null) || (this.maHD != null && !this.maHD.equals(other.maHD))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tmh.pojo.Hoadon[ maHD=" + maHD + " ]";
    }
    
}
