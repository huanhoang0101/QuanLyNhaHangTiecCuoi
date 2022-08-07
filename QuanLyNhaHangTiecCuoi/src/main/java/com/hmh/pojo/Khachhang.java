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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HoanTran
 */
@Entity
@Table(name = "khachhang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Khachhang.findAll", query = "SELECT k FROM Khachhang k"),
    @NamedQuery(name = "Khachhang.findByMaKH", query = "SELECT k FROM Khachhang k WHERE k.maKH = :maKH"),
    @NamedQuery(name = "Khachhang.findByTenKH", query = "SELECT k FROM Khachhang k WHERE k.tenKH = :tenKH"),
    @NamedQuery(name = "Khachhang.findByGioiTInh", query = "SELECT k FROM Khachhang k WHERE k.gioiTInh = :gioiTInh"),
    @NamedQuery(name = "Khachhang.findByS\u0111t", query = "SELECT k FROM Khachhang k WHERE k.s\u0111t = :s\u0111t"),
    @NamedQuery(name = "Khachhang.findByEmail", query = "SELECT k FROM Khachhang k WHERE k.email = :email"),
    @NamedQuery(name = "Khachhang.findByTaiKhoan", query = "SELECT k FROM Khachhang k WHERE k.taiKhoan = :taiKhoan"),
    @NamedQuery(name = "Khachhang.findByMatKhau", query = "SELECT k FROM Khachhang k WHERE k.matKhau = :matKhau"),
    @NamedQuery(name = "Khachhang.findByAvatar", query = "SELECT k FROM Khachhang k WHERE k.avatar = :avatar")})
public class Khachhang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaKH")
    private Integer maKH;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "TenKH")
    private String tenKH;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "GioiTInh")
    private String gioiTInh;
    @Basic(optional = false)
    @NotNull
    @Column(name = "S\u0110T")
    private int sđt;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "TaiKhoan")
    private String taiKhoan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "MatKhau")
    private String matKhau;
    @Size(max = 100)
    @Column(name = "Avatar")
    private String avatar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "khachhangMaKH")
    private Set<Hoadon> hoadonSet;

    public Khachhang() {
    }

    public Khachhang(Integer maKH) {
        this.maKH = maKH;
    }

    public Khachhang(Integer maKH, String tenKH, String gioiTInh, int sđt, String email, String taiKhoan, String matKhau) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.gioiTInh = gioiTInh;
        this.sđt = sđt;
        this.email = email;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
    }

    public Integer getMaKH() {
        return maKH;
    }

    public void setMaKH(Integer maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getGioiTInh() {
        return gioiTInh;
    }

    public void setGioiTInh(String gioiTInh) {
        this.gioiTInh = gioiTInh;
    }

    public int getSđt() {
        return sđt;
    }

    public void setSđt(int sđt) {
        this.sđt = sđt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @XmlTransient
    public Set<Hoadon> getHoadonSet() {
        return hoadonSet;
    }

    public void setHoadonSet(Set<Hoadon> hoadonSet) {
        this.hoadonSet = hoadonSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maKH != null ? maKH.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Khachhang)) {
            return false;
        }
        Khachhang other = (Khachhang) object;
        if ((this.maKH == null && other.maKH != null) || (this.maKH != null && !this.maKH.equals(other.maKH))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tmh.pojo.Khachhang[ maKH=" + maKH + " ]";
    }
    
}
